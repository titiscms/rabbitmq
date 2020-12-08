package br.com.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("fanout")
@Configuration
public class FanoutConfig {

	@Autowired
	private Queue firstQueue;
	
	@Autowired
	private Queue secondQueue;
	
	@Bean
	public Exchange fanoutExchange() {
		return ExchangeBuilder
				.fanoutExchange("FANOUT-EXCHANGE-BASIC")
				.durable(true)
				.build();
	}
	
	@Bean
	public Binding firstFanoutExchange() {
		return BindingBuilder
				.bind(firstQueue)
				.to(fanoutExchange())
				.with("")
				.noargs();
	}
	
	@Bean
	public Binding secondFanoutExchange() {
		return BindingBuilder
				.bind(secondQueue)
				.to(fanoutExchange())
				.with("")
				.noargs();
	}
	
}
