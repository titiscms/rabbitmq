package br.com.rabbitmq.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class BasicListenerService implements MessageListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicListenerService.class);
	
	@Override
	public void onMessage(Message message) {
		LOGGER.info("Inicio do método onMessage()");
		LOGGER.info(String.format("Recebendo mensagem da fila ", message.getMessageProperties().getConsumerQueue()));
		
		byte[] body = message.getBody();
		
		LOGGER.info(String.format("Corpo da mensagem >>>> ", body.toString()));
		LOGGER.info("Fim do método onMessage()");
	}

}
