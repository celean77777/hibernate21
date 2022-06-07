package com.celean.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    @ManyToMany
    @JoinTable(
            name = "buyers_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )

    private List<Buyer> buyerList;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public List<Buyer> getBuyerList() {
        return buyerList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBuyerList(List<Buyer> buyerList) {
        this.buyerList = buyerList;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return String.format("Product [id = %d, title = %s, cost = %d]", id, title, cost);
    }
}
