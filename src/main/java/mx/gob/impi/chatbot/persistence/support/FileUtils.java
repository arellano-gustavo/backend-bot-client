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
 * Paquete:     mx.gob.impi.chatbot.persistence.support
 * Módulo:      FileUtils
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase que se usa para interactuar con data streams
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase utilitaria que proveé algunos métodos para interactuar con las clases de IO.
 *
 * @author Erik Valdivieso Díaz (EVD)
 */
public final class FileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileUtils.class);

    /**
     * Encoding usado en el aplicación: UTF-8
     */
    public static final String DEFAULT_ENCONDING = "UTF-8";

    /**
     * Constructor default de la clase.
     */
    private FileUtils() {
    }

    /**
     * Cierra de forma segura el FileInputStream
     *
     * @param fis
     */
    public static void close(InputStream fis) {
        if (fis == null) {
            LOGGER.warn("Se intentó cerrar un inputStream nulo");
        } else {
            try {
                fis.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar el inputStrema", ex);
            }
        }
    }

    /**
     * Cierra de forma segura el FileReader
     *
     * @param fr
     */
    public static void close(FileReader fr) {
        if (fr == null) {
            LOGGER.warn("Se intentó cerrar un fileReader nulo");
        } else {
            try {
                fr.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar el fileReader", ex);
            }
        }
    }

    /**
     * Cierra de forma segura el InputStreamReader
     *
     * @param isr
     */
    public static void close(InputStreamReader isr) {
        if (isr == null) {
            LOGGER.warn("Se intentó cerrar un InputStreamReader nulo");
        } else {
            try {
                isr.close();
            } catch (Exception ex) {
                LOGGER.error("Error al cerrar el InputStreamReader", ex);
            }
        }
    }
    
    public static String cleanString(String msg) {
    	msg = msg.replace('"', '_');
    	msg = msg.replace(':', '_');
    	msg = msg.replace(';', '_');
    	msg = msg.replace(',', '_');
    	msg = msg.replace('(', '_');
    	msg = msg.replace(')', '_');
    	msg = msg.replace('[', '_');
    	msg = msg.replace(']', '_');
    	msg = msg.replace('-', '_');
    	msg = msg.replace(' ', '_');
    	msg = msg.replace('.', '_');
    	msg = msg.replace('?', '@');
    	msg = msg.replace('\n', '_');
    	return msg;
    }

}
