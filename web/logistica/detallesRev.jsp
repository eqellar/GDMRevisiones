<%-- 
    Document   : detallesRev
    Created on : 21/09/2017, 06:49:35 PM
    Author     : Corei3
--%>

<%@page import="java.util.ArrayList"%>
<%
    String nombre = (String) request.getSession().getAttribute("nombre");
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

%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Esta solicitud se encuentra con el estatus de: </h1>
        <form method="POST">
            
            <table border="0">  
                <head>                
                <tr>                    
                    <th><label>Datos del cliente</label></th>                    
                </tr>
                </head>
                <tr>
                    <td align="right"><label>Cliente: <input type="text" name="" id="" value="<%=nombre%>" readonly=""/></label></td>
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
                    <tr>
                        <td><label>Estatus: <input type="text" name="" id="" value="<%=estatus%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td><label>Folio: <input type="text" name="" id="" value="<%=folio%>" readonly=""/></label></td>
                    </tr>
                    <tr>
                        <td><label>Fechade solicitud: <input type="text" name="" id="" value="<%=fecha_solicitud%>" readonly=""/></label></td>
                    </tr>                                    
                </tbody>
            </table>

            <label>Motivo por el cual se solicito la revisión:</label>
            <div><textarea name="textarea" rows="10" cols="50" readonly=""><%=motivo%></textarea></div>
            <hr>
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
                    </tr>
                </tbody>
            </table>



        </form>
    </body>
</html>
