<%-- 
    Document   : error
    Created on : 24/02/2017, 01:01:18 PM
    Author     : Corei3
--%>

<%@page session="true"%>
<%
    String error = (String)request.getSession().getAttribute("error");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body onload="setTimeout('history.back()',3000)">
        <h1> <%=error  %></h1>
        
    </body>
</html>
