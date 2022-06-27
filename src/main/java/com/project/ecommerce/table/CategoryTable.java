/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.table;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ankit Kumar Singh
 */

@Entity
public class CategoryTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    @OneToMany(mappedBy = "productCategory")
    private List<ProductTable> products = new ArrayList<>();

    public CategoryTable() {
    }

    public CategoryTable(int categoryId, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

     

    public CategoryTable(String categoryName, String categoryDescription, List<ProductTable> products) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.products=products;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public List<ProductTable> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTable> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "CategoryTable{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription=" + categoryDescription + ", products=" + products + '}';
    }
    
}
