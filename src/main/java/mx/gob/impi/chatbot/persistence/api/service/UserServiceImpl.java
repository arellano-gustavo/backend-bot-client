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
 * Modulo:      User
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Implementacion del servicio de User
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.impi.chatbot.persistence.api.db.UserMapper;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.PageBoundaries;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;

/**
 * <p>Descripción:</p>
 * Implementacion del servicio de User
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        PageBoundaries pb = new PageBoundaries(0, 0, "id", true);
        return userMapper.getAll(pb);
    }
    @Override
    public List<User> getAllUsers(PageBoundaries pb) {
        List<User> allUsers = null;
        if(pb.isAscending()) {
            allUsers = userMapper.getAll(pb);
        } else {
            allUsers = userMapper.getAllDesc(pb);
        }
        return paginate(allUsers, pb.getPage(), pb.getSize());
    }
    
    private List<User> paginate(List<User> originalArray, Integer pageNumber, Integer pageSize) {
        if(pageSize<1 || pageNumber<1) return new ArrayList<>();
        int a = pageSize * pageNumber - pageSize +1;
        int b = pageSize * pageNumber;
        int len = originalArray.size();
        if(a>len) return new ArrayList<>();
        if(b>len) b = originalArray.size();
        int newLen = b-a+1;
        List<User> result = new ArrayList<>();
        for(int i = 0; i<newLen; i++) {
            result.add(originalArray.get(a+i-1));
        }
        return result;
    }
    
    @Override
    public User findUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User findUserByMail(String mail) {
        return userMapper.getUserByMail(mail);
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public User findUserByToken(String token) {
        return userMapper.getUserBySecurityToken(token);
    }

    @Override
    public MainControllerResponse save(User user) {
        try {
            userMapper.shortInsert(user);
            return new MainControllerResponse("user.id is "+user.getId(), "Object User inserted on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al insertar un nuevo Usuario en la base de datos", msg, false);
        }
    }

    @Override
    public MainControllerResponse update(User user) {
        try {
            userMapper.update(user);
            return new MainControllerResponse("user.id is "+user.getId(), "Object User updated on DB", true);
        } catch(RuntimeException  rte) {
        	String msg = rte.getCause().getMessage();
            logger.error(msg);
            return new MainControllerResponse("Error al actualizar un Usuario existente en la base de datos", msg, false);
        }
    }

    @Override
    public User loadUserFromWs(Integer idEmpleado) {
        //TODO: conectar con el web service real aqui
        User user = new User("carlos", "abc", "xyz@aol.com");
        user.setFullName("Carlos Salinas de Gortari");
        return user;
    }

}
