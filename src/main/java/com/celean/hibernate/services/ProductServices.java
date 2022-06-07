package com.celean.hibernate.services;

import com.celean.hibernate.model.Buyer;
import com.celean.hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServices {

    @Autowired
    private SessionFactory factory;

    // Добавление нового продукта
    public void saveProduct(Product anyProduct) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(anyProduct);
            session.getTransaction().commit();

        }
    }
    // Ищем продукт по id через get
    public Product getProductById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;

        }
    }

    // Удаляем продукт по id
    public void deleteProduct(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.find(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }

    }

    // Переписываем цену выбранного продукта
    public void updateProductPrice(Long id, int newPrice){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setCost(newPrice);
            session.getTransaction().commit();
        }
    }

    public List<Product> findAll(){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return productList;
        }

    }

    public void getBuyersOfProduct(Long id){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            System.out.println(product);
            List<Buyer> buyerList = product.getBuyerList();
            buyerList.forEach(s-> System.out.println(s));
            session.getTransaction().commit();
        }
    }


}
