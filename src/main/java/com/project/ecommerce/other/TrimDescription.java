/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.ecommerce.other;

/**
 *
 * @author Ankit Kumar Singh
 */
public class TrimDescription {
       public static String getTrimWords(String description)
    {
        String[] trimString = description.split(" ");
        
        if(trimString.length>10)
        {
            String resultString="";
            for(int i=0;i<15;i++)
            {
                resultString = resultString + trimString[i]+" ";
            }
            return (resultString+"........");
        }else
        {
            
            return (description+".......");
        }
        
    }
       
       
}
