<%-- 
    Document   : regUsuario
    Created on : 24/02/2017, 07:06:48 PM
    Author     : Corei3
--%>

<%
    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    String d = (String) request.getSession().getAttribute("logout");    
    if (nombreUsuario != null) {
        out.print("<h5>¡Hola! " + nombreUsuario + " ===> <a href='"+d+"'>Cerrar sesion</a></h5>");
        //request.getSession().setAttribute("tipouser", tipouser);
    }
%>

<%
    response.setHeader("Pragma", "no-cache");
    response.addHeader("Cache-Control", "must-revalidate");
    response.addHeader("Cache-Control", "no-cache");
    response.addHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Registro de Usuarios</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
        <h1>Ingrese los datos reuqeridos para el registro de un nuevo usuario...</h1>
              <form action="registrousuario.do" method="post">
        <table>
            <tr>
                <td>Nombre</td>
                <td><input type="text" name="txtNombre"/></td>
            </tr>
            <tr>
                <td>Apellido</td>
                <td><input type="text" name="txtApellidos"/></td>
            </tr>
            <tr>
                <td>Nivel</td>
                        <td>
                            <select name="txtNivelUser">
                                <option selected="selected" value="vacio"> </option>
                                <option value="3">Consulta</option>
                                <option value="2">Monitoreo</option>
                                <option value="1">Adminitrador</option>
                                
                             
                            </select>
                        </td>
            </tr>
            <tr>
                <td>Usuario</td>
                <td><input type="text" name="txtUsuario"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="txtPassword"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Registrar..."/></td>
            </tr>
        </table>
            </form>
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
