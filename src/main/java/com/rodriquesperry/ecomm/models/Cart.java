package com.rodriquesperry.ecomm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User customer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<CartItem> cartItems;

//    @ManyToOne
//    @JoinColumn(name = "cart_item_id")
//    private CartItem cartItem;

//    @ManyToMany(mappedBy = "carts")
//    private List<CartItem> cartItems;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    //    public List<CartItem> getCartItems() {
//        return cartItems;
//    }
//
//    public void setCartItems(List<CartItem> cartItems) {
//        this.cartItems = cartItems;
//    }


//    public CartItem getCartItem() {
//        return cartItem;
//    }
//
//    public void setCartItem(CartItem cartItem) {
//        this.cartItem = cartItem;
//    }
}
