/*
 *
 * Licencia:    Usted puede utilizar libremente este código
 *              para copiarlo, distribuirlo o modificarlo total
 *              o parcialmente siempre y cuando mantenga este
 *              aviso y reconozca la autoría del código al no
 *              modificar los datos establecidos en la mención de "AUTOR".
 *
 * Proyecto:    skeleton
 * Paquete:     mx.com.infotec.dadt.arq.core.model
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * La clase DateWrapper.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.5.9
 */
public class DateWrapper implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = 
            LoggerFactory.getLogger(DateWrapper.class);
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
                + "'preregistro' que tengan mas de {} dias de antiguedad",
                days);
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
