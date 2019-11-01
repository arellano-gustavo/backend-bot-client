package mx.gob.impi.chatbot.engine.rest;

import org.apache.log4j.Logger;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.StaticHandler;
import mx.gob.impi.chatbot.engine.model.ChatbotRequest;
import mx.gob.impi.chatbot.engine.model.login.LogInRequest;
import mx.gob.impi.chatbot.engine.service.*;
import mx.gob.impi.chatbot.engine.utils.Support;

/**
 * Clase controlador que contiene la implementación para exponer el chatbot y la admistración de preguntas.
 * @author gustavo
 *
 */
public class ServiceController extends AbstractVerticle {
    private final static Logger logger = Logger.getLogger(ServiceController.class);
    private TextClientSrv textClientSrv = new TextClientSrvImpl();
    private TextClientSrvAdminImpl TextClientSrvAdminImpl = new TextClientSrvAdminImpl();
    
    /**
     * Inicializa el servicio de búsqueda
     * @param fut
     */
    public void start(Future<Void> fut) {
        logger.info("Iniciando vertical");
        
        Router router = Router.router(vertx);
        router.route("/*").handler(CorsHandler.create("*")  
        		.allowedMethod(HttpMethod.GET)
        		.allowedMethod(HttpMethod.PUT)
        		.allowedMethod(HttpMethod.DELETE)
        		.allowedMethod(HttpMethod.POST)
        		.allowedMethod(HttpMethod.OPTIONS)
        		.allowCredentials(true)
        		.allowedHeader("Access-Control-Allow-Method")
        		.allowedHeader("Access-Control-Allow-Origin")
        		.allowedHeader("Access-Control-Allow-Credentials")
        		.allowedHeader("Content-Type"));
        router.route("/*").handler(StaticHandler.create("assets")); 
        
        router.route().handler(BodyHandler.create());
        router.post("/api/challenge").handler(this::processChallengeByArea);
        router.post("/api/chatbot").handler(this::chatbot);
        router.post("/api/login").handler(this::login);

        // Create the HTTP server and pass the "accept" method to the request handler.
        vertx.createHttpServer().requestHandler(router::accept).listen(
                // Retrieve the port from the configuration. Default port is 8080.
                config().getInteger("http.port", 8080), result -> {
                    if (result.succeeded()) {
                        fut.complete();
                    } else {
                        fut.fail(result.cause());
                    }
                });
    }

    /**
     * Se dispara cuando ocurre una excepcion
     * throws Exception
     * @throws java.lang.Exception
     */
    @Override
    public void stop() throws Exception {
        // clean all resources and exit ...
    }

    private void processChallengeByArea(RoutingContext routingContext) {
        HttpServerRequest request = routingContext.request();
        String areaNumber = request.getParam("area");
        String idUsuario = request.getParam("idu");
        String body = routingContext.getBodyAsString();
        logger.info(body);
        String challenge = Support.getChallenge(body);
        String resp = textClientSrv.response(areaNumber, challenge, idUsuario);
        // route response
        routingContext.
        response().
        setStatusCode(200).
        putHeader("content-type", "application/json; charset=utf-8").
        end(Json.encodePrettily(resp));
    }
    private void chatbot(RoutingContext routingContext) {
        String body = routingContext.getBodyAsString();
        logger.info(body);
        ChatbotRequest challenge = Json.decodeValue(body, ChatbotRequest.class);
        String resp = textClientSrv.response(challenge);
        // route response
        routingContext.
            response().
            setStatusCode(200).
            putHeader("content-type", "application/json; charset=utf-8").
            end(Json.encodePrettily(resp));
    }
    private void login(RoutingContext routingContext) {
        String body = routingContext.getBodyAsString();
        logger.info(body);
        LogInRequest challenge = Json.decodeValue(body, LogInRequest.class);
        String resp = TextClientSrvAdminImpl.response(challenge);
        // route response
        routingContext.
            response().
            setStatusCode(200).
            putHeader("content-type", "application/json; charset=utf-8").
            end(resp);
    }
}
