<%-- 
    Document   : actualizarDispositivo2
    Created on : 24/05/2017, 02:20:45 PM
    Author     : Corei3
--%>

<java>
    <%
        

    %>
</java>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        
        
        <script type="text/javascript">
        
        </script>
    </head>

    <body>
    <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
    <h1>Activa el checkBox para realizar la edición de datos</h1>
    <hr>
    <form action="actualizarDispositivo.jsp" method="post" id="actDis2">
        <table>            
            <tr>
                <td align="right">Editar</td>
                <td><input type="checkbox" name="btnAct" id="btnidact" value="Actualizar..."/></td>
            </tr>
            
            <td align="right"> Cliente</td>
            <td><input type="text" name="" disabled=""></td>
            <tr> 
                <td align="right">Vehículo</td>
                <td>
                    <input type="text" name="" disabled="">
                   				
                </td>
            </tr>
            
            <tr>
                <td align="right">IMEI</td>
                <td><input type="text" name="" disabled=""></td>
                
                
            </tr>
            <tr>                
                <td align="right">Tipo</td>
                <td>
                    <input type="text" name="" disabled="">
                </td>                
            </tr>
            
            
            <tr>
                <td align="right" >Teléfono</td>
                <td><input type="text" name="" disabled=""</td>
            </tr>
            <tr>
                <td align="right" >Num SIM</td>
                <td><input type="text" name="actxtNumSim" disabled=""/></td>
                <td></td>
                <td><input type="submit" value="Actualizar" onclick=""/></td>
                
            </tr>
            
                
        </table>
    </form>



</body>
</html>
