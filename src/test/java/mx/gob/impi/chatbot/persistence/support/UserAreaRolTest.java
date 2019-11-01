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
 * Modulo:      MybatisTest
 * Tipo:        CLASE 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (18_11)
 * Version:     1.0-SNAPSHOT
 * .
 * Test de UserMapper
 *
 * Historia:    .
 *              20190927_1811 Creación de la prueba unitaria
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import mx.gob.impi.chatbot.persistence.api.model.domain.UserArea;
import mx.gob.impi.chatbot.persistence.api.model.domain.UserRol;
import mx.gob.impi.chatbot.persistence.api.model.domain.Area;
import mx.gob.impi.chatbot.persistence.api.model.domain.Empleado;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.Rol;
import mx.gob.impi.chatbot.persistence.api.model.domain.User;
import mx.gob.impi.chatbot.persistence.api.service.AreaService;
import mx.gob.impi.chatbot.persistence.api.service.RolService;
import mx.gob.impi.chatbot.persistence.api.service.UserAreaService;
import mx.gob.impi.chatbot.persistence.api.service.UserRolService;
import mx.gob.impi.chatbot.persistence.api.service.UserService;

/**
 * <p>Descripción:</p>
 * Clase de pruebas unitarias para validar el mapper de 'UserMapper'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest 
public class UserAreaRolTest {
    private static final Logger logger = LoggerFactory.getLogger(UserAreaRolTest.class);
    
    @Autowired
    private UserRolService userRolService;
    
    @Autowired
    private UserAreaService userAreaService;
    
    @Autowired
    private AreaService areaService;
    
    @Autowired
    private RolService rolService;
    
    @Autowired
    private UserService userService;
    
    
    /**
     * Prueba los metodos de recuperacion de usuario
     */
    @Test
    public void TestAdmin() {
///////////////////////////////////USER///////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
    	/*
		int idUser = 0;
		
		List<User> allUser = userService.getAllUsers();
		
		for(User u : allUser) {
		if(u.getId()>idUser)
		idUser = u.getId();
		logger.info("User: "+u.toString());
		}
		idUser = idUser+1;
		
		int numUsers = allUser.size();
		
		assertTrue("Recuepra las users", numUsers>=0);
		
		User userPrubea = new User("goose"+ idUser, "xyz", idUser + "gus@hotmail.com");
		String store = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String result = "";
		for(int i=0; i<50;i++) {
		double prev = Math.random()*62; // de 0 hasta 61
		int position = (int)prev;
		char data = store.charAt(position);
		result = result + data;
		}
		userPrubea.setSecurityToken("token");
		
		
		MainControllerResponse responseSaveUser = userService.save(userPrubea);
		
		assertTrue("Crea user", responseSaveUser.isSucceed());
		
		User user = userService.findUserById(idUser);
		if(user!=null) {
		logger.info(user.getUsr()); 
		}
		
		assertTrue("Obtiene user", user!=null);
		
		
		userPrubea.setMail(idUser + "actualgus@hotmail.com");
		MainControllerResponse responseUpdateUser = userService.update(userPrubea);
		
		assertTrue("Actualiza user", responseUpdateUser.isSucceed());
		
		if(user!=null) {
		logger.info(user.getUsr()); 
		}
		
		
		
		User uu = userService.findUserByMail("arellano.gustavo@gmail.com");
		if(uu!=null) {
		logger.info(uu.getUsr()); 
		}
		assertTrue("user por mail", uu!=null);
		
		User u3 = userService.findUserByName("goose"+ idUser);        
		if(u3!=null) {
		logger.info("u3:"+u3.getMail()); 
		}
		assertTrue("user por namel", u3!=null);
		
		
		
		User uToken = userService.findUserByToken("WzJN9enqVBerz9aaDT7O000eFryx5O9RtxDKkTxneJoEfug0LZ");
		if(uToken!=null) {
		logger.info(uToken.getUsr()); 
		}
		assertTrue("user por token", uToken!=null);
		
		Empleado uWs = userService.loadUserFromWs(1673);
		if(uWs!=null) {
		logger.info(uWs.getNombre()); 
		}
		assertTrue("user por token", uWs!=null);
   	

////////////////////////////////Area//////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
		
		int idArea = 0;
		
		List<Area> allAreas = areaService.getAll();
		
		for(Area u : allAreas) {
			if(u.getId()>idArea)
				idArea = u.getId();
		    logger.info("Area: "+u.toString());
		}
		idArea = idArea+1;
		
		int numAreas = allAreas.size();
		
		assertTrue("Recuepra las areas", numAreas>=0);
		
		Area areaPrubea = new Area();
		areaPrubea.setActive(true);
		areaPrubea.setDescription("prueba" + idArea);
		areaPrubea.setName("prueba" + idArea);
		areaPrubea.setId(idArea);
		
		MainControllerResponse responseSaveArea = areaService.save(areaPrubea);
		
		assertTrue("Crea area", responseSaveArea.isSucceed());
		
		Area area = areaService.getAreaById(idArea);
		if(area!=null) {
			logger.info(area.getName()); 
		}
		
		assertTrue("Obtiene area", area!=null);
		
		
		areaPrubea.setName("area" + idArea);
		MainControllerResponse responseUpdateArea = areaService.update(areaPrubea);
		
		assertTrue("Actualiza area", responseUpdateArea.isSucceed());
		    	
		if(area!=null) {
			logger.info(area.getName()); 
		}
/////////////////////////////////Rol/////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
		
		int idRol = 0;
    	
    	List<Rol> allRol = rolService.getAll();
    	
    	for(Rol u : allRol) {
    		if(u.getId()>idRol)
    			idRol = u.getId();
            logger.info("Rol: "+u.toString());
        }
    	idRol = idRol+1;
    	
    	int numRols = allRol.size();
    	
    	assertTrue("Recuepra las rols", numRols>=0);
    	
    	Rol rolPrubea = new Rol();
    	rolPrubea.setActive(true);
    	rolPrubea.setDescription("prueba" + idRol);
    	rolPrubea.setName("prueba" + idRol);
    	rolPrubea.setId(idRol);
    	
    	MainControllerResponse responseSaveRol = rolService.save(rolPrubea);
    	
    	assertTrue("Crea rol", responseSaveRol.isSucceed());
    	
    	Rol rol = rolService.getRolById(idRol);
    	if(rol!=null) {
    		logger.info(rol.getName()); 
    	}
    	
    	assertTrue("Obtiene rol", rol!=null);

    	
    	rolPrubea.setName("rol" + idRol);
    	MainControllerResponse responseUpdateRol = rolService.update(rolPrubea);
    	
    	assertTrue("Actualiza rol", responseUpdateRol.isSucceed());
    	    	
    	if(rol!=null) {
    		logger.info(rol.getName()); 
    	}

    	
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
    	UserArea userAreaPrubea = new UserArea();
    	userAreaPrubea.setIdArea(idArea);
    	userAreaPrubea.setIdUser(idUser);


    	List<UserArea> allUserArea = userAreaService.getAll();
    	
    	for(UserArea u : allUserArea) {    		
            logger.info("UserArea: "+u.toString());
        }
    	
    	int numUserAreas = allUserArea.size();
    	
    	assertTrue("Recuepra las userAreas", numUserAreas>=0);
    	   	
    	logger.info("idUser:" + idUser+ ", idArea: " + idArea);
    	
    	MainControllerResponse responseSaveUserArea = userAreaService.save(idUser,idArea );
    	
    	assertTrue("Crea userArea", responseSaveUserArea.isSucceed());
    	
    	allUserArea = userAreaService.getUserAreaByIdUser(idUser);
    	for(UserArea u : allUserArea) {    		
            logger.info("UserArea: "+u.toString());
        }
    	
    	numUserAreas = allUserArea.size();
    	
    	assertTrue("Recuepra las userAreas por idUser", numUserAreas>=0);
    	
    	allUserArea = userAreaService.getUserAreaByIdUser(idArea);
    	for(UserArea u : allUserArea) {    		
            logger.info("UserArea: "+u.toString());
        }
    	
    	numUserAreas = allUserArea.size();
    	
    	assertTrue("Recuepra las userAreas por idArea", numUserAreas>=0);
    	
    	
    	
    	MainControllerResponse responseDeleteUserArea = userAreaService.delete(idUser, idArea);
    	assertTrue("Borra userArea", responseDeleteUserArea.isSucceed());
    	
//////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
    	UserRol userRolPrubea = new UserRol();
    	userRolPrubea.setIdRol(idRol);
    	userRolPrubea.setIdUser(idUser);


    	List<UserRol> allUserRol = userRolService.getAll();
    	
    	for(UserRol u : allUserRol) {    		
            logger.info("UserRol: "+u.toString());
        }
    	
    	int numUserRols = allUserRol.size();
    	
    	assertTrue("Recuepra las userRols", numUserRols>=0);
    	   	
    	logger.info("idUser:" + idUser+ ", idRol: " + idRol);
    	
    	MainControllerResponse responseSaveUserRol = userRolService.save(idUser,idRol );
    	
    	assertTrue("Crea userRol", responseSaveUserRol.isSucceed());
    	
    	allUserRol = userRolService.getUserRolByIdUser(idUser);
    	for(UserRol u : allUserRol) {    		
            logger.info("UserRol: "+u.toString());
        }
    	
    	numUserRols = allUserRol.size();
    	
    	assertTrue("Recuepra las userRols por idUser", numUserRols>=0);
    	
    	allUserRol = userRolService.getUserRolByIdUser(idRol);
    	for(UserRol u : allUserRol) {    		
            logger.info("UserRol: "+u.toString());
        }
    	
    	numUserRols = allUserRol.size();
    	
    	assertTrue("Recuepra las userRols por idRol", numUserRols>=0);
    	
    	
    	
    	MainControllerResponse responseDeleteUserRol = userRolService.delete(idUser, idRol);
    	assertTrue("Borra userRol", responseDeleteUserRol.isSucceed());
    */	
    }

}
