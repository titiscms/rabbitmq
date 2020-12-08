package br.com.rabbitmq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class FirstBasicConsumerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FirstBasicConsumerService.class);
	
	@RabbitListener(queues = { "FIRST-QUEUE-BASIC" })
	public void receiveMessageFromFirstQueue(Message message) {
		LOGGER.info("Inicio do método receiveMessageFromFirstQueue()");
		LOGGER.info(String.format("Recebendo mensagem da fila ", message.getMessageProperties().getConsumerQueue()));
		
		byte[] body = message.getBody();
		
		LOGGER.info(String.format("Corpo da mensagem >>>> ", body.toString()));
		LOGGER.info("Fim do método receiveMessageFromFirstQueue()");
	}

}
