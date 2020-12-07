package br.com.mensageria.rabbitmq.service;

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
		LOGGER.info("Inicio do método onMessage");
		
		// TODO Auto-generated method stub
		
		LOGGER.info("Fim do método onMessage");
	}

}
