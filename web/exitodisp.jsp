<%-- 
    Document   : exitodisp
    Created on : 17/03/2017, 06:45:20 PM
    Author     : Corei3
--%>

<%
    String exito = (String)request.getSession().getAttribute("exito");
    String imei = (String)request.getSession().getAttribute("imei");
    request.getSession().setAttribute("imei", imei);
    
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> <%=exito  %></h1>
        <div>
            <input type="text" name="imei" value="<%=imei%>" readonly=""/>
        </div>
        <meta http-equiv="Refresh" CONTENT="2;url=asignFuncion.jsp">
    </body>
</html>
