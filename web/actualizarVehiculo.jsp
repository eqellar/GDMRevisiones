<%-- 
    Document   : actualizarVehiculo
    Created on : 7/08/2017, 04:41:07 PM
    Author     : Corei3
--%>

<%@page import="dto.ClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClienteDAO"%>
<%
    ClienteDAO clie = new ClienteDAO ();
    ArrayList<ClienteDTO> listclie = clie.readAll();
    
String marca = (String) request.getSession().getAttribute("marca");
    String sub_marca = (String) request.getSession().getAttribute("sub_marca");
    String modelo = (String) request.getSession().getAttribute("modelo");
    String color = (String) request.getSession().getAttribute("color");
    String economico = (String) request.getSession().getAttribute("economico");
    String placas = (String) request.getSession().getAttribute("placas");
    
    String d = (String) request.getSession().getAttribute("logout");
    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
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
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript">
            function editar() {
                if (document.getElementById('editvehi').checked)
                {                   
                    document.getElementById('placa').disabled = false;
                    document.getElementById('marca').disabled = false;
                    document.getElementById('submarca').disabled = false;
                    document.getElementById('modelo').disabled = false;
                    document.getElementById('color').disabled = false;
                    document.getElementById('eco').disabled = false;
                    document.getElementById('btnactuvehi').disabled = false;
                    document.getElementById('btnbusplac').disabled = true;
                    

                } else
                {
                    

                    document.getElementById('placa').disabled = true;
                    document.getElementById('marca').disabled = true;
                    document.getElementById('submarca').disabled = true;
                    document.getElementById('modelo').disabled = true;
                    document.getElementById('color').disabled = true;
                    document.getElementById('eco').disabled = true;
                    document.getElementById('btnactuvehi').disabled = true;
                    document.getElementById('btnbusplac').disabled = false;
                    
                }
            }
 
        </script>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Actualizar Vehículos</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
    <h1>Ingresa la placa del vehículo a actualizar</h1>
    <form action="actualizavehiculo.do" method="post" id="actvehiculo">
        
        <table>
            <tr>
                <td>Busqueda por Placas</td>
                <td> <input type="text" name="busplaca" id="busplaca"</td>
            </tr>
            
            <tr>
                <td> <input type="submit" name="btnbusplac" id="btnbusplac"  value="Buscar..."</td>
            </tr>
            
        </table>
        <hr>
        <table>
                <head>                
                <tr>                    
                    <th><label>Datos del Vehículo</label></th> <th>Editar <input type="checkbox" name="editvehi" id="editvehi" onclick="editar()"</th>                    
                </tr>
                </head>
                <tr>
                    <td align="right"><label>Placas: <input type="text" name="matricula" id="matricula" value="<%=placas%>" readonly=""/></label></td>
                    <td align="right"><label>Nuevas Placas: <input type="text" name="placa" id="placa" value="<%=placas%>" disabled=""/></label></td>
                </tr>

                <tr>
                    <td align="right"><label>Marca: <input type="text" name="" id="" value="<%=marca%>" readonly=""/></label></td>
                    <td align="right"><label>Nueva Marca: <input type="text" name="marca" id="marca" value="<%=marca%>" disabled=""/></label></td>
                </tr>
                <tr>
                    <td align="right"><label>Sub-Marca: <input type="text" name="" id="" value="<%=sub_marca%>" readonly=""/></label></td>
                    <td align="right"><label>Nueva Sub-Marca: <input type="text" name="submarca" id="submarca" value="<%=sub_marca%>" disabled=""/></label></td>
                </tr>
                <tr>
                    <td align="right"><label>Modelo: <input type="text" name="" id="" value="<%=modelo%>" readonly=""/></label></td>
                    <td align="right"><label>Nuevo Modelo: <input type="text" name="modelo" id="modelo" value="<%=modelo%>" disabled=""/></label></td>
                </tr>
                <tr>
                    <td align="right"><label>Color: <input type="text" name="" id="" value="<%=color%>" readonly=""/></label></td>
                    <td align="right"><label>Nuevo Color: <input type="text" name="color" id="color" value="<%=color%>" disabled=""/></label></td>
                </tr>
                <tr>
                    <td align="right"><label>Económico: <input type="text" name="" id="" value="<%=economico%>" readonly=""/></label></td>
                    <td align="right"><label>Nuevo Económico: <input type="text" name="eco" id="eco" value="<%=economico%>" disabled=""/></label></td>
                </tr>
                <tr> <td> <input type="submit" name="btnactuvehi" id="btnactuvehi" value="Actualizar..." disabled=""/></td></tr>
            </table>
            <hr>
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
