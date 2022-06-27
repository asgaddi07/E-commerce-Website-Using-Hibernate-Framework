<%-- 
    Document   : index
    Created on : 25-Jun-2022, 5:21:25 PM
    Author     : Ankit Kumar Singh
--%>

<%@page import="com.project.ecommerce.other.TrimDescription"%>
<%@page import="com.project.ecommerce.table.CategoryTable"%>
<%@page import="com.project.ecommerce.DataAccessObject.CategoryDao"%>
<%@page import="com.project.ecommerce.table.ProductTable"%>
<%@page import="java.util.List"%>
<%@page import="com.project.ecommerce.DataAccessObject.ProductDao"%>
<%@page import="com.project.ecommerce.sessionFactory.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <%@include file="Css/commonCss.jsp" %>
        <%@include file="JavaScript/commonJavaScript.jsp" %>
    </head>
    <body>
        <%@include file="CommonDesign/navigationBar.jsp" %>
         <div class="container-fluid">
            <div class="row mt-3 mx-2">
                
                <%
                    String categoryValue = request.getParameter("category");
            ProductDao productDao=new ProductDao(FactoryProvider.getFactory());
            List<ProductTable> productList= productDao.getAllProducts();
            if (categoryValue == null || categoryValue.trim().equals("all")) {
                        productList = productDao.getAllProducts();
                    } else {
                        int categoryId = Integer.parseInt(categoryValue.trim());
                        productList = productDao.getAllProductsByProductId(categoryId);
                    }
            CategoryDao categoryDao=new CategoryDao(FactoryProvider.getFactory());
            List<CategoryTable> categoryList= categoryDao.getCategories();
                %>
                
                <!--show categories-->
                <div class="col-md-2">


                    <div class="list-group mt-4">

                        <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
                            All Products
                        </a>




                        <% for (CategoryTable c : categoryList) {
                        %>



                        <a href="index.jsp?categoryId=<%= c.getCategoryId()%>" class="list-group-item list-group-item-action"><%= c.getCategoryName()%></a>


                        <%    }
                        %>



                    </div>


                </div>

                <!--show products-->
                <div class="col-md-10">


                    <!--row-->
                    <div class="row mt-4">

                        <!--col:12-->
                        <div class="col-md-12">

                            <div class="card-columns">

                                <!--traversing products-->

                                <%
                                    for (ProductTable product : productList) {

                                %>


                                <!--product card-->
                                <div class="card product-card">

                                    <div class="container text-center">
                                        <img src="image/ProductImage/<%= product.getProductPhoto()%>" style="max-height: 200px;max-width: 100%;width: auto; " class="card-img-top m-2" alt="...">

                                    </div>

                                    <div class="card-body">

                                        <h5 class="card-title"><%= product.getProductName()%></h5>
                                         <p class="card-text">
                                             <%= TrimDescription.getTrimWords(product.getProductDescription()) %>
                                        </p>
                                    </div>

                                   
                              <div class="card-footer text-center">
                                <button class="btn custom-bg text-white" onclick="addToCart(<%= product.getProductId()%>, '<%= product.getProductName()%>',<%= product.getPriceAfterDiscount()%>)">Add to Cart</button>
                                    <button class="btn  btn-outline-success ">  &#8377;<%= product.getPriceAfterDiscount()%>  /-  <span class="text-secondary discount-label">  &#8377; <%= product.getProductPrice()%> , <%= product.getProductDiscount()%>% off </span>  </button>
                                    </div>
 
                                </div>
         
                                 




                                 <%}

                                    if (productList.size() == 0) {
                                        out.println("<h3>No item in this category</h3>");
                                    }


                                %>


                         </div>                       



                        </div>                   

                    </div>



                </div>

            </div>
        </div>
          <%@include  file="CommonDesign/modals.jsp" %>
    </body>
</html>
