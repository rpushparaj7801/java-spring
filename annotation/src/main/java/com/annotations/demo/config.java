package com.annotations.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class config {
    @Bean
        public helloworld helloWorld(){
            return new helloworld();
        }
    }

