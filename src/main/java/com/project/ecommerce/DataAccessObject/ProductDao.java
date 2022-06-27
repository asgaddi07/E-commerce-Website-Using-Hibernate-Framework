/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.DataAccessObject;

import com.project.ecommerce.table.ProductTable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Ankit Kumar Singh
 */
public class ProductDao {
 
    private SessionFactory factory;

    public ProductDao(SessionFactory factory) {
        this.factory = factory;
    }

    public boolean saveProduct(ProductTable product) {
        boolean flag = false;
        try {

            Session session = this.factory.openSession();
            Transaction transaction = session.beginTransaction();

            session.save(product);

            transaction.commit();
            session.close();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }

    //get all products
    public List<ProductTable> getAllProducts() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from ProductTable");
        List<ProductTable> list = query.list();
        return list;
    }

    //get all  products of given category
    public List<ProductTable> getAllProductsByProductId(int categoryId) {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from ProductTable as product where product.category.categoryId =: id");
        query.setParameter("id", categoryId);
        List<ProductTable> list = query.list();
        return list;
    }
}
