package com.amigos.modal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Product {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
//    @Column(name = "stock_keeping_unit",nullable = false)
    private String sku;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean active;
    private String imageUrl;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;


    public Product() {
    }

    public Product(String sku, String name, String description, BigDecimal price, Boolean active, String imageUrl, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.active = active;
        this.imageUrl = imageUrl;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}

