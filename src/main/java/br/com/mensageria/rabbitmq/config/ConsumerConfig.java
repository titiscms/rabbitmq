package br.com.mensageria.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
	
	@Bean
	public Queue queueBasic() {
		return QueueBuilder
				.durable("FIRST-QUEUE-BASIC")
				.build();
	}
	
	@Bean
	public MessageListenerContainer listenerContainer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
