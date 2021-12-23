<%-- 
    Document   : regDisp
    Created on : 17/05/2017, 11:05:39 PM
    Author     : Corei3
--%>


<%@page import="dto.FuncionalidadDTO"%>
<%@page import="dao.FuncionalidadDAO"%>
<%@page import="dao.AplicaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ClienteDTO"%>
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
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript">
            function comboPlacas() {

                $("#i_porid").val("2");

                $.post("comboPlacas.jsp", $("#regDip").serialize(), function (data) {
                    $("#i_placas").html(data);
                });
            }

            function placa() {
                //alert("cambiar a select dependiente");
                var idp = document.getElementById("i_placas").value;
                document.getElementById('resultado').value = idp;
            }
        </script>
    </head>

    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Registro de Dispositivos</h2></div>
        <hr>
        <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
        <hr>
        <h1>Ingresa los datos que a continuación se solicitan para registrar un dispositivo</h1>
        <form action="regdisp.do" method="post" id="regDip">


            <table>
                <tr>
                    <td>		                             
                        <input hidden="" name="resultado" id="resultado">
                        <input hidden="" name="f_porid" id="i_porid">
                    </td>
                </tr>
                <tr>
                    <td align="right">Cliente</td>
                    <td> 

                        <select name="txtClientes" data-native-menu='false' id="idcliente" onchange="comboPlacas()">
                            <option value="" >--seleccione cliente--</option>
                            <%                            for (int i = 0; i < listclie.size(); i++) {
                                    out.println("<option value=\"" + listclie.get(i).getId_cliente() + "\">" + listclie.get(i).getAlias() + "</option>");
                                }
                            %>		
                        </select>
                    </td>
                </tr>
                <tr>
                    <td align="right">Vehículo</td>
                    <td>
                        <select name="txtVehiculos" id="i_placas" onchange="placa()">
                            <option value="">--seleccione placas del vehículo--</option>
                        </select>					
                    </td>
                </tr>
                <tr>                
                    <td align="right">Tipo</td>
                    <td>
                        <select name="txtTipoDispositivo">
                            <option selected="" value="">---Selecione tipo---</option>
                            <option value="axonn_smartone">Axonn SmartOne</option>
                            <option value="calamp_lmu4200">CalAmp LMU 4200</option>
                            <option value="enfora_minimt">Enfora MiniMT</option>
                            <option value="enfora_mt3000">Enfora MT 3000</option>
                            <option value="enfora_spidermt">Enfora Spider MT</option>
                            <option value="falcom_bolero">Falcom Bolero</option>
                            <option value="falcom_fox3">Falcom FOX3</option>
                            <option value="falcom_stepiiib1">Falcom StepIIIB1</option>
                            <option value="generic_device">Generic Device</option>
                            <option value="gstraq_tr203">GS-TRAQ TR-203</option>
                            <option value="HTT">HTT</option>
                            <option value="pointer_cellotrack">Pointer CelloTrack</option>
                            <option value="redtail_vam_18">RedTail VAM-18</option>
                            <option value="suntech_st215">Suntech ST215</option>
                            <option value="suntech_st215e">Suntech ST215E</option>
                            <option value="suntech_st215i">Suntech ST215I</option>
                            <option value="suntech_st230">Suntech ST230</option>
                            <option value="suntech_st240">Suntech ST240</option>
                            <option value="suntech_st300">Suntech ST300</option>
                            <option value="suntech_st300a">Suntech ST300A</option>
                            <option value="suntech_st300h">Suntech ST300H</option>
                            <option value="suntech_st300k">Suntech ST300K</option>
                            <option value="suntech_st300r">Suntech ST300R</option>
                            <option value="suntech_st330">Suntech ST330</option>
                            <option value="suntech_st340">Suntech ST340</option>
                            <option value="suntech_st340lc">Suntech ST340LC</option>
                            <option value="suntech_st600r">Suntech ST600R</option>
                            <option value="suntech_st910">Suntech ST910</option>
                            <option value="suntech_st930">Suntech ST930</option>
                            <option value="suntech_st940">Suntech ST940</option>
                            <option value="xirgo_1900">Xirgo 1900</option>
                        </select>
                    </td>                
                </tr>
                <tr>
                    <td align="right">IMEI</td>
                    <td><input type="text" name="txtIMEI"/></td>
                </tr>

                <tr>
                    <td align="right" >Teléfono</td>
                    <td><input type="text" name="txtTelefono"/></td>
                </tr>
                <tr>
                    <td align="right" >Num SIM</td>
                    <td><input type="text" name="txtNumSim"/></td>

                </tr>
                <tr>
                    <td align="right" >Ubicación del vehículo</td>
                    <td><input type="text" name="txtUbicacion"/></td>

                </tr>
               
                <tr>
                    <td align="right" >Tipo de última validacion</td>
                    <td><input type="text" name="txtTipoServ"/></td>

                </tr>
            </table>
            <table>
            <tr>
                <td><label>Fecha de último servicio</label></td>
                <td>
                    <select name="annioserv" id="annioserv">
                        <option value="0">---Año---</option>
                        <%
                            for (int i = 2010; i < 2100; i++) {
                        %>
                        <option value="<%=i%>"><%=i%></option>                            
                        <%
                            }
                        %>
                    </select>
                </td>
                                  
                <td>
                    <select name="messerv" id="messerv">
                        <option value="0">---Mes---</option>
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
                    <select name="diaserv" id="diaserv">
                        <option>---Día---</option>
                        <%
                            for (int i = 1; i < 32; i++) {
                        %>
                        <option value="<%=i%>"><%=i%></option>

                        <%
                            }
                        %>
                    </select>
                </td>
            </tr>
        </table>
            <table >
                <tr>
                    <td><label>Fecha de Instalación</label></td>

                    <td>
                        <select name="annioinst" id="annioinst">
                            <option value="0">---Año---</option>
                            <%
                                for (int i = 2010; i < 2100; i++) {
                            %>
                            <option value="<%=i%>"><%=i%></option>                            
                            <%
                                }
                            %>
                        </select>
                    </td>

                    <td>
                        <select name="mesinst" id="mesinst">
                            <option value="0">---Mes---</option>
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
                        <select name="diainst" id="diainst">
                            <option>---Día---</option>
                            <%
                                for (int i = 1; i < 32; i++) {
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
                <td><br /><br /></td>
                <td><input type="submit" value="Registrar Dispositivo..."/></td>
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
