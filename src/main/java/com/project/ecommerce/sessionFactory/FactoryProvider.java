/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.sessionFactory;

/**
 *
 * @author Ankit Kumar Singh
 */
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider{

    private static SessionFactory factory;

    public static SessionFactory getFactory() {
        try { 
            if(factory == null) {
                factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("session");
        return factory;
        
    }
}
