package com.rodriquesperry.ecomm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @ManyToOne
    private Cart cartItem;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cart getCartItem() {
        return cartItem;
    }

    public void setCartItem(Cart cartItem) {
        this.cartItem = cartItem;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }
}
