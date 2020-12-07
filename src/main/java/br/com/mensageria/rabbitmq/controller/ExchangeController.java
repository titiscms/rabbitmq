package br.com.mensageria.rabbitmq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/exchanges")
public class ExchangeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExchangeController.class);
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping(path = "/{exchange}/{routingKey}")
	public HttpEntity<?> postOnExchange(@PathVariable String exchange, @PathVariable String routingKey, @RequestBody String message) {
		
		LOGGER.info("Inicio do método postOnExchange");
		LOGGER.info(String.format("Enviando a mensagem >>>>>>> %s.", message));
		
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
		
		LOGGER.info("Fim do método postOnExchange");
		
		return ResponseEntity.ok().build();
	}	
	
}
