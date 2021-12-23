<%-- 
    Document   : revPendiLogi
    Created on : 26/09/2017, 04:01:28 PM
    Author     : Corei3
--%>

<%@page import="dto.SolicitudDTO"%>
<%@page import="dao.SolicitudDAO"%>
<%@page import="dto.VehiculoDTO"%>
<%@page import="dto.DispositivoDTO"%>
<%@page import="dao.VehiculoDAO"%>
<%@page import="dao.DispositivoDAO"%>
<%@page import="dto.ClienteDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.ClienteDAO"%>
<%@page import="java.sql.ResultSet"%>

<%
    ClienteDAO clie = new ClienteDAO();
    DispositivoDAO dis = new DispositivoDAO();
    VehiculoDAO ve = new VehiculoDAO();
    SolicitudDAO sol = new SolicitudDAO();
    List<SolicitudDTO> solist = sol.readAll();  

    
    String usuario = (String) request.getSession().getAttribute("usuario");
    if (usuario != null) {
        out.print("<h5>¡Bienvenida: " + usuario + "!</h5>");
    }
    String tipouser = (String) request.getSession().getAttribute("tipouser");


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
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Revisiones Pendientes</h2></div>
    </head>
    <body>
        <a href="logistica.jsp">Regresa a Inicio</a>
        <form method="post" action="consulta.do" name="" id="">
            <input type="text" name="usutipe" id="usutipe" value="<%=tipouser%>">
            <input type="text" name="revPendiLogi" id="revPendiLogi" value="1">
            <br>

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
                
                <%
                    String dispositivos = "";
                    int idCliente = 0;
                    int idDisp = 0;
                    int idVehiculo =0;
                    int idSolicitud =0;
                    int estatus = 0;
                    String id_disp = "";
                    String fecsol = "";
                    String fecrev = "";
                    String estado = "";
                   

                    for (int i = 0; i < solist.size(); i++) {
                        idSolicitud = solist.get(i).getId_solicitud();
                        
                        
                        if(idSolicitud != 0){
                        SolicitudDTO bussoli = sol.read(idSolicitud);
                        idCliente = bussoli.getId_cliente();                        
                        idDisp = bussoli.getId_dsipositivo();                        
                        idVehiculo = bussoli.getId_vehiculo();                        
                        id_disp = Integer.toString(idDisp);
                        estatus = bussoli.getEstatus();
                        
                        
                        
                        
                        if(estatus == 1){
                            estado = "Pendiente";
                        
                        
                        
                        
                        ClienteDTO busclie = clie.read(idCliente);
                        VehiculoDTO busvehi = ve.read(idVehiculo);
                        DispositivoDTO busdis = dis.read(idDisp);
                        
                        
                        fecsol = bussoli.getFec_solicitud();                        
                        fecrev = bussoli.getFec_agenda();
                        dispositivos = busdis.getImei();
                        String fechinstala = busdis.getFech_instala();
                        String ubicacion = busdis.getUbicacion();
                        String fechultserv = busdis.getFech_ult_serv();
                        String tiposerv = busdis.getTipo_serv();
                        

                %>
                <tr id = '<%=idSolicitud%>'>
                    
                    <td><%out.println(busclie.getAlias());%></td>
                    <td><%out.println(busdis.getImei());%></td>
                    <td><%out.println(busvehi.getPlacas());%> </td>
                    <td><%out.println(fecsol);%></td>
                    <td><%out.println(estado);%></td>
                    <td><%out.println(fecrev);%></td>
                    <td><%out.println(fechinstala);%></td>
                    <td><%out.println(ubicacion);%></td>
                    <td><%out.println(fechultserv);%></td>
                    <td><%out.println(tiposerv);%></td>
                    <td> <input  type="image" name="<%=idSolicitud%>" value="<%=idSolicitud%>" src="images/ver.jpg"></td>
                    


                </tr>

                <%
                    }
                    }
                    }
                %>


            </table>
        </form>
    </body>
</html>
