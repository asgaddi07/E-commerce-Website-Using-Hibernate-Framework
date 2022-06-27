/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.DataAccessObject;

import com.project.ecommerce.table.CategoryTable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Ankit Kumar Singh
 */
public class CategoryDao {
  private SessionFactory factory;

    public CategoryDao(SessionFactory factory) {
        this.factory = factory;
    }

    //saves the category to db
    public void saveCategory(CategoryTable category) {

        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(category);
        transaction.commit();
        session.close();
    }

    public List<CategoryTable> getCategories() {
        Session session = this.factory.openSession();
        Query query = session.createQuery("from CategoryTable");
        List<CategoryTable> list = query.list();
        return list;
    } 

    public CategoryTable getCategoryById(int categoryid) {
        CategoryTable category = null;
        try {

            Session session = this.factory.openSession();
             category= session.get(CategoryTable.class, categoryid);
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return category;
    }
}
