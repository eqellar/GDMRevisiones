<%-- 
    Document   : revCanceladas
    Created on : 19/09/2017, 08:46:33 AM
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
            
        </script>
    </head>
    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Revisiones Canceladas</h2></div>
        <hr>
        <%
                        if(tipouser.equals("1")){       
                %>
                              
                  <a href="sistema.jsp">Regresa a Inicio</a>
                  <hr<
              
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
            <input type="text" name="usutipe" id="usutipe" value="<%=tipouser%>" hidden="">
            <input type="text" name="revCanceladas" id="revCanceladas" value="4" hidden="">
            <p>Buscar por IMEI <input type="text" name="busimei" id="busimei">
                <input type="submit" value="Buscar..." name="searchdis" id="searchdis"></p>
           
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
                        
                        
                        
                        
                        if(estatus == 4){
                            estado = "Cancelada";
                        
                        
                        
                        
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
                                <%
    }else{

%>

<h1>Su sesión ah expirado, favor iniciar sesión</h1>
        
        <a href="index.jsp">Inicio de Sesión</a>

<%
}
%>
    </body>
</html>
