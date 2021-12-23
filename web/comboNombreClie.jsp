<%-- 
    Document   : comboNombreClie
    Created on : 24/05/2017, 05:25:38 AM
    Author     : Corei3
--%>

<%@page session="true"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.ClienteDAO" scope="page"></jsp:useBean>
<%   
    String s_area = request.getParameter("txtAlias");
        int valores = Integer.parseInt(s_area);
    
    //String s_opc = request.getParameter("f_opc");
    String s_porid = request.getParameter("f_porid");    
    
    if (s_porid.equals("2")) {
%>


<select name="txtSubClie">
    
    <%
      String nombre = "Select nombre_clie from clientes where id_cliente='"+valores+"'";
      
      ResultSet rs = 	cx.getDatos(nombre);
        while (rs.next()){%>
	<option value="<%=rs.getString("nombre_clie")%>"><%=rs.getString("nombre_clie")%></option>
        
	<%}
        
    %>
</select>
    
<%}%>

