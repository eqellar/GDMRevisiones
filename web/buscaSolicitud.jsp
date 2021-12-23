<%-- 
    Document   : buscaSolicitud
    Created on : 6/10/2017, 06:06:06 AM
    Author     : Corei3
--%>
<%
    
    String alias = (String) request.getSession().getAttribute("alias");    
    String imei = (String) request.getSession().getAttribute("imei");
    String placas = (String) request.getSession().getAttribute("placas");
    String id_solicitud = (String) request.getSession().getAttribute("id_solicitud");
    String estatus = (String) request.getSession().getAttribute("estatus");    
    String fecha_solicitud = (String) request.getSession().getAttribute("fecha_solicitud");    
    String fecha_agenda = (String) request.getSession().getAttribute("fecha_agenda");
    String ubicacion = (String) request.getSession().getAttribute("ubicacion");
    String fechultserv = (String) request.getSession().getAttribute("fechultserv");
    String tiposerv = (String) request.getSession().getAttribute("tiposerv");
    String fechinstala = (String) request.getSession().getAttribute("fechinstala");
    
    

    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    if (nombreUsuario != null) {
        out.print("<h5>¡Hola! " + nombreUsuario + "</h5>");
        request.getSession().setAttribute("tipouser", tipouser);
    }

%>

<%    response.setHeader("Pragma", "no-cache");
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
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>


        <script type="text/javascript">

        </script>
    </head>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Dispositivo encontrado <%=imei%></h2></div>
        <hr>
        <%
            if (tipouser.equals("1")) {
        %>

        <a href="sistema.jsp">Regresa a Inicio</a>
        <hr>

        <%
            }
        %>

        <%
            if (tipouser.equals("3")) {
        %>

        .                  <a href="logistica.jsp">Regresa a Inicio</a>

        <%
            }
        %>

        <form method="post" action="consulta.do" name="" id="">
            <input type="text" name="usutipe" id="usutipe" value="<%=tipouser%>" hidden="">
            <input type="text" name="revPendientes" id="revPendientes" value="1" hidden="">
            <p>Buscar por IMEI <input type="text" name="busimei" id="busimei" readonly="">
                <input type="submit" value="Buscar..." name="searchdis" id="searchdis" disabled=""></p>
                

            <table border="1">                
                <td>Cliente</td>
                <td>IMEI</td>
                <td>Placas</td>
                <td>Fecha de solicitud</td>
                <td>Estatus</td>
                <td>Fecha agendad para revisión</td>
                <td>Fecha de instalación</td>
                <td>Ubicación de la unidad</td>
                <td>Fecha de ultimo Servicio</td>
                <td>Tipo de validación</td>
                <td>Ver detalles de revisión</td>                


                <tr id = '<%=id_solicitud%>'>

                    <td><%out.println(alias);%></td>
                    <td><%out.println(imei);%></td>
                    <td><%out.println(placas);%> </td>
                    <td><%out.println(fecha_solicitud);%></td>
                    <td><%out.println(estatus);%></td>
                    <td><%out.println(fecha_agenda);%></td>
                    <td><%out.println(fechinstala);%></td>
                    <td><%out.println(ubicacion);%></td>
                    <td><%out.println(fechultserv);%></td>
                    <td><%out.println(tiposerv);%></td>
                    <td> <input  type="image" name="<%=id_solicitud%>" value="<%=id_solicitud%>" src="images/ver.jpg"></td>



                </tr>




            </table>
        </form>
        <%
        } else {

        %>

        <h1>Su sesión ah expirado, favor iniciar sesión</h1>

        <a href="index.jsp">Inicio de Sesión</a>

        <%    }
        %>
    </body>
</html>
