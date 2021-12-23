<%-- 
    Document   : sistema
    Created on : 24/02/2017, 01:07:01 PM
    Author     : Corei3
--%>
<%
    
    //request.getSession().setAttribute("id_usuario", id_usuario);
    String d = "http://localhost:8080/GDMRevisiones/logout.do";
    String p = "http://10.160.50.63:8080/GDMRevisiones/logout.do";
    request.getSession().setAttribute("logout", p);
    
    
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    if (nombreUsuario != null) {
        out.print("<h4 align='right'>¡Entró al sistema como! " + nombreUsuario + " ===> <a href='"+d+"'>Cerrar sesion</a></h5>");
        //request.getSession().setAttribute("tipouser", tipouser);
        
    }
   
%>

<% 
response.setHeader( "Pragma", "no-cache" ); 
response.addHeader( "Cache-Control", "must-revalidate" ); 
response.addHeader( "Cache-Control", "no-cache" ); 
response.addHeader( "Cache-Control", "no-store" ); 
response.setDateHeader("Expires", 0); 
%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file = "banner.jsp" %>
<%@include file = "menu.jsp" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        
        
        <%
        } else {

        %>
        <h1>Su sesión ah expirado, favor iniciar sesión</h1>
        <a href="index.jsp">Inicio de Sesión</a>        
        <%
            }
        %>
    </body>
</html>
