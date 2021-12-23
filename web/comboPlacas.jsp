<%-- 
    Document   : comboPlacas
    Created on : 23/05/2017, 09:42:23 AM
    Author     : Corei3
--%>

<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.ClienteDAO" scope="page"></jsp:useBean>
<%   
    String idcliente = request.getParameter("txtClientes");
    
    int id_cliente = 0;        
    
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
        
        
<select name="ComboPlacas">
    
    <%
        if (s_porid.equals("2")) {
            
      id_cliente = Integer.parseInt(idcliente);
      String nombre = "Select * from vehiculos where id_cliente='"+id_cliente+"'";
      
      ResultSet rs = 	cx.getDatos(nombre);
        while (rs.next()){%>
        <option value="0"></option>
	<option value="<%=rs.getString("id_vehiculo")%>"><%=rs.getString("placas")%></option>
        
	<%}
        
    %>
</select>
    
<%}%>
    </body>
</html>
