<%-- 
    Document   : solicitud
    Created on : 11/07/2017, 02:23:47 PM
    Author     : Corei3
--%>

<%@page import="dto.ClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ClienteDAO"%>
<%
    ClienteDAO clie = new ClienteDAO();
    ArrayList<ClienteDTO> listclie = clie.readAll();

    String id_usuario = (String) request.getSession().getAttribute("id_usuario");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    String d = (String) request.getSession().getAttribute("logout");
    if (nombreUsuario != null) {
        out.print("<h5>¡Hola! " + nombreUsuario + " ===> <a href='"+d+"'>Cerrar sesion</a></h5>");

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

            function comboPlacas() {
                $("#i_porid").val("2");

                $.post("comboPlacas.jsp", $("#rev").serialize(), function (llama) {
                    $("#revplacas").html(llama);
                });
            }

            function comboImei() {
                //alert("ejecuntando");
                $("#i_porid").val("2");

                $.post("comboImei.jsp", $("#rev").serialize(), function (busimei) {
                    $("#revimei").html(busimei);
                });

                document.getElementById('revcomen').disabled = false;

            }

        </script>
    </head>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Registro de Solicitudes</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
        <h4>Igrese los datos requeridos para el registro de la solicitud de revisión</h4>

        <form method="post" action="revision.do" id="rev">
            <input type="text" name="idusuario" id="idusuario" value="<%=id_usuario%>" hidden="">
            <p>Fecha de solicitud</p>
            <table>
               
                <tr>
                    <td>
                        <label>Año</label>
                    </td>
                    <td>
                        <select name="annio" id="annio">
                    <option value="0">---Seleccione año---</option>
                    <%
                        for(int i =2010;i<2100;i++){
                            %>
                            <option value="<%=i%>"><%=i%></option>                            
                            <%
                        }
                    %>
                </select>
                    </td>
                    <td>
                        <label>Mes</label>
                    </td>                    
                    <td>
                        <select name="mes" id="mes">
                    <option value="0">---Seleccione mes---</option>
                    <option value="1">Enero</option>
                    <option value="2">Febrero</option>
                    <option value="3">Marzo</option>
                    <option value="4">Abril</option>
                    <option value="5">Mayo</option>
                    <option value="6">Junio</option>
                    <option value="7">Julio</option>
                    <option value="8">Agosto</option>
                    <option value="9">Septiembre</option>
                    <option value="10">Octubre</option>
                    <option value="11">Noviembre</option>
                    <option value="12">Diciembre</option>
                </select>
                    </td>
                    
                    <td>
                        <label>Día</label>
                    </td>                    
                    <td>
                        <select name="dia" id="dia">
                    <option>---Seleccione día---</option>
                    <%
                        for(int i =1;i<32;i++){
                            %>
                            <option value="<%=i%>"><%=i%></option>
                            
                            <%
                        }
                    %>
                </select>
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <label>Hora</label>
                    </td>
                 <td>
                     <select name="hora" id="hora">
                    <option>---Selecciona hora---</option>
                    <%
                        for(int i =0;i<24;i++){
                            %>
                            <option value="<%=i%>"><%=i%></option>
                            
                            <%
                        }
                    %>
                </select>
                    </td>
                    
                    <td>
                        <label>Minutos</label>
                    </td>                    
                    <td>
                        <select name="min" id="min">
                    <option>---Selecciona minutos---</option>
                    <%
                        for(int i =0;i<60;i++){
                            %>
                            <option value="<%=i%>"><%=i%></option>
                            
                            <%
                        }
                    %>
                </select>
                    </td>
                </tr>               
            </table>


            <table>
                <tr>
                    <td>
                        <input name="resultado" id="resultado" hidden=""/>
                        <input name="f_porid" id="i_porid" hidden=""/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Folio:</label>
                        <input type="text" name="folio" id="folio" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Seleccione Cliente:</label>
                        <select name="txtClientes" id="revclie" onchange="comboPlacas()">
                            <option value="" >--Seleccione Cliente--</option>
                            <%                            for (int i = 0; i < listclie.size(); i++) {
                                    out.println("<option value=\"" + listclie.get(i).getId_cliente() + "\">" + listclie.get(i).getAlias() + "</option>");
                                }
                            %>	
                        </select>
                    </td>                    
                </tr>                
                <tr>
                    <td>
                        <label>Seleccione el vehículo: </label>
                        <select name="revplacas" id="revplacas" onchange="comboImei()">
                            <option>---Seleccione placas--</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>IMEI:</label>
                        <select type="text" name="revimei" id="revimei">

                        </select>
                    </td>
                </tr>               

                <tr>
                    <td>
                        <label>Motivo de la solicitud:</label>
                    </td>
                </tr>

                <tr>
                    <td><textarea name="revcomen" id="revcomen" rows="20" cols="50" disabled="">
                        </textarea></td>
                </tr>

                <tr>
                    <td>
                        <input type="submit" value="Registrar..." name="registrarev">
                    </td>
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
