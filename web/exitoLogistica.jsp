<%-- 
    Document   : exitoLogistica
    Created on : 27/09/2017, 03:19:02 PM
    Author     : Corei3
--%>

<%
    String exito = (String)request.getSession().getAttribute("exito");
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script language="JavaScript">
  function redireccionar() {
    setTimeout("location.href='logistica.jsp'", 3000);
  }
  </script>
    </head>
    <body onLoad="redireccionar()">
        <h1> <%=exito  %></h1>
    </body>
</html>
