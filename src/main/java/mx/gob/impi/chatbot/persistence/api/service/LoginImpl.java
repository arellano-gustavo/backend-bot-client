package mx.gob.impi.chatbot.persistence.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

@Service
public class LoginImpl {
    @Autowired
    private UserMapper userMapper;
    
    private int intentos = 4;
    
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
