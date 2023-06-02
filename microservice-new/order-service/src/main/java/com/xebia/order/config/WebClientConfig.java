package com.xebia.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author saran saravanan
 * @version 1.0
 * @since 18/05/2023
 */
@Configuration
public class WebClientConfig {

        /** it will balance the instance client from netflix discovery service server*/
        @Bean
        @LoadBalanced
        public WebClient.Builder webClientBuilder(){
        return WebClient.builder();
    }
}
