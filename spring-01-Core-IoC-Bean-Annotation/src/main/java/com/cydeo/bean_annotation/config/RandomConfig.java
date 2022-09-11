package com.cydeo.bean_annotation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {

    @Bean
    public Integer integer(){
        return 1;
    }

    @Bean
    public String str(){
        return "Cydeo";
    }

}
