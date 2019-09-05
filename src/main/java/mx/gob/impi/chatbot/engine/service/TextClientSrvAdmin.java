/*
 *    Proyecto: Chatbot Ultra
 *       Fecha: 05/09/2019
 *       Autor: David Corza
 * Descripción: implementación de interface para el servicio de administración.
 */
package mx.gob.impi.chatbot.engine.service;

import mx.gob.impi.chatbot.engine.model.login.LogInRequest;

/**
 * interface para el servicio de administración de preguntas. 
 * @author David Corza
 */
public interface TextClientSrvAdmin {   

    /**
     *
     * @param data
     * @return
     */
    String response(LogInRequest data);
}
