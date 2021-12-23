<%-- 
    Document   : detallesLogistica
    Created on : 26/09/2017, 02:10:58 PM
    Author     : Corei3
--%>

<%@page import="java.util.ArrayList"%>
<%
    String nombreclie = (String) request.getSession().getAttribute("nombreclie");
    String alias = (String) request.getSession().getAttribute("alias");
    String vendedor = (String) request.getSession().getAttribute("vendedor");
    String imei = (String) request.getSession().getAttribute("imei");
    String tipo = (String) request.getSession().getAttribute("tipo");
    String telefono = (String) request.getSession().getAttribute("telefono");
    String marca = (String) request.getSession().getAttribute("marca");
    String sub_marca = (String) request.getSession().getAttribute("sub_marca");
    String modelo = (String) request.getSession().getAttribute("modelo");
    String color = (String) request.getSession().getAttribute("color");
    String economico = (String) request.getSession().getAttribute("economico");
    String placas = (String) request.getSession().getAttribute("placas");
    String idsolicitud = (String) request.getSession().getAttribute("idsolicitud");
    String estatus = (String) request.getSession().getAttribute("estatus");
    String folio = (String) request.getSession().getAttribute("folio");
    String fecha_solicitud = (String) request.getSession().getAttribute("fecha_solicitud");

    String motivo = (String) request.getSession().getAttribute("motivo");
    String contacto = (String) request.getSession().getAttribute("contacto");
    String fecha_agenda = (String) request.getSession().getAttribute("fecha_agenda");
    String lugar = (String) request.getSession().getAttribute("lugar");
    String hora = (String) request.getSession().getAttribute("hora");
    String tecnico = (String) request.getSession().getAttribute("tecnico");
    ArrayList<String> funcionalidades = (ArrayList<String>) request.getSession().getAttribute("funcionalidades");

    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    request.getSession().setAttribute("nombreUsuario", nombreUsuario);
    if (nombreUsuario != null) {
        out.print("<h5>¡Hola! " + nombreUsuario + "</h5>");
        request.getSession().setAttribute("tipouser", tipouser);
    }

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Solicitud <%out.println(estatus);%></h2></div>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>        
    <script type="text/javascript">
        function editar() {
            if (document.getElementById('checkEdit').checked) {
                //alert("!!RECUERDA COLOCAR EL COMENTARIO DE PORQUE SE CANCELA!!");
                
                document.getElementById('annioagenda').disabled = false;                
                document.getElementById('mesagenda').disabled = false;
                document.getElementById('diaagenda').disabled = false;
                document.getElementById('horaagenda').disabled = false;
                document.getElementById('minagenda').disabled = false;
                document.getElementById('lugar').disabled = false;
                document.getElementById('contact').disabled = false;
                document.getElementById('tecname').disabled = false;


                
            } else {
                document.getElementById('annioagenda').disabled = true;                
                document.getElementById('mesagenda').disabled = true;
                document.getElementById('diaagenda').disabled = true;
                document.getElementById('horaagenda').disabled = true;
                document.getElementById('minagenda').disabled = true;
                document.getElementById('contact').disabled = true;
                //document.getElementById('fechagen').disabled = true;
                document.getElementById('lugar').disabled = true;
                //document.getElementById('horarev').disabled = true;
                document.getElementById('tecname').disabled = true;


                document.getElementById('btnActualizar2').disabled = true;
            }

        }
        function button(){
            document.getElementById('btnActualizar2').disabled = false;
        }
    </script>
