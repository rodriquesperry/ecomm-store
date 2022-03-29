package com.rodriquesperry.ecomm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long productQuantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    private Cart cart;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cartItem")
//    private List<Cart> carts;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "cart_items_carts",
//            joinColumns ={@JoinColumn(name = "cart_item_id")},
//            inverseJoinColumns ={@JoinColumn(name = "cart_id")}
//    )
//    private List<Cart> carts;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getQuantity(long quantity) {
        return productQuantity;
    }

    public void setQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public long getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(long productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    //    public List<Cart> getCarts() {
//        return carts;
//    }

//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }


//    public void setCarts(List<Cart> carts) {
//        this.carts = carts;
//    }
}
