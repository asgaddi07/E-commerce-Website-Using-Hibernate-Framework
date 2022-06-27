package com.project.ecommerce.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ankit Kumar Singh
 */

@Entity
public class ProductTable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    @Column(length = 2500)
    private String productDescription;
    private String productPhoto;
    private int productPrice;
    private int productDiscount;
    private int productQuantity;
    @ManyToOne
    private CategoryTable productCategory;

    public ProductTable() {
    }

    public ProductTable(int productId, String productName, String productDescription, String productPhoto, int productPrice, int productDiscount, int productQuantity, CategoryTable productCategory) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPhoto = productPhoto;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productQuantity = productQuantity;
        this.productCategory = productCategory;
    }

    

    public ProductTable(String productName, String productDescription, String productPhoto, int productPrice, int productDiscount, int productQuantity,CategoryTable productCategory) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPhoto = productPhoto;
        this.productPrice = productPrice;
        this.productDiscount = productDiscount;
        this.productQuantity = productQuantity;
        this.productCategory=productCategory;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public CategoryTable getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(CategoryTable productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "ProductTable{" + "productId=" + productId + ", productName=" + productName + ", productDescription=" + productDescription + ", productPhoto=" + productPhoto + ", productPrice=" + productPrice + ", productDiscount=" + productDiscount + ", productQuantity=" + productQuantity + '}';
    }
    
    //calculate price after discount
    public int getPriceAfterDiscount() {
        int discount = (int) ((this.getProductDiscount()/ 100.0) * this.getProductPrice());
        return this.getProductPrice()- discount;
    }
}