</head>
<body>



    <form action="actulizaagenda.do" method="POST">

        <a href="logistica.jsp">Regresa a Inicio</a>
        <hr>

        <table border="0">  
            <head>
            <tr>
                <td>
                    <br>

                </td>
            </tr>
            <tr>                    
                <th><label>Datos del cliente</label></th>                    
            </tr>
            </head>
            <tr>
                <td align="right"><label>Cliente: <input type="text" name="" id="" value="<%=nombreclie%>" readonly=""/></label></td>
                <td align="right"><label>Alias: <input type="text" name="" id="" value="<%=alias%>" readonly=""/></label></td>
                <td  align="right"><label>Vendedor: <input type="text" name="" id="" value="<%=vendedor%>" readonly=""/></label></td>
            </tr>                
        </table>
        <hr>
        <table border="0">
            <head>                
            <tr>                    
                <th><label>Datos del Dispositivo</label></th>                    
            </tr>
            </head>

            <tr>
                <td align="right"><label>IMEI: <input type="text" name="" id="" value="<%=imei%>" readonly=""/></label></td>
                <td align="right"><label>Tipo: <input type="text" name="" id="" value="<%=tipo%>" readonly=""/></label></td>
                <td align="right"><label>Teléfono: <input type="text" name="" id="" value="<%=telefono%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td>
                    <ul>

                        <%
                            for (int i = 0; i < funcionalidades.size(); i++) {
                                out.println("<li>" + funcionalidades.get(i) + "</li>");
                            }
                        %>                            
                    </ul>
                <td/>
            </tr>
        </table>
        <hr>

        <table>
            <head>                
            <tr>                    
                <th><label>Datos del Vehículo</label></th>                    
            </tr>
            </head>

            <tr>
                <td align="right"><label>Marca: <input type="text" name="" id="" value="<%=marca%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Sub-Marca: <input type="text" name="" id="" value="<%=sub_marca%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Modelo: <input type="text" name="" id="" value="<%=modelo%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Color: <input type="text" name="" id="" value="<%=color%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Económico: <input type="text" name="" id="" value="<%=economico%>" readonly=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Placas: <input type="text" name="" id="" value="<%=placas%>" readonly=""/></label></td>
            </tr>


        </table>
        <hr>

        <table border="0">
            <thead>
                <tr>                        
                    <th>Datos de la Solicitud de Revisión</th>                        
                </tr>
            </thead>
            <tbody>
                <tr><td><input type="text" name="id_solicitud" id="id_solicitud" value="<%=idsolicitud%>" hidden=""></td></tr>
                <tr>
                    <td><label>Estatus:</label>
                        <input type="text" name="status" id="status" value="<%=estatus%>" readonly="">
                    </td>
                </tr>
                <tr>
                    <td><label>Folio: <input type="text" name="folio" id="folio" value="<%=folio%>" readonly=""/></label></td>
                </tr>
                <tr>
                    <td><label>Fechade solicitud: <input type="text" name="fechasol" id="fechasol" value="<%=fecha_solicitud%>" readonly=""/></label></td>
                </tr>

            </tbody>
        </table>


        <label>Motivo por el cual se solicito la revisión:</label>
        <div><textarea name="textarea" id="textarea" rows="10" cols="50" readonly=""><%=motivo%></textarea></div>
        <hr>



        <h4>Agendar Revisión</h4>
        <label>¡Editar! ===></label><input type="checkbox" name="checkEdit" id="checkEdit" onclick="editar()">

        <table>
            <tr>
                <td><label>Fecha</label></td>
                <td>
                    <select name="annioagenda" id="annioagenda" disabled="" >
                        <option value="0">---Selecione Año---</option>
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
                    <select name="mesagenda" id="mesagenda" disabled="">
                        <option value="0">---Seleccione Mes---</option>
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
                    <select name="diaagenda" id="diaagenda" disabled="">
                        <option>---Seleccione Día---</option>
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
                <td><label>Hora</label></td>
                
                <td>
                    <select name="horaagenda" id="horaagenda" disabled="">
                        <option>---Seleccione Hora---</option>
                        <%
                            for (int i = 0; i < 24; i++) {
                        %>
                        <option value="<%=i%>"><%=i%></option>

                        <%
                            }
                        %>
                    </select>
                </td>

                                   
                <td>
                    <select name="minagenda" id="minagenda" disabled="" onchange="button()">
                        <option>---Seleccione Minutos---</option>
                        <%
                            for (int i = 00; i < 60; i++) {
                        %>
                        <option value="<%=i%>"><%=i%></option>

                        <%
                            }
                        %>
                    </select>
                </td>
        </table>
        <table>
            <tr>
                <td align="right"><label>Contacto: <input type="text" name="contact" id="contact" value="<%=contacto%>" disabled=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Fecha Agendada: <input type="text" name="fechagen" id="fechagen" value="<%=fecha_agenda%>" disabled=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Hora Agendada: <input type="text" name="horarev" id="horarev" value="<%=hora%>" disabled=""/></label></td>
            </tr>
            <tr>
                <td align="right"><label>Lugar: <input type="text" name="lugar" id="lugar" value="<%=lugar%>" disabled=""/></label></td>
            </tr>
            
            <tr>
                <td align="right"><label>Técnico Asignado: <input type="text" name="tecname" id="tecname" value="<%=tecnico%>" disabled=""/></label></td>

                <td>
                    
                    <label>==></label><input type="submit" name="btnActualizar2" id="btnActualizar2" value="Actualizar..." disabled="">

                </td>                        
            </tr>

        </table>
    </form>
</body>
</html>
