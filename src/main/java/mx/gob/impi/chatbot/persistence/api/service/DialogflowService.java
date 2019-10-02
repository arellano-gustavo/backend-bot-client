package mx.gob.impi.chatbot.persistence.api.service;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

public interface DialogflowService<TEntity, TRequest> {
	/**
	    * Get all elements of type TEntity
	    * @param requestGet TEntity filter
	    * @return DtoResponse with List of selected elements
	    */
	    TEntity List(EntityItem<TRequest> requestGet, MainControllerResponse response);
	    
		/** 
	    * Insert new TEntity
	    * @param requestPost TEntity to Insert
	    * @returns DtoResponse with TEntity Inserted
	    */
	    MainControllerResponse Create(EntityItem<TRequest>  requestPost);

	    /**
	     * Get all elements of type TEntity
	     * @param requestGet TEntity filter
	     * @return DtoResponse with List of selected elements
	     */
	     TEntity Get(EntityItem<TRequest> requestGet, MainControllerResponse response);
	    
	    /**
	    * Modify existing TEntity
	    * @param requestPut TEntity with changes
	    * @return DtoResponse with TEntity changed
	    */
	     MainControllerResponse Update(EntityItem<TRequest> requestPut);

	    /**
	    * Delete exiting TEntity
	    * @param requestDelete TEntity to delete
	    * @return DtoResponse with TEntity deleted
	    */
	     MainControllerResponse Delete(EntityItem<TRequest> requestDelete);

}
