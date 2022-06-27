/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.DataAccessObject;

import com.project.ecommerce.table.UserTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Ankit Kumar Singh
 */
public class UserDao {
  private SessionFactory factory;

    public UserDao(SessionFactory factory) {
        this.factory = factory;
    }
    
    //get user by email and password
    public UserTable getUserEmailAndPassword(String email,String password)
    {
        UserTable userData=null;
        
        try {
            
            String sqlQuery="from UserTable where userEmail =: email and userPassword=: password";
            Session session = this.factory.openSession();
            Query query = session.createQuery(sqlQuery);
            query.setParameter("email", email);
            query.setParameter("password",password);            
            userData=(UserTable) query.uniqueResult();         
            session.close();         
     
        } catch (Exception e) {
            e.printStackTrace();
        }     
        
        
        
        
        return userData;
    }
    
    
}
