<%-- 
    Document   : principal
    Created on : 12/06/2017, 07:44:49 PM
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
    
    List<DispositivoDTO> listdis = dis.readAll();
    List<ClienteDTO> listclie = clie.readAll();
    

    String selectcliente = request.getParameter("test");
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
    </head>
    <body>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Todas la revisiones</h2></div>
        <hr>
        
        
        
        <%
                        if(tipouser.equals("1")){       
                %>
                              
.                  <a href="sistema.jsp">Regresa a Inicio</a>
              
                <%
                    }
                %>
                
                <%
                        if(tipouser.equals("3")){       
                %>
                              
.                  <a href="logistica.jsp">Regresa a Inicio</a>
              
                <%
                    }
                %>
        
        <hr>
        <form method="post" action="consulta.do" name="" id="">
           

            <table border="1">
                
                <td>Cliente</td>
                <td>IMEI</td>
                <td>Placas</td>
                <td>Fecha de solicitud</td>
                <td>Estatus</td>
                <td>Fecha agendad para revisi??n</td>
                <td>Fecha de instalaci??n</td>
                <td>Ubicaci??n de la unidad</td>
                <td>Fecha de ultimo Servicio</td>
                <td>Tipo de validaci??n</td>
                <td>Ver detalles de revisi??n</td>                
                
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
                        }
                        
                        if(estatus == 2){
                            estado = "Agendada";
                        }
                        
                        if(estatus == 3){
                            estado = "Atendida";
                        }
                        
                         if(estatus == 4){
                            estado = "Cancelada";
                        }
                        
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
                %>


            </table>
        </form>
    </body>
</html>
