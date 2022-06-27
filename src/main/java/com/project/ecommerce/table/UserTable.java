/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
/**
 *
 * @author Ankit Kumar Singh
 */
@Entity
public class UserTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 100, name = "userId")
    private int userId;
    @Column(length = 30, name = "Name")
    private String userName;
    @Column(length = 30, name = "Email")
    private String userEmail;
    @Column(length = 30, name = "Password")
    private String userPassword;
    @Column(length = 10, name = "Phone")
    private String userPhone;
    @Column(name = "Type")
    private String userType;
    

     
    public UserTable() {
    }

    public UserTable(int userId, String userName, String userEmail, String userPassword, String userPhone, String userType) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userType = userType;
    }
    
    

    public UserTable(String userName, String userEmail, String userPassword, String userPhone, String userType) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userType= userType;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userTypt) {
        this.userType = userTypt;
    }

    @Override
    public String toString() {
        return "UserTable{"+ "userTypt=" + userType+ ", userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword + ", userPhone=" + userPhone + '}';
    }

    
     
}
