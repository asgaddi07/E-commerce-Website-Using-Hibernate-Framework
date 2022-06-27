<%-- 
    Document   : displayMessage
    Created on : 26-Jun-2022, 2:47:40 AM
    Author     : Ankit Kumar Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String message = (String) session.getAttribute("message");
    if (message != null) {
%>


<div class="alert alert-success alert-dismissible fade show" role="alert">
    <strong><%= message%></strong> 
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
</div>


<% 
    session.removeAttribute("message");
    }
%>