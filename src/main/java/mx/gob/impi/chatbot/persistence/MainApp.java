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
import org.springframework.core.env.AbstractEnvironment;
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
    private static final Logger logger = LoggerFactory.getLogger(MainApp.class);

  /**
   * <p>main.</p>
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {
    // Calculando el ambiente que hemos enviado en nuestra linea de arranque:
    logger.info(">>>>>> Calculando ambiente para runtime....");
    String[] actPro = System.getProperty("spring-boot.run.profiles","").split(",");
    
    if(actPro!=null && actPro.length>0 && actPro[0]!=null && actPro[0].trim().length()>0) {
    	logger.info("Active profile: [" + actPro[0] + "] <------- Current profile !!!!");
    	System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, actPro[0]);
    } else {
    	logger.error("Using Profile by default !!!!");
    }
    
    //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "impi");
    
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
  /* */
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
  /**/
}
