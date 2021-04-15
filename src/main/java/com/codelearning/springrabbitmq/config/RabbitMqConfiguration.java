package com.codelearning.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
public class RabbitMqConfiguration {

    @Value("${direct.exchange.name}")
    private String exchangeName;

    @Value("${admin.queue.name}")
    private String adminQueueName;

    @Value("${admin.routing.name}")
    private String adminRoutingKey;

    @Value("${user.queue.name}")
    private String userQueueName;

    @Value("${user.routing.name}")
    private String userRoutingKey;


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue adminQueue() {
        return new Queue(adminQueueName, true);
    }

    @Bean
    Queue userQueue() {
        return new Queue(userQueueName, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }


    @Bean
    Binding adminBinding(Queue adminQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(adminQueue).to(directExchange).with(adminRoutingKey);
    }

    @Bean
    public Binding userBinding(final Queue userQueue, final DirectExchange directExchange) {
        return BindingBuilder.bind(userQueue).to(directExchange).with(userRoutingKey);
    }


}
