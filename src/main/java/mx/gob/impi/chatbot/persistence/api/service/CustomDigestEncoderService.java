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
 * Modulo:      Area
 * Tipo:        interface
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 26 de Septiembre de 2019 (16_26)
 * Version:     1.0-SNAPSHOT
 * .
 * Encoder de cadenas
 *
 * Historia:    .
 *              20190926_1626 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

/**
 * <p>Descripción:</p>
 * Interface asociado al servicio de 'Encoder'
 * para autenticar al usuario
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface CustomDigestEncoderService {
    /**
     * Retorna una cadena hexadecimal asociada a la cadena 'source', pero
     * con un 'salt' arbitrario.
     *
     * @param source Cadena a hashear
     * @param salt Salt a inyectar
     *
     * @return Cadena satlteada y hasheada
     */
    String digest(String source, String salt);
}
