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
 * Paquete:     com.sc.config
 * Modulo:      WebMvcConfig
 * Tipo:        clase
 * Autor:       Gustavo Adolfo Arellano Sandoval (GAA)
 * Fecha:       22 de Sep de 2019 (21_24)
 * Version:     0.0.1
 * .
 * Clase que se usa para agregar los Handlers MVC para recursos adicionales como Swagger y React
 *
 * Historia:    .
 *              20160524_2124 Generado por GOOSE
 *
 *
 */
package mx.gob.impi.chatbot.persistence.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <p>WebMvcConfig class.</p>
 *
 * @author gustavo arellano
 * @version $Id: $Id
 */
@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);
    
    @Value("${enable.swagger.interface}")
    private boolean enableSwaggerInterface;

	  /**
	   * {@inheritDoc}
	   */
	  @Override
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    if(enableSwaggerInterface) {
	        logger.info("Se habilita lainterfaz de swagger");
	    registry
	        .addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
	    registry
	        .addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
	} else {
	    logger.info("Interfaz de swagger Inhabilitada (enable.swagger.interface=false)");
	}
	logger.info("Setting up handlers for VueJS Locations");
	registry
	    .addResourceHandler("index.html")
	    .addResourceLocations("classpath:/assets/");
	registry
	    .addResourceHandler("/static/**")
	    .addResourceLocations("classpath:/assets/static/");
	registry
	    .addResourceHandler("/web-resources/**")
	    .addResourceLocations("classpath:/content/static/");
	logger.info("Setting 404 error page resources");
	registry
	    .addResourceHandler("/404/**")
	    .addResourceLocations("classpath:/templates/error/clouds-404/");
	}
}
