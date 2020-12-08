package br.com.rabbitmq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rabbitmq.consumer.domain.Person;

@Service
public class JsonConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonConsumerService.class);
	
	@Autowired
	private MessageConverter messageConverter;
	
	@RabbitListener(queues = { "JSON-QUEUE-BASIC" })
	public void receiveMessageFromJsonQueue(Message message) {
		LOGGER.info("Inicio do método receiveMessageFromJsonQueue()");
		LOGGER.info(String.format("Recebendo mensagem da fila %s", message.getMessageProperties().getConsumerQueue()));
		
		Person person = (Person) messageConverter.fromMessage(message);
		
		LOGGER.info(String.format("Corpo da mensagem >>>> %s", message.getBody().toString()));
		LOGGER.info(String.format("Nome da pessoa >>>> %s", person.getName()));
		LOGGER.info("Fim do método receiveMessageFromJsonQueue()");
	}

}
