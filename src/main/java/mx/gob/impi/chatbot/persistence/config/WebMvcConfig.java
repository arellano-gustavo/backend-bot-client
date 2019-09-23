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
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

  /**
   * {@inheritDoc}
   */
  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {

    registry
        .addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");

    registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("(/resources/");

    registry
        .addResourceHandler("index.html")
        .addResourceLocations("classpath:/static/");

    registry
        .addResourceHandler("Terms.html")
        .addResourceLocations("classpath:/static/Terms.html");

    registry
        .addResourceHandler("/css/**")
        .addResourceLocations("classpath:/static/css/");

    registry
        .addResourceHandler("/js/**")
        .addResourceLocations("classpath:/static/js/");

    registry
        .addResourceHandler("/fonts/**")
        .addResourceLocations("classpath:/static/fonts/");

    registry
        .addResourceHandler("/images/**")
        .addResourceLocations("classpath:/static/images/");

    registry
        .addResourceHandler("pouchdb.js")
        .addResourceLocations("classpath:/static/pouchdb.js");

    registry
        .addResourceHandler("/**")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry
        .addResourceHandler("/")
        .addResourceLocations("classpath:/static/index.html");
  }

}
