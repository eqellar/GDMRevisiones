<%-- 
    Document   : actClieVendedor
    Created on : 18/05/2017, 11:39:31 PM
    Author     : Corei3
--%>

<%@page session="true"%>
<%@page import="dao.VehiculoDAO"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.ClienteDAO" scope="page"></jsp:useBean>
<%   
    String s_area = request.getParameter("txtAlias");
        int valores = Integer.parseInt(s_area);
    
    //String s_opc = request.getParameter("f_opc");
    String s_porid = request.getParameter("f_porid");    
    
    if (s_porid.equals("2")) {
%>
<select name="txtVendedor">
    
    <%
      String vendedor = "SELECT vendedor FROM clientes WHERE id_cliente ='"+valores+"'";
      
      ResultSet rs2 = 	cx.getDatos(vendedor);
        while (rs2.next()){%>
	<option value="<%=rs2.getString("vendedor")%>"><%=rs2.getString("vendedor")%></option>
        
	<%}
        
    %>
</select>    
<%}%>

