<%-- 
    Document   : exito
    Created on : 8/03/2017, 04:22:57 PM
    Author     : Corei3
--%>
<%@page session="true"%>
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
    setTimeout("location.href='sistema.jsp'", 3000);
  }
  </script>
    </head>
    <body onLoad="redireccionar()">
        <h1> <%=exito  %></h1>
        
    </body>
</html>
