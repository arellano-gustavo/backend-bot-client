package mx.gob.impi.chatbot.persistence.api.service;

import mx.gob.impi.chatbot.persistence.api.model.domain.EntityItem;

public interface DialogflowService<TEntity, TRequest> {
	/**
	    * Get all elements of type TEntity
	    * @param requestGet TEntity filter
	    * @return DtoResponse with List of selected elements
	    */
	    TEntity List(EntityItem<TRequest> requestGet);
	    
		/** 
	    * Insert new TEntity
	    * @param requestPost TEntity to Insert
	    * @returns DtoResponse with TEntity Inserted
	    */
	    TEntity Create(EntityItem<TRequest>  requestPost);

	    /**
	     * Get all elements of type TEntity
	     * @param requestGet TEntity filter
	     * @return DtoResponse with List of selected elements
	     */
	     TEntity Get(EntityItem<TRequest> requestGet);
	    
	    /**
	    * Modify existing TEntity
	    * @param requestPut TEntity with changes
	    * @return DtoResponse with TEntity changed
	    */
	    TEntity Update(EntityItem<TRequest> requestPut);

	    /**
	    * Delete exiting TEntity
	    * @param requestDelete TEntity to delete
	    * @return DtoResponse with TEntity deleted
	    */
	    TEntity Delete(EntityItem<TRequest> requestDelete);

}
