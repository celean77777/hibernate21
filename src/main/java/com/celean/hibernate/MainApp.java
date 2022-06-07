package com.celean.hibernate;

import com.celean.hibernate.config.ConfigApp;
import com.celean.hibernate.services.BuyerServices;
import com.celean.hibernate.services.ProductServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigApp.class);
        ProductServices productServices = ctx.getBean(ProductServices.class);
        BuyerServices buyerServices = ctx.getBean(BuyerServices.class);

        System.out.println(productServices.getProductById(2L));

        buyerServices.getProductsOfBuyer(3L);

        productServices.getBuyersOfProduct(1L);

    }
}
