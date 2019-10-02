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

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

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
    
    @Override
    public LoginResponse changePassword(String user, String password, String jwt) {
        if(jwtManagerService.verifyToken(jwt)) {
            User usuario = userMapper.getUserByName(user);
            if(usuario!=null) {
                String newPassword = cde.digest(password, user);
                usuario.setPassword(newPassword);
                userMapper.update(usuario);
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSucceed(true);
                loginResponse.setMessage("Password cambiado, " + user);
                loginResponse.setUser(user);
                loginResponse.setJwt(jwtManagerService.createToken(user));
                return loginResponse;
            }
            return new LoginResponse(user, false, "Usuario no existe !!");
        } else {
            return new LoginResponse(user, false, "Token Inválido");
        }
    }
        
    @Override
    public LoginResponse login(String user, String password) {
        // Preparando un objeto de tipo User
        User usuario = null;
        // Primero revisamos si no existe una razón evidente por la cual no autenticar:
        try {
            evalErrorCondition(user==null || user.trim().length()<1,         "User vacío");
            evalErrorCondition(password==null || password.trim().length()<1, "Password vacío");
            
            usuario = userMapper.getUserByName(user);
            evalErrorCondition(usuario==null, "User no existe");
            evalErrorCondition(usuario.isExpiredAccount(), "Cuenta expirada");
            evalErrorCondition(usuario.isBloquedAccount(), "Cuenta bloqueada");
            evalErrorCondition(usuario.isExpiredCredential(), "Credenciales expiradas");
            evalErrorCondition(usuario.isDisabled(), "User inhabilitado");
            evalErrorCondition(usuario.getFailedAtemptCounter()>maxInvalidTries, "Máximo numero de intentos alcanzado");
            
            if(usuario.getBloquedDate()!=null) {
                Date now = new Date();
                long remanent = blokedWindowTime - now.getTime() + usuario.getBloquedDate().getTime();
                evalErrorCondition(remanent>0, "Aun no se puede desbloquear. Faltan aun " + remanent + " segundos");
            }
            
            String encodedPassword = cde.digest(password, user);
            
            /** /
            ok("root");
            ok("tavo");
            ok("tercero");
            ok("cuarto");
            ok("quinto");
            ok("sexto");
            /**/
            
            if(encodedPassword.equals(usuario.getPassword())) {
                // Reset fallos previos
                usuario.setFailedAtemptCounter(0);
                usuario.setBloquedDate(null);
                userMapper.update(usuario);

                // Prepara y envía respuesta
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSucceed(true);
                loginResponse.setMessage("Bienvenido, " + usuario.getUsr());
                loginResponse.setUser(usuario.getUsr());
                loginResponse.setJwt(jwtManagerService.createToken(user));
                return loginResponse;
            } else {
                int intentosActuales = usuario.getFailedAtemptCounter() + 1;
                usuario.setFailedAtemptCounter(intentosActuales);
                userMapper.updateFailure(usuario);
                
                if(intentosActuales<maxInvalidTries) {
                    throw new Exception("Invalid Password");
                } else {
                	usuario.setBloquedAccount(true);
                    usuario.setBloquedDate(new Date());
                    userMapper.updateBlocked(usuario);
                    throw new Exception("Invalid Password. Cuenta bloqueada. Max alcanzado");
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
    public void ok(String name) {
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
     * @param delta diferencial contra el que se va a comparar
     * 
     * @param seconds true si y sólo si la diferencia es menor que el delta dato
     * @return
     */
    public boolean diffDates(Date inicial, Date terminal, long delta) {
        long diff = (terminal.getTime() -inicial.getTime())/1000;
        return (diff<delta);
    }
    @Override
    public LoginResponse requestRestore(String mail) {
        User user = userMapper.getUserByMail(mail);
        if(user==null) {
            return new LoginResponse("Unknown", true, "Revisa tu mail: " + mail);
        }
        
        Date now = new Date();
        long nowLong = now.getTime();
        long window = nowLong + securityTokenWindow*60*1000;
        user.setSecurityTokenWindow(window);// now plus 5 minutes
        String secTok = createSecurityToken();
        user.setSecurityToken(secTok);
        this.chatbotMailSenderService.sendMail(
                mail, "Procedimiento de recuperación de contraseña", 
                getMailTemplate(secTok, user.getUsr()));
        return new LoginResponse(user.getUsr(), true, "Revisa tu mail: " + mail);
    }

    @Override
    public LoginResponse restorePassword(String securityToken, String password) {
        User user = userMapper.getUserBySecurityToken(securityToken);
        if(user==null) {
            return new LoginResponse("Unknown", false, "Token inexistente");
        }
        long timeToExpire = user.getSecurityTokenWindow();
        Date now = new Date();
        long nowLong = now.getTime();
        
        if(nowLong>timeToExpire) {
            return new LoginResponse(user.getUsr(), false, "Token expirado");
        }
        String newPassword = cde.digest(password, user.getUsr());
        user.setPassword(newPassword);
        user.setSecurityTokenWindow(0);
        user.setFailedAtemptCounter(0);
        userMapper.update(user);
        this.chatbotMailSenderService.sendMail(
                user.getMail(), "Password Cambiado exitosamente", 
                "Hola, "+user.getUsr()+" tu password ha cambiado." );
        return new LoginResponse(user.getUsr(), true, "Password restaurado correctamente");
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
        sb.append("Hola, estimado "+name+" !!!");
        sb.append("<h1>Usa esta liga:</h1>");
        sb.append("<h2><a href='http://localhost:8080/api/recupera?token=");
        sb.append(secTok);
        sb.append("'>recupera</a></h2>");
        return sb.toString();
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
