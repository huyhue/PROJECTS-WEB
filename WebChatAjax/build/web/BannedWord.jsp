<%@page import="java.util.List"%>
<%@page import="model.MessageModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>Web chat</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="container">
                    <h1>Ban Word</h1>
                    <form method="POST" action='BannedWord' class="form">
                            <input type="text" name="word">
                            <button type="submit" id="login-button" value="Submit">Ban</button>
                    </form>
            </div>
            <div>
               <h3> List Banned Word: </h3>
               <p>
                    <%
                         MessageModel s = new MessageModel();
                         List<String> list = s.getAllBannerWords();
                         for(String x:list){
                     %>
                      "<%=x%>" 
                     <%}%>
               </p>   
            </div>
        </div>
    </body>
</html>