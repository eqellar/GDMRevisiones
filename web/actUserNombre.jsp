<%-- 
    Document   : actUserNombre
    Created on : 19/05/2017, 01:09:35 AM
    Author     : Corei3
--%>
<%@page session="true"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.UsuarioDAO" scope="page"></jsp:useBean>
<%   
    
    String s_area = request.getParameter("txtUsuarioUser");
        int valores = Integer.parseInt(s_area);
    
    //String s_opc = request.getParameter("f_opc");
    String s_porid = request.getParameter("f_porid");
    
    
    if (s_porid.equals("2")) {
%>

<select name="txtSubApellido">
    
    <%
      String nombre = "SELECT nombre FROM usuarios WHERE id_usuario='"+valores+"'";
      
      ResultSet rs = 	cx.getDatos(nombre);
        while (rs.next()){%>
	<option value="<%=rs.getString("nombre")%>"><%=rs.getString("nombre")%></option>
        
	<%}
        
    %>
</select>
    
<%}%>

