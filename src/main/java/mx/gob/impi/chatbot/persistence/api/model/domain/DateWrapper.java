/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    skeleton
 * Paquete:     mx.gob.impi.chatbot.persistence.api.model.domain
 * Módulo:      DateWrapper
 * Tipo:        Clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Versión:     1.5.9
 *
 * Historia:    20120801@1103
 *                 revisa (y agrega) JavaDoc requerido
 */
package mx.gob.impi.chatbot.persistence.api.model.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;


import org.slf4j.*;
//import org.slf4j.LoggerFactory;

/**
 * La clase DateWrapper.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.5.9
 */
public class DateWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    //private static final Logger LOGGER = Logger.getLogger(DateWrapper.class);
    private static final Logger LOGGER = LoggerFactory.getLogger(DateWrapper.class);

    //public static Timestamp NOW = new Timestamp(System.currentTimeMillis());
    /**
     * Representa la fecha máxima (límite superior)
     */
    private Date upperLimit;
    /**
     * Representa una hora en milisegundos
     */
    private long oneHour = 60 * 60 * 1000;

    /**
     * Crea una nueva instancia date wrapper.
     *
     * @param days Es el número de días que tienen que pasar para que un 
     * registro se pueda borrar de la tabla
     * preregistro. mediante este parámetro, el sistema fija un limite
     * en el que el usuario pueda completar su registro.
     */
    public DateWrapper(int days) {
        LOGGER.info("Se procede a eliminar los registros de la tabla "
                + "'preregistro' que tengan mas de "+days+" dias de antiguedad");
        long now = System.currentTimeMillis();
        long when = now - oneHour * 24 * days;
        upperLimit = new Date(when);
    }

    public Date getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Date upperLimit) {
        this.upperLimit = upperLimit;
    }

    /**
     * Genera una instancia del calendario, inicializando el año con el valor 
     * especificado como argumento, obteniendo el
     * tiempo actual en milisegundos.
     *
     * @param year El año en el que se desea obtener el tiempo actual
     *
     * @return regresa el tiempo actual UTC en milisegundos.
     */
    public static Timestamp getTimeAgo(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return new Timestamp(cal.getTimeInMillis());
    }

    public static Timestamp now() {
        return new Timestamp(System.currentTimeMillis());
    }
}
