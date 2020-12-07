package br.com.mensageria.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("direct")
@Configuration
public class DirectConfig {

	@Autowired
	private Queue firstQueue;
	
	@Autowired
	private Queue secondQueue;
	
	@Bean
	public Exchange directExchange() {
		return ExchangeBuilder
				.directExchange("DIRECT-EXCHANGE-BASIC")
				.durable(true)
				.build();
	}
	
	@Bean
	public Binding firstDirectExchange() {
		return BindingBuilder
				.bind(firstQueue)
				.to(directExchange())
				.with("TO-FIRST-QUEUE")
				.noargs();
	}
	
	@Bean
	public Binding secondDirectExchange() {
		return BindingBuilder
				.bind(secondQueue)
				.to(directExchange())
				.with("TO-SECOND-QUEUE")
				.noargs();
	}
	
}
