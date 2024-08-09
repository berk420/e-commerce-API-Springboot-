package com.draft.e_commerce.model;

import java.util.Set;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "stock")
    private long stock;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CartEntry> cartEntries;

    // Default constructor
    public Product() {
    }

    // Parameterized constructor
    public Product(String name, String description, long price, long stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;

    }

    public Set<CartEntry> getCartEntries() {
        return cartEntries;
    }

    public void setCartEntries(Set<CartEntry> cartEntries) {
        this.cartEntries = cartEntries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               '}';
    }
}
