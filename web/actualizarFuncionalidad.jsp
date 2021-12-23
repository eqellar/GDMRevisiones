<%-- 
    Document   : actualizarfuncionalidad
    Created on : 24/03/2017, 04:41:22 PM
    Author     : Corei3
--%>

<%@page session="true"%>
<%@page import="dto.FuncionalidadDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FuncionalidadDAO"%>
<%
    FuncionalidadDAO fun = new FuncionalidadDAO();
    ArrayList<FuncionalidadDTO> listfun = fun.readAll();
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
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Actualizar Funcionalidades</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
        <h1>Seleccione la Funcionalidad que desea modificar</h1>

        <form action="actualizarfuncionalidad.do" method="post">
            <table>
                <tr>
                    <td>Funcionalidad</td>
                    <td>
                        <select name="txtFuncionalidad">
                            <option selected="selected" value="vacio"> </option>
                            <%
                                for (int i = 0; i < listfun.size(); i++) {
                                    out.println("<option>" + listfun.get(i).getTipo() + "</option>");
                                }
                            %>
                        </select>
                    </td>
                </tr>
                
                <tr>
                     <td>Nuevo Nombre</td>
                     <td>
                         <input type="text" name="txtnewFuncionalidad"/>
                     </td>
                </tr>
                
                <tr>
                    <td>Nuevo nombre corto</td>
                    <td>
                        <input type="text" name="txtnewNombrecorto"/>
                    </td>
                </tr>
                   
                    
                    
                    
                    <td>
                        <input type="submit" value="Modificar..."/>
                    </td>
                
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
