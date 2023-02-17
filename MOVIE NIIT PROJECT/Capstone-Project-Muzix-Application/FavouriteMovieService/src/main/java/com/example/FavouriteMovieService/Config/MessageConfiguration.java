/*
 *Author Name : Seetha Lakshmi.G.M
 *Date : 05-01-2023
 *Created With : IntelliJ IDEA Community Edition
 */

package com.example.FavouriteMovieService.Config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfiguration {
    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}
