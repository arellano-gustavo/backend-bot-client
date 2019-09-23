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
 * Paquete:     com.sc.support.mail
 * Modulo:      sc
 * Tipo:        AppSC
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Miercoles 01 de Junio de 2016 (21_24)
 * Version:     0.0.1
 * .
 * Clase que arranca la aplicación
 *
 * Historia:    .
 *
 *
 */
package mx.gob.impi.chatbot.persistence;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>AppSC class.</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@SpringBootApplication
@ComponentScan("mx.gob.impi.chatbot.persistence")
public class AppSC {
    private final static Logger logger = Logger.getLogger(AppSC.class);

  /**
   * <p>main.</p>
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {
    logger.info("Inicializando applicacion Spring Boot ********************************************");
    SpringApplication.run(AppSC.class, args);
    logger.info("Concluye Inicialización de applicacion Spring Boot *******************************");
    logger.info("Contexto levantado en: http://localhost:8080/api/personas/all.json ***************");
    logger.info("Swagger API en: http://localhost:8080/swagger-ui.html ****************************");
  }
}
