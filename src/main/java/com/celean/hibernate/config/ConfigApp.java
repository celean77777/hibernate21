package com.celean.hibernate.config;

import com.celean.hibernate.factory.FactoryInit;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("com.celean.hibernate")
public class ConfigApp {

    @Bean
    public static SessionFactory init() {
        SessionFactory factory = FactoryInit.init();
        return factory;
    }
}
