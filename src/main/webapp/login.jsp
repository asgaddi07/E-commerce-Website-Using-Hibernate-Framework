<%-- 
    Document   : login
    Created on : 26-Jun-2022, 1:04:44 AM
    Author     : Ankit Kumar Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogIn Page</title>
         <%@include file="Css/commonCss.jsp" %>
        <%@include file="JavaScript/commonJavaScript.jsp" %>
    </head>
    <body>
       <%@include file="CommonDesign/navigationBar.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card mt-3">
                        <div class="card-header custom-bg text-info">
                            <h3>Login here</h3>
                        </div>
                        <div class="card-body">                            
                            <%@include file="CommonDesign/displayMessage.jsp" %>
                            <form action="LogInServlet" method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input  name="userEmail" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Email Address....">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input  name="userPassword" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                                </div>
                                <a href="registration.jsp" class="text-center d-block mb-2">Registration/Create new Account.</a>
                               <div class="container text-center"> 
                                   <button type="submit" class="btn btn-primary border-0 custom-bg ">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
