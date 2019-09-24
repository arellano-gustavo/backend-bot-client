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
    
    private int intentos = 4;
    
    @Override
    public LoginResponse login(String user, String password) {
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
            
            evalErrorCondition(usuario.getFailedAtemptCounter()>intentos, "Máximo numero de intentos alcanzado");
            //evalErrorCondition(!usuario.getInstanteDeBloqueo()<(now + delta), "Aun no se puede desbloquear");

            if(sha256(password).equals(usuario.getPassword())) {
                usuario.setFailedAtemptCounter(0);
                LoginResponse loginResponse = new LoginResponse();
                loginResponse.setSucceed(true);
                loginResponse.setMessage("Bienvenido" + usuario.getUsr());
                loginResponse.setUser(usuario.getUsr());
                loginResponse.setJwt("hdbYY54vghssshjhfdAWDF54");
                return loginResponse;
            } else {
                int intentosActuales = usuario.getFailedAtemptCounter();
                usuario.setFailedAtemptCounter(intentosActuales+1);
                usuario.setBloquedDate(new Date());
                // HAY QUE GUARDAR AL USUARIO AQUI  <--
                if(intentosActuales<intentos) {
                    throw new Exception("Invalid Password");
                } else {
                    throw new Exception("Invalid Password. Cuenta bloqueada. Max alcanzado");
                }
            }
        } catch(Exception e) {
            return new LoginResponse(usuario.getUsr(), false, e.getMessage());
        }
    }
    
    private void evalErrorCondition(boolean condition, String msg) throws Exception {
        if(condition) throw new Exception(msg);
    }

    private String sha256(String password) {
        return "";
    }
}
