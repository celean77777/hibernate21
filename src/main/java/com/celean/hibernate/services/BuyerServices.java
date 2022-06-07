package com.celean.hibernate.services;

import com.celean.hibernate.model.Buyer;
import com.celean.hibernate.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BuyerServices {

    @Autowired
    private SessionFactory factory;

    // Добавление нового продукта
    public void saveBuyer(Buyer anyBuyer) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(anyBuyer);
            session.getTransaction().commit();

        }
    }
    // Ищем продукт по id через get
    public Buyer getBuyerById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;

        }
    }

    // Удаляем продукт по id
    public void deleteBuyer(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.find(Buyer.class, id);
            session.delete(buyer);
            session.getTransaction().commit();
        }

    }

    // Переписываем цену выбранного продукта
    public void updateBuyerName(Long id, String newName){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            buyer.setName(newName);
            session.getTransaction().commit();
        }
    }

    public List<Buyer> findAll(){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Buyer> buyerList = session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
            return buyerList;
        }

    }

    public void getProductsOfBuyer(Long id){
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            List<Product> productList = buyer.getProductList();
            productList.forEach(s-> System.out.println(s));
            session.getTransaction().commit();
        }
    }


}
