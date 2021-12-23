<%-- 
    Document   : detalles
    Created on : 29/06/2017, 08:53:19 PM
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
    String usuario = (String) request.getSession().getAttribute("usuario");
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>        
        <script type="text/javascript">
            function editar() {
                if (document.getElementById('checkEdit').checked){
                    alert("!!RECUERDA COLOCAR EL COMENTARIO DE PORQUE SE CANCELA!!");
                    document.getElementById('status').disabled =false;
                    document.getElementById('folio').disabled = false;
                    document.getElementById('fechasol').disabled = false;
                    document.getElementById('estatusactual').disabled = true;
                    
                    document.getElementById('textarea').disabled = false;
                    
                }else{
                    document.getElementById('status').disabled =true;
                    document.getElementById('folio').disabled = true;
                    document.getElementById('fechasol').disabled = true;
                    document.getElementById('estatusactual').disabled = false;
                    
                    document.getElementById('textarea').disabled = true;
                    document.getElementById('btnActualizar').disabled =true;
                }
             
            }
            function activarbtn(){
                document.getElementById('btnActualizar').disabled =false;
            }
        </script>
        
    </head>
    <body>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Solicitud de revisión ¡<%=estatus%>!</h2></div>        
        <hr>
        <a href="sistema.jsp">Regresa a Inicio</a>
        <hr>
        <form action="actualizasolicitud.do" method="POST">
            
            <table border="0">  
                <head>                
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
                        <td>
                            <label>Estatus Actual:</label><input type="text" name="estatusactual" id="estatusactual" value="<%=estatus%>" readonly="">
                        </td>
                    </tr>
                    <tr>
                        <td><label>Nuevo Estatus:</label>
                            <select name="status" id="status"  disabled="" onchange="activarbtn()">
                                <option value="0">---Nuevo estutus---</option>
                                <option value="1">Pendiente</option>
                                <option value="2">Agendada</option>
                                <option value="3">Atendida</option>
                                <option value="4">Cancelada</option>
                                 </select>
                            
                            </td>
                    </tr>
                    <tr>
                        <td><label>Folio: <input type="text" name="folio" id="folio" value="<%=folio%>" disabled=""/></label></td>
                    </tr>
                    <tr>
                        <td><label>Fechade solicitud: <input type="text" name="fechasol" id="fechasol" value="<%=fecha_solicitud%>" disabled=""/></label></td>
                    </tr>
                                                        
                </tbody>
            </table>

            <label>Motivo por el cual se solicito la revisión:</label>
            
            <div><textarea name="textarea" id="textarea" rows="10" cols="50" disabled=""><%=motivo%></textarea></div>
            
            <%
                        if(tipouser.equals("1")){       
                %>
                              
.                  <label>Editar</label><input type="checkbox" name="checkEdit" id="checkEdit" onclick="editar()">
                        <label>========================></label><input type="submit" name="btnActualizar" id="btnActualizar" value="Actualizar" disabled="">
                               <hr>
              
                <%
                    }
                %>
            
                        
            
            <table border="0">
                <thead>
                    <tr>                        
                        <th>Datos dela Revisión Agendada</th>                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td align="right"><label>Contacto: <input type="text" name="" id="" value="<%=contacto%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td align="right"><label>Fecha: <input type="text" name="" id="" value="<%=fecha_agenda%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td align="right"><label>Lugar: <input type="text" name="" id="" value="<%=lugar%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td align="right"><label>Hora: <input type="text" name="" id=""value="<%=hora%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td align="right"><label>Técnico Asignado: <input type="text" name="" id="" value="<%=tecnico%>" readonly=""/></label></td>
                        
                        <td>
                            <%
                        if(tipouser.equals("3")){       
                %>
                              
.                   <label>Editar</label><input type="checkbox" name="checkEdit" id="checkEdit" onclick="editar()">
                            <label>========================></label><input type="submit" name="btnActualizar2" id="btnActualizar2" value="Actualizar..." disabled="">
              
                <%
                    }
                %>
                        </td>
                    </tr>
                    
                </tbody>
            </table>



        </form>
    </body>
</html>
