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
 * Modulo:      Mail
 * Tipo:        interface 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Servicio del envio de mail
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de envio de mail
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface ChatbotMailSenderService {
	
	/**
	 * Envio correo electronicos desde la aplicacion chatbot
	 * @param to Cadena con los correos electronicos a los que se
	 *           el mensaje que genera el chatbot
	 * @param subject Cadena con el titulo del correo electronico
	 * @param body Cadena con el cuerpo del mensaje que se envia
	 *             desde el chatbot
	 */
    void sendMail(String to, String subject, String body);
}
