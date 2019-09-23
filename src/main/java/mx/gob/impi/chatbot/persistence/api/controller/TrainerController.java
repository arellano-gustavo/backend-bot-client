package mx.gob.impi.chatbot.persistence.api.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mx.gob.impi.chatbot.persistence.api.model.domain.LoginResponse;
import mx.gob.impi.chatbot.persistence.api.model.domain.MainControllerResponse;

@RestController
@Api(value = "trainer")
@RequestMapping(value = "/api/chatbot/trainer")
public class TrainerController {
    @ApiOperation(
        value = "TrainerController::create-intent",
        notes = "Crea un intent")
    @RequestMapping(
        value = "/create-intent.json",
        method = POST,
        produces = "application/json; charset=utf-8")
    public MainControllerResponse createIntent(String intent) {
        return null;
    }
}
