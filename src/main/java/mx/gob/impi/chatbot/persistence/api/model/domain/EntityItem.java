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
 * Módulo:      EntityItem
 * Tipo:        Clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 27 de Septiembre de 2019 (15_53)
 * Versión:     1.0-SNAPSHOT
 *
 * Historia:    20190927_1553
 *                 revisa (y agrega) JavaDoc requerido
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Clase que encapsula los parametros de las solictudes
 * del agente de dialogflow para identificar el area y 
 * la entidad a la que se le realiza la solicitud
 */
public class EntityItem <TEntity> {
	
	String areaId;
	String sessionId;
	
	@JsonIgnore
	String uriTemplate;
	
	@JsonIgnore
	String method;

	@JsonIgnore
	String id;
	
	TEntity item;
	
	public TEntity getItem() { 
    	return item;
    }
	
	public void setItem(TEntity item) { 
    	this.item = item;
    }
	
	public String getId(){ 
		return id;
	}
	
	public void setId(String id) { 
		this.id = id;
	}
	
	public String getAreaId(){ 
		return areaId;
	}
	
	public void setAreaId(String areaId) { 
		this.areaId = areaId;
	}
	
	public String getSessionId(){
		return sessionId;        
    }
	
	public void setSessionId(String sessionId){
        this.sessionId = sessionId;        
    }
	
	public String getUriTemplate(){ 
		return uriTemplate;
	}
	
	public void setUriTemplate(String uriTemplate) { 
		this.uriTemplate = uriTemplate;
	}
	
	public String getMethod(){ 
		return method;
	}
	
	public void setMethod(String method) { 
		this.method = method;
	}
}
