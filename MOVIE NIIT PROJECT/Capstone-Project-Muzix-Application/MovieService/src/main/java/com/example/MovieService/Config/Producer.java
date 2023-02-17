/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */


package com.example.MovieService.Config;

import com.example.MovieService.RabbitMq.Domain.FavouriteDTO;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final RabbitTemplate rabbitTemplate;
    private final DirectExchange exchange;

    @Autowired
    public Producer(RabbitTemplate rabbitTemplate, DirectExchange exchange) {
        super();
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
    }

    public void sendMessageToRabbitMq(FavouriteDTO favouriteDTO)
    {
        rabbitTemplate.convertAndSend(exchange.getName(),MessageConfiguration.MESSAGE_KEY,favouriteDTO);
    }

}