<%-- 
    Document   : comboImei
    Created on : 11/07/2017, 05:13:09 PM
    Author     : Corei3
--%>

<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.ClienteDAO" scope="page"></jsp:useBean>
<%   
    String idvehiculo = request.getParameter("revplacas");
    
    int id_vehiculo= 0;        
    
    //String s_opc = request.getParameter("f_opc");
    String s_porid = request.getParameter("f_porid");    
    
    
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        
<select name="comboimei">
    
    <%
        if (s_porid.equals("2")) {
            
      id_vehiculo = Integer.parseInt(idvehiculo);
      String imei = "Select* from dispositivos where id_vehiculo='"+id_vehiculo+"'";
      
      ResultSet rs = 	cx.getDatos(imei);
        while (rs.next()){%>
	<option value="<%=rs.getString("id_dsipositivo")%>"><%=rs.getString("imei")%></option>
        
	<%}
        
    %>
</select>
    
<%}%>
    </body>
</html>
