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
 * Modulo:      Estado
 * Tipo:        clase 
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * POJO asociado a la entidad Estado 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.model.estado;

import java.io.Serializable;

/**
 * <p>Descripción:</p>
 * POJO asociado a la entidad Estado
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public class EstadoPojo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer estadoPk;
    private String nombre;

    /**
     * Constructor default de la clase.
     */
    public EstadoPojo() {
    }
    
    public EstadoPojo(Integer estadoPk, String nombre) {
        this.estadoPk = estadoPk;
        this.nombre = nombre;
    }

    /**
     * Constructor con los atributos que conforman la llave de la clase.
     */
    public  EstadoPojo(Integer estadoPk) {
        this.estadoPk = estadoPk;
    }

    public Integer getEstadoPk() {
        return estadoPk;
    }

    public void setEstadoPk(Integer estadoPk) {
        this.estadoPk = estadoPk;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
