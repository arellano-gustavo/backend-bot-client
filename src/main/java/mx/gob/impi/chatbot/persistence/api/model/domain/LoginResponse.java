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
 * Paquete:     mx.gob.impi.chatbot.persistence.api.model.domain
 * Modulo:      Login
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (11_23)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad 'Login' 
 *
 * Historia:    .
 *              20190920_1123 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.util.List;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad 'login'
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class LoginResponse {
	private String fullName = "";
    private String user = "";
    private String message = "";
    private String detailedMessage = "";
    private String jwt = "";
    private boolean succeed = false;
    private List<Area> areas;
    private List<Rol> roles;
    
    /**
     * Constructor default de la clase.
     */
    public LoginResponse(int a) {
    }
    
    /**
     * Constructor con los atributos del estatus del intento del login.
     */
    public LoginResponse(String user, boolean succeed, String message) {
        this.user = user;
        this.succeed = succeed;
        this.message = message;
    }
    
    public LoginResponse(String fullName, String user, boolean succeed, String message, List<Rol> roles, List<Area> areas) {
        this.fullName = fullName;
        this.user = user;
        this.succeed = succeed;
        this.message = message;
        this.setRoles(roles);
        this.setAreas(areas);
    }
    public boolean isSucceed() {
        return succeed;
    }
    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getJwt() {
        return jwt;
    }
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getDetailedMessage() {
        return detailedMessage;
    }

    public void setDetailedMessage(String detailedMessage) {
        this.detailedMessage = detailedMessage;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

}
