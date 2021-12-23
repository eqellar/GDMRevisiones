<%-- 
    Document   : regVehiculo
    Created on : 24/02/2017, 07:07:25 PM
    Author     : Corei3
--%>
<%@page import="dto.ClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClienteDAO"%>

<%
    ClienteDAO clie = new ClienteDAO();
    ArrayList<ClienteDTO> listclie = clie.readAll();

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
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Registro de Vehículos</h2></div>
        <hr>
        <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
        <hr>
        <h1>Ingrea los datos solicitados</h1>
        <form action="registrovehiculo.do" method="post" onsubmit="return comprobar()">
            <table>

                <tr>
                    <td>Marca</td>
                    <td><input type="text" name="txtMarca"/></td>
                </tr>
                <tr>
                    <td>Submarca</td>
                    <td><input type="text" name="txtSubmarca"/></td>
                </tr>
                <tr>
                    <td>Modelo</td>
                    <td><input type="text" name="txtModelo"/></td>
                </tr>
                <tr>
                <tr>
                    <td>Color</td>
                    <td><input type="text" name="txtColor"/></td>
                </tr>
                <tr>

                <tr>
                    <td>Eco</td>
                    <td><input type="text" name="txtEco"/></td>
                </tr>
                <tr>

                <tr>
                    <td>Placas</td>
                    <td><input type="text" name="txtPlacas"/></td>
                </tr>
                <tr>

                    <td>Clientes</td>
                    <td>
                        <select name="txtClientes">

                            <%
                                for (int i = 0; i < listclie.size(); i++) {
                                    out.println("<option value=\"" + listclie.get(i).getId_cliente() + "\">" + listclie.get(i).getAlias() + "</option>");
                                }


                            %>


                        </select>
                    </td>
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
        <%            }
        %>

    </body>
</html>
