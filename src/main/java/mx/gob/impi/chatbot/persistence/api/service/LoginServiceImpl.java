/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot IMPI
 * Paquete:     mx.gob.impi.chatbot.persistence.api.service
 * Modulo:      Login
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del servicio de login
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.*;
import mx.gob.impi.chatbot.persistence.api.model.domain.*;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de login
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class LoginServiceImpl implements LoginService {
    private final static Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private UserRolMapper userRolMapper;
    
    @Autowired
    private UserAreaMapper userAreaMapper;
    
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private JwtManagerService jwtManagerService;
    
    @Autowired
    private ChatbotMailSenderService chatbotMailSenderService;
   
    @Autowired
    private CustomDigestEncoderService cde;
    
    @Value("${login.blokedWindowTime}")
    private long blokedWindowTime;
    
    @Value("${login.maxInvalidTries}")
    private int maxInvalidTries;
    
    @Value("${login.securityTokenWindow}")
    private long securityTokenWindow;
    
	@Value("${login.url-base}")
	private String urlBase;

	@Value("${login.url-auth}")
	private String urlAuth;

	@Value("${login.url-verifica}")
	private String urlVerifica;

    @Value("${login.url-front}")
    private String front;
    
    @Value("${login.url-front-ok}")
    private String frontOk;
    
    @Value("${login.url-front-bad}")
    private String frontBad;

    @Override
    public LoginResponse changePassword(String usr, String psw, String jwt) {
        if(jwtManagerService.verifyToken(jwt, usr)) {
            User user = userMapper.getUserByName(usr);
            if(user!=null) {
                String newPassword = cde.digest(psw, usr);
                user.setPassword(newPassword);
                user.setSecurityTokenWindow(0);
                user.setFailedAtemptCounter(0);
                userMapper.update(user);

                this.chatbotMailSenderService.sendHtmlMail(
                        user.getMail(), "Password Cambiado exitosamente", 
                        "Hola, "+user.getUsr()+" tu password ha cambiado." );
                
                LoginResponse loginResponse = new LoginResponse(usr, true, "Password cambiado, " + usr);
                loginResponse.setJwt(jwtManagerService.createToken(usr));
                return loginResponse;
            }
            return new LoginResponse(usr, false, "Usuario no existe !!");
        } else {
            return new LoginResponse(usr, false, "Token Inválido");
        }
    }
        
    @Override
    public LoginResponse login(String user, String password) {
        /* * /
        ok("root");
        ok("tavo");
        ok("tercero");
        ok("cuarto");
        ok("quinto");
        ok("sexto");
        /**/

        // Preparando un objeto de tipo User
        User usuario = null;
        // Primero revisamos si no existe una razón evidente por la cual no autenticar:
        try {
            evalErrorCondition(user==null || user.trim().length()<1,         "User vacío");
            evalErrorCondition(password==null || password.trim().length()<1, "Password vacío");
            
            usuario = userMapper.getUserByName(user);
            evalErrorCondition(usuario==null, "User no existe");
            evalErrorCondition(usuario.isExpiredAccount(), "Cuenta expirada");
            //evalErrorCondition(usuario.isBloquedAccount(), "Cuenta bloqueada");
            evalErrorCondition(usuario.isExpiredCredential(), "Credenciales expiradas");
            evalErrorCondition(usuario.isDisabled(), "User inhabilitado");
            long remanent = blokedWindowTime + usuario.getBloquedDate().getTime() - System.currentTimeMillis();
            long faltan = remanent/1000;
            String encodedPassword = cde.digest(password, user);
            
            if(faltan>0) {
            	evalErrorCondition(usuario.getFailedAtemptCounter()>maxInvalidTries, 
            			"Máximo numero de intentos alcanzado: "
			            + maxInvalidTries 
			            + " favor de intentar nuevamente en "
			            + faltan
			            +" segundos");
			} else if(usuario.getFailedAtemptCounter()>maxInvalidTries - 1){
                usuario.setFailedAtemptCounter(0);
                userMapper.updateFailure(usuario);
                usuario.setBloquedDate(new Date(1));
                userMapper.updateBlocked(usuario);
			}
                        
            if(encodedPassword.equals(usuario.getPassword())) {
            	Integer uid = usuario.getId();
            	List<Area> areas = userAreaMapper.getAreasFromUserId(uid);
            	List<Rol> roles = userRolMapper.getRolesFromUserId(uid);
                // Reset fallos previos
                usuario.setFailedAtemptCounter(0);
                usuario.setBloquedDate(new Date(System.currentTimeMillis()));
                userMapper.update(usuario);

                // Prepara y envía respuesta
                LoginResponse loginResponse = new LoginResponse(usuario.getFullName(), usuario.getUsr(), true, "Bienvenido, " + usuario.getUsr(), roles, areas);
                loginResponse.setJwt(jwtManagerService.createToken(user));
                return loginResponse;
            } else {
                int intentosActuales = usuario.getFailedAtemptCounter() + 1;
                usuario.setFailedAtemptCounter(intentosActuales);
                userMapper.updateFailure(usuario);
                
                if(intentosActuales<maxInvalidTries) {
                    throw new Exception("Invalid Password");
                } else {
                	//usuario.setBloquedAccount(true);
                    usuario.setBloquedDate(new Date(System.currentTimeMillis()));
                    userMapper.updateBlocked(usuario);
                    throw new Exception("Invalid Password. Cuenta bloqueada. Max alcanzado: " + maxInvalidTries);
                }
            }
        } catch(Exception e) {
            return new LoginResponse(user, false, e.getMessage());
        }
    }
    
    /**
     * Genera un hash del usuario dado
     * @param name Cadena con el nombre de usuario
     */
    public void buildHashForName(String name) {
        String digestWord = cde.digest("clave", name);
        logger.info("Digestión: "+digestWord);
        User user = userMapper.getUserByName(name);
        user.setPassword(digestWord);
        userMapper.update(user); 
    }
    
    /**
     * Genera una excepcion deacaurdo al resultado de 
     * la condicion previamente evaluda
     * @param condition Boleano con el resualtado de una
     *                  expresion previamente evaluda
     * @param msg Cadena con el mensaje que se desea mandar
     * @throws Exception Objeto de tipo 'Exception' que contiene el mensaje
     */
    private void evalErrorCondition(boolean condition, String msg) throws Exception {
        if(condition) throw new Exception(msg);
    }

    /**
     * Informa si el diferencial en segundos entre dos fechas es menor o no que un delta dado.
     * 
     * @param inicial Fecha inicial
     * @param terminal Fecha terminal
     * @param delta diferencial (EN SEGUNDOS) contra el que se va a comparar
     * 
     * @param seconds true si y sólo si la diferencia es menor que el delta dato
     * @return true si y sólo si la distancia entre la fecha inicial y la fecha final
     *  es menor que el diferencial dado
     */
    public boolean diffDates(Date inicial, Date terminal, long delta) {
        long diff = (terminal.getTime() -inicial.getTime())/1000;
        return (diff<delta);
    }
    
    @Override
    public LoginResponse requestRestore(String mail) {
    	// find a user with such a mail. Return null if not found:
        User user = userMapper.getUserByMail(mail);
        
        // if wrong mail, just log this condition, but say nothing about it to the request sender:
        if(user==null) {
        	logger.error("El mail '"+mail+"' no se encontró en la base de datos");
            return new LoginResponse("Unknown", true, "Revisa tu mail -->" + mail + "<--");
        }
        
        //set expiration time:
        long window = System.currentTimeMillis() + (securityTokenWindow*60*1000);
        user.setSecurityTokenWindow(window);// NOW plus 'securityTokenWindow' minutes
        
        // set security token:
        String secTok = createSecurityToken();
        user.setSecurityToken(secTok);
        
        // update database:
        userMapper.update(user);
        
        // since everything was ok, send the restore mail:
        this.chatbotMailSenderService.sendHtmlMail(
                mail, "Procedimiento de recuperación de contraseña", 
                getMailTemplate(secTok, user.getUsr()));
        return new LoginResponse(user.getUsr(), true, "Revisa tu mail: [" + mail + "]");
    }
    
    @Override
    public String buildRestoreUrl(String securityToken) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.urlBase);
        sb.append(this.front);
        sb.append(this.frontBad);
    	if(securityToken==null || securityToken.trim().length()<1) {
    		return sb.toString();
    	}
    	User user = userMapper.getUserBySecurityToken(securityToken);
        if(user==null) {
            return sb.toString();
        }
        sb = new StringBuilder();
        sb.append(this.urlBase);
        sb.append(this.front);
        sb.append(this.frontOk);
        sb.append(securityToken);

        return sb.toString();
    }

    @Override
    public LoginResponse restorePassword(String psw, String securityToken) {
        User user = userMapper.getUserBySecurityToken(securityToken);
        // realiza verificaciones pertinentes
        if(user==null) {
        	logger.error("No existe un usuario asociado al token: " + securityToken);
            return new LoginResponse("Unknown", false, "Token inexistente");
        }
        long timeToExpire = user.getSecurityTokenWindow();
        if(System.currentTimeMillis()>timeToExpire) {
        	logger.error("Token expirado: " + securityToken + " para usuario: " + user.getUsr());
            return new LoginResponse(user.getUsr(), false, "Token expirado");
        }
        // Si el usuario existe para el token dado y el token dado no ha expirado:
        String newPassword = cde.digest(psw, user.getUsr()); // digesta nuevo password dado
        user.setPassword(newPassword); // asigna nuevo password digestado
        user.setSecurityTokenWindow(0); // resetea ventana
        user.setFailedAtemptCounter(0); // resetea contador de intentos fallidos
        user.setSecurityToken(createSecurityToken()); // coloca un nuevo token (caduco) para impedir que se use el anterior
        userMapper.update(user);

        // manda mail que avisa que el password ha sido cambiado:
        this.chatbotMailSenderService.sendHtmlMail(
                user.getMail(), "Password Cambiado exitosamente", 
                "Hola, "+user.getUsr()+" tu password ha cambiado." );
        
        LoginResponse loginResponse = new LoginResponse(user.getUsr(), true, "Password restaurado correctamente");
        loginResponse.setJwt(jwtManagerService.createToken(user.getUsr())); // genera un nuevo jwt
        return loginResponse;
    }
    
    /**
     * Cuerpo del mensaje de respuesta a una solicitud de
     * restablecimiento de contraseña
     * @param secTok Cadena con el token que identifica al usuario
     *               que solicita restablecer su contraseña
     * @param name Cadena con el nombre del usuario
     * @return Cadena con el cuerpo del mensaje de restablecimiento
     */
    private String getMailTemplate(String secTok, String name) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.urlBase);
		sb.append(this.urlAuth);
		sb.append(this.urlVerifica);
		sb.append(secTok);
    	String template = getTextFromFile("emailTemplate.txt", false);
    	template = template.replace("$USER_NAME", name);
    	template = template.replace("$URL", sb.toString());
        return template;
    }
    
	private String getTextFromFileWithFullPath(String filenameFullpath) {
		try {
	    	logger.info("email template given full path: ["+filenameFullpath+"]");
	    	File file = new File(filenameFullpath);
			Scanner scanner = new Scanner(file, "UTF-8" );
			String text = scanner.useDelimiter("\\A").next();
			scanner.close();
			if(text.trim().length()<9) {
	    		logger.error("Couldn't find the given file: " + filenameFullpath); 
	    		return "<a href='$URL'>Liga (secundaria) para recuperar tu password ("+filenameFullpath+")</a>";
			}
			return text;
		} catch (Exception e) {
    		logger.error("Couldn't find the given file: " + filenameFullpath); 
    		return "<a href='$URL'>Liga (secundaria) para recuperar tu password ("+filenameFullpath+")</a>";			
		}
	}
	
	private String getTextFromFileWithRelativePath(String filenameRelativepath) {
		InputStream stream = 
				DialogflowCredentials
                .class
                .getClassLoader()
                .getResourceAsStream(filenameRelativepath);
		if(stream==null) {
			logger.error("Error loading "+filenameRelativepath); 
			return "<a>bad request</a>";
		}
		Scanner scanner = new Scanner(stream, "UTF-8");
		String text = scanner.useDelimiter("\\A").next();
		scanner.close();
		return text;
	}
	
    /**
     * Obtiene el cuerpo del mensaje de restablecer el password
     * @param filename Cadena con la ruta que contiene el cuerpo
     *                 del mensaje que se envia al usuario
     * @return Cadena con el cuerpo del mesaje para restablecer
     *         la contraseña del usuario que lo solicita
     */
	private String getTextFromFile(String filename, boolean relative) {
		if(relative) {
			return getTextFromFileWithRelativePath(filename);
		} else {
			String basePath = "/chat/";
			return getTextFromFileWithFullPath(basePath+ filename);
		}
    }

    /**
     * Genera un token para validar un usuario
     * @return Cadena con el token de verificacion
     */
    private static String createSecurityToken() {
        String store = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                      //123456789_123456789_123456789_123456789_123456789_123456789_12  // 62 caracteres
        String result = "";
        for(int i=0; i<50;i++) {
            double prev = Math.random()*62; // de 0 hasta 61
            int position = (int)prev;
            char data = store.charAt(position);
            result = result + data;
        }
        return result; // 2^6^50 cadenas = 2^300
    }
}
