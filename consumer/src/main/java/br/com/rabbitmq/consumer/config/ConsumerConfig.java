package br.com.rabbitmq.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.rabbitmq.consumer.service.BasicListenerService;

@Configuration
public class ConsumerConfig {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerConfig.class);
	
	@Autowired
	private ConnectionFactory connectionFactory;
	
	@Autowired
	private BasicListenerService basicListenerService;
	
	@Autowired
	private SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory;
		
	@Bean
	public MessageListenerContainer listenerContainer() {
		LOGGER.info("Inicio do método listenerContainer()");
		
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames("SECOND-QUEUE-BASIC");
		container.setMessageListener(basicListenerService);
		
		simpleRabbitListenerContainerFactory.getAdviceChain();
		
//		container.start();
		
		LOGGER.info("Fim do método listenerContainer()");
		return container;
	}
	
}
