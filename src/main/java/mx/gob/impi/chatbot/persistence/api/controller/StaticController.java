package mx.gob.impi.chatbot.persistence.api.controller;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class StaticController {
	//@GetMapping(value = "{_:^(?!index\\.html|swagger-ui\\.html|api).$}")
	@GetMapping(value = "/")
	public ResponseEntity<Void> redirectApi() {
	      return ResponseEntity
	    		  .status(HttpStatus.FOUND)
	              .location(URI.create("/index.html"))
	              .build();
	}
}
