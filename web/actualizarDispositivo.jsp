<%-- 
    Document   : actualizarDispositivo
    Created on : 24/05/2017, 11:19:35 AM
    Author     : Corei3
--%>

<%@page import="java.util.List"%>
<%@page import="dto.DispositivoDTO"%>
<%
    String cero = null;
    String imei = (String) request.getSession().getAttribute("imei");
    String tipo = (String) request.getSession().getAttribute("tipo");
    String telefono = (String) request.getSession().getAttribute("telefono");
    String numSim = (String) request.getSession().getAttribute("numSim");
    String fechinstala = (String) request.getSession().getAttribute("fechinstala");
    String ubicacion = (String) request.getSession().getAttribute("ubicacion");
    String fechultserv = (String) request.getSession().getAttribute("fechultserv");
    String tiposerv = (String) request.getSession().getAttribute("tiposerv");
    String noexiste = (String) request.getSession().getAttribute("noexiste");
    
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
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>        
        <script type="text/javascript">

            function active() {
                document.getElementById('btnactivar').disabled = false;
                alert("Limpiar");
            }
            function limpiar() {

                var limpia = "";

                document.getElementById("actidnumsim").value = limpia;

                document.getElementById("actidtipo").value = limpia;


            }

            function editar() {
                if (document.getElementById('btnactivar').checked)
                {
                    var porId = document.getElementById("id").value; //Se crea una variable con el valor del select con ID = idcliente
                    document.getElementById("txt").value = porId;
                    document.getElementById('actidnumsim').disabled = false;
                    document.getElementById('actidtel').disabled = false;
                    document.getElementById('actidtipo').disabled = false;
                    document.getElementById('busca').disabled = true;
                    document.getElementById('busImei').disabled = true;
                    document.getElementById('actualiza').disabled = false;
                    document.getElementById('actfechinstala').disabled = false;
                    document.getElementById('actubicacion').disabled = false;
                    document.getElementById('actfechultserv').disabled = false;
                    document.getElementById('acttiposerv').disabled = false;

                } else
                {
                    var porId = document.getElementById('id').value; //Se crea una variable con el valor del select con ID = idcliente
                    document.getElementById('txt').value = porId;

                    document.getElementById('actidnumsim').disabled = true;
                    document.getElementById('actidtel').disabled = true;
                    document.getElementById('actidtipo').disabled = true;
                    document.getElementById('busca').disabled = false;
                    document.getElementById('busImei').disabled = false;
                    document.getElementById('actualiza').disabled = true;
                    document.getElementById('actfechinstala').disabled = true;
                    document.getElementById('actubicacion').disabled = true;
                    document.getElementById('actfechultserv').disabled = true;
                    document.getElementById('acttiposerv').disabled = true;
                }
            }
        </script>
    </head>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Actualizar dispositivos</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
    
    <h2>Ingresa el IMEI completo en el campo de busqueda del dispositivo a editar</h2>
    
    <form action="actualizardispositivo.do" method="post" id="actDis">

        <p>IMEI <input type="text" name="buscaIMEI" id="busImei">
            <input type="submit" value="Bsucar" name="buscar" id="busca"></p>

        <p><input type="text" name="texto" id="txt" hidden=""></p>
        <table border="1">            
            <tr>

            </tr>            

            <tr>
                <th>IMEI</th>
                <th>Tipo</th>
                <th>Teléfono</th>
                <th>Número de SIM</th>
                <th>Fecha de Insatalación</th>
                <th>Ubicación del vehículo</th>
                <th>Fecha de último servicio</th>
                <th>Tipo de servicio</th>

            </tr>


            <%
                String dispositivoID = (String) request.getSession().getAttribute("dispositivoID");
                int id_dispositivo = 0;
                //
                if (dispositivoID != null) {
                    id_dispositivo = Integer.parseInt(dispositivoID);
                    //out.println("Este es el ID de Dispositivo: "+id_dispositivo);
            %>
            <tr>
            <input  type="text" name="id" id="id" value="<%=id_dispositivo%>" hidden="">
            <td><input type="text" name="txtimei" value="<%=imei%>" id="actidimei" readonly=""</td>           
            <td><input type="text" name="txttipo" value="<%=tipo%>" id="actidtipo" disabled=""</td>
            <td><input type="text" name="txttelefono" value="<%=telefono%>" id="actidtel" disabled=""</td>
            <td><input type="text" name="txtnumsim" value="<%=numSim%>" id="actidnumsim" disabled=""</td>
            <td><input type="text" name="txtfecinstala" value="<%=fechinstala%>" id="actfechinstala" disabled=""</td>                    
            <td><input type="text" name="txtubicacion" value="<%=ubicacion%>" id="actubicacion" disabled=""</td>                    
            <td><input type="text" name="txtfechultserv" value="<%=fechultserv%>" id="actfechultserv" disabled=""</td>                    
            <td><input type="text" name="txttiposerv" value="<%=tiposerv%>" id="acttiposerv" disabled=""</td>                    
            </tr>
            <%
                }
            %>

            <tr>
                <td>Editar Información ==><input type="checkbox" name="checkedit" id="btnactivar" onclick="editar()"</td>
                
                <td><input type="submit" value="Actualizar..." name="actualiza" id="actualiza" disabled=""></td>
            </tr>




        </table>


        <p><input type="button" name="" value="Limpiar..." onclick="limpiar()"></p>




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
