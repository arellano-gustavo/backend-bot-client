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
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        PageBoundaries pb = new PageBoundaries(0, 0, "id");
        return userMapper.getAll(pb);
    }
    
    @Override
    public List<User> getAllUsersAsc(PageBoundaries pb) {
        List<User> allUsers = userMapper.getAll(pb);
        return paginate(allUsers, pb.getPage(), pb.getSize());
    }
    
    @Override
    public List<User> getAllUsersDesc(PageBoundaries pb) {
        List<User> allUsers = userMapper.getAllDesc(pb);
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
        userMapper.shortInsert(user);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public MainControllerResponse update(User user) {
        userMapper.update(user);
        return new MainControllerResponse("message", "longMessage", true);
    }

    @Override
    public User loadUserFromWs(Integer idEmpleado) {
        //TODO: conectar con el web service real aqui
        User user = new User("carlos", "abc", "xyz@aol.com");
        user.setFullName("Carlos Salinas de Gortari");
        return user;
    }

}
