/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.project.ecommerce.servlets;

import com.project.ecommerce.DataAccessObject.CategoryDao;
import com.project.ecommerce.DataAccessObject.ProductDao;
import com.project.ecommerce.sessionFactory.FactoryProvider;
import com.project.ecommerce.table.CategoryTable;
import com.project.ecommerce.table.ProductTable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Ankit Kumar Singh
 */
@WebServlet(name = "ProductAddServlet", urlPatterns = {"/ProductAddServlet"})
@MultipartConfig
public class ProductAddServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String productName = request.getParameter("productName");
                String productDescription = request.getParameter("productDescription");
                int productPrice = Integer.parseInt(request.getParameter("productPrice"));
                int productDiscount = Integer.parseInt(request.getParameter("productDiscount"));
                int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                Part part = request.getPart("productPhoto");

                ProductTable product = new ProductTable();
                product.setProductName(productName);
                product.setProductDescription(productDescription);
                product.setProductPrice(productPrice); 
                product.setProductDiscount(productDiscount);
                product.setProductQuantity(productQuantity);
                product.setProductPhoto(part.getSubmittedFileName());
 
                //get category by id
                CategoryDao cdoa = new CategoryDao(FactoryProvider.getFactory());
                CategoryTable category = cdoa.getCategoryById(categoryId);

                product.setProductCategory(category);

                 out.println("save");
                //product save...
                ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                pdao.saveProduct(product);
                out.println("save");

                //pic upload
//                find out the path to upload photo
                String path = request.getRealPath("image") + File.separator + "ProductImage" + File.separator + part.getSubmittedFileName();
//                System.out.println(path);

                //uploading code..
                try {

                    FileOutputStream fileOutputStream = new FileOutputStream(path);

                    InputStream inputStream = part.getInputStream();

//                reading data
                    byte[] data = new byte[inputStream.available()];

                    inputStream.read(data);

//                writing the data
                    fileOutputStream.write(data);

                    fileOutputStream.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("message", "Product is added successfully.");
                response.sendRedirect("admin.jsp");
                return;

        

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
