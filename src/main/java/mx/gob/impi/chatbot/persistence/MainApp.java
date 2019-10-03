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
 * Paquete:     mx.gob.impi.chatbot.persistence
 * Modulo:      Main Module
 * Tipo:        MainApp
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       Lunes 23 de Septiembre de 2019
 * Version:     0.0.1
 * .
 * Clase que arranca la aplicación
 *
 * Historia:    .
 *
 *
 */
package mx.gob.impi.chatbot.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

/**
 * <p>MainApp class...</p>
 *
 * @author garellano
 * @version $Id: $Id
 */
@EnableEncryptableProperties
@SpringBootApplication
@ComponentScan("mx.gob.impi.chatbot.persistence")
public class MainApp {
    private final static Logger logger = LoggerFactory.getLogger(MainApp.class);

  /**
   * <p>main.</p>
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {
    logger.info("Inicializando applicacion Spring Boot ********************************************");
    SpringApplication.run(MainApp.class, args);
    logger.info("Concluye Inicialización de applicacion Spring Boot *******************************");
    logger.info("Contexto levantado en: http://localhost:8080/api/personas/all.json ***************");
    logger.info("Swagger API en: http://localhost:8080/swagger-ui.html ****************************");
    
    //SpringApplication application = new SpringApplication(MainApp.class);
    /* Setting Boot banner off default value is true */
    //application.setBannerMode(Banner.Mode.OFF);
    //application.run(args);
  }
  
  //@SuppressWarnings("deprecation")
  @Bean
  public WebMvcConfigurer corsConfigurer() {
	  // check this out: https://www.logicbig.com/how-to/code-snippets/jcode-spring-mvc-webmvcconfigurer.html
	  // https://stackoverflow.com/questions/27381781/java-spring-boot-how-to-map-my-app-root-to-index-html
      return new WebMvcConfigurer() {
          @Override
          public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**").allowedOrigins("*");
          }
      };
  }
}
