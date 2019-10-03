package mx.gob.impi.chatbot.persistence.api.model.domain;

public class EntityItem <TEntity> {
	
	String areaId;
	String sessionId;
	
	String uriTemplate;
	
	String method;

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
