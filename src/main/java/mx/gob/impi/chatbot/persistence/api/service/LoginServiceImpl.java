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
    @Autowired
    private UserMapper userMapper;
    
    @Autowired
    private CustomDigestEncoderService cde;
    
    @Value("${login.blokedWindowTime}")
    private long blokedWindowTime;
    
    @Value("${login.maxInvalidTries}")
    private int maxInvalidTries;
        
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
            
            evalErrorCondition(usuario.isDisabled(), "User inhabilitado");
            
            evalErrorCondition(usuario.isExpiredCredential(), "Credenciales expiradas");

            evalErrorCondition(usuario.isExpiredAccount(), "Cuenta expirada");
            
            evalErrorCondition(usuario.isBloquedAccount(), "Cuenta bloqueada");
            
            evalErrorCondition(usuario.getFailedAtemptCounter()>maxInvalidTries, "Máximo numero de intentos alcanzado");
            
            if(usuario.getBloquedDate()!=null) {
                Date now = new Date();
                long remanent = blokedWindowTime - now.getTime() + usuario.getBloquedDate().getTime();
                evalErrorCondition(remanent>0, "Aun no se puede desbloquear. Faltan aun " + remanent + " segundos");
            }

            String encodedPassword = cde.digest(password, user);
            if(encodedPassword.equals(usuario.getPassword())) {
                // Reset fallos previos
                usuario.setFailedAtemptCounter(0);
                usuario.setBloquedDate(null);
                userMapper.update(usuario);

                // Prepara y envía respuesta
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSucceed(true);
                loginResponse.setMessage("Bienvenido" + usuario.getUsr());
                loginResponse.setUser(usuario.getUsr());
                loginResponse.setJwt("hdbYY54vghssshjhfdAWDF54");
                return loginResponse;
            } else {
                int intentosActuales = usuario.getFailedAtemptCounter();
                usuario.setFailedAtemptCounter(intentosActuales+1);
                userMapper.updateFailure(usuario);
                
                if(intentosActuales<maxInvalidTries) {
                    throw new Exception("Invalid Password");
                } else {
                    usuario.setBloquedDate(new Date());
                    userMapper.updateBlocked(usuario);
                    throw new Exception("Invalid Password. Cuenta bloqueada. Max alcanzado");
                }
            }
        } catch(Exception e) {
            return new LoginResponse(user, false, e.getMessage());
        }
    }
    
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
}
