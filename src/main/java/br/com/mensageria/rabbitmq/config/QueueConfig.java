package br.com.mensageria.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

	@Bean
	public Queue firstQueue() {
		return QueueBuilder
				.durable("FIRST-QUEUE-BASIC")
				.build();
	}
	
	@Bean
	public Queue secondQueue() {
		return QueueBuilder
				.durable("SECOND-QUEUE-BASIC")
				.build();
	}
	
}
