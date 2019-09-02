package mx.gob.impi.chatbot.engine.rest;

import org.apache.log4j.Logger;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;
import mx.gob.impi.chatbot.engine.model.ChatbotRequest;
import mx.gob.impi.chatbot.engine.service.*;
import mx.gob.impi.chatbot.engine.utils.Support;

/**
 * Clase controlador que contiene el flujo de negocio para exponer la búsqueda de RFC en LCO
 * @author gustavo
 *
 */
public class ServiceController extends AbstractVerticle {
    private final static Logger logger = Logger.getLogger(ServiceController.class);
    private TextClientSrv textClientSrv = new TextClientSrvImpl();
    
    /**
     * Inicializa el servicio de búsqueda
     */
    public void start(Future<Void> fut) {
        logger.info("Iniciando vertical");
        
        Router router = Router.router(vertx);
        router.route("/*").handler(StaticHandler.create("assets")); 
        
        router.route().handler(BodyHandler.create());
        router.post("/api/challenge").handler(this::processChallengeByArea);
        router.post("/api/chatbot").handler(this::chatbot);

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

}
