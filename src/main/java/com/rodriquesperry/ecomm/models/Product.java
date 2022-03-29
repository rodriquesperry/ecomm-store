package com.rodriquesperry.ecomm.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private long price;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<CartItem> cartItemItems;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<Image> images;

    @ManyToOne
    private User admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<CartItem> getCartItems() {
        return cartItemItems;
    }

    public void setCartItems(List<CartItem> cartItemItems) {
        this.cartItemItems = cartItemItems;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }
}
