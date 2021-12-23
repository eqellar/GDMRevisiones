<%-- 
    Document   : logistica
    Created on : 25/09/2017, 03:39:14 PM
    Author     : Corei3
--%>

<%
    String id_usuario = (String) request.getSession().getAttribute("id_usuario");
    //request.getSession().setAttribute("id_usuario", id_usuario);
    String d = "http://localhost:8084/GDMRevisiones/logout.do";
    String p = "http://10.160.50.63:8080/GDMRevisiones/logout.do";
    request.getSession().setAttribute("logout", p);
    
    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    if (nombreUsuario != null) {
        out.print("<h5>¡Hola! " + nombreUsuario + " ===> <a href='"+p+"'>Cerrar sesion</a></h5>");
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
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body
        <%
            if (nombreUsuario != null) {
        %>
        <hr>             
        <div align="left"><img src="images/global.jpg"> <img src="images/fu.jpg" align="right"></div>
        <br>
        <hr>
    <body>
        <table border= "0" width="1000" align="center">
            <h4 align="center">Consultar datos</h4>
            <tr bgcolor="yellow">
                <th><a href="revPendientes.jsp">Ver solicitudes Pendientes</a></th>                
                <th><a href="revAgendadas.jsp">Ver solicitudes Agendadas</a></th>
                <th><a href="revAtendidas.jsp">Ver solicitudes Atendidas</a></th>                
                <th><a href="revCanceladas.jsp">Ver solicitudes Canceladas</a></th>
            </tr>
        </table>
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
