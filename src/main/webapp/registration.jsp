<%-- 
    Document   : registration
    Created on : 26-Jun-2022, 12:39:47 AM
    Author     : Ankit Kumar Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
         <%@include file="Css/commonCss.jsp" %>
        <%@include file="JavaScript/commonJavaScript.jsp" %>
    </head>
    <body>
         <%@include file="CommonDesign/navigationBar.jsp" %>
        <div class="container-fluid">
            <div class="row mt-3">
                <div class="col-md-4 offset-md-4">                  

                    <div class="card">     
                        <%@include  file="CommonDesign/displayMessage.jsp" %>
                        <div class="card-body px-5">
                            <div class="container text-center">
                                <img src="img/add-friend.png"  style="max-width: 100px;" class="img-fluid" alt="">
                            </div>

                            <h3 class="text-center my-3">Registration/Create New Account</h3>

                            <form action="RegistrationServlet" method="post">

                                <div class="form-group">
                                    <label for="name">Name:</label>
                                    <input name="userName" type="text" class="form-control" id="name" placeholder="Enter User Name...." aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="email">Email:</label>
                                    <input name="userEmail" type="email" class="form-control" id="email" placeholder="Enter Email Address...." aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="password">Password:</label>
                                    <input name="userPassword" type="password" class="form-control" id="password" placeholder="Enter Password...." aria-describedby="emailHelp">
                                </div>

                                <div class="form-group">
                                    <label for="phone">Phone:</label>
                                    <input name="userPhone" type="number" class="form-control" id="phone" placeholder="Enter Phone Number...." aria-describedby="emailHelp">
                                </div>

                                <div class="container text-center"> 
                                    <button class="btn btn-outline-success">Register</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

