<%-- 
    Document   : comboDispositivo
    Created on : 24/05/2017, 12:48:04 PM
    Author     : Corei3
--%>
<%@page session="true"%>
<%@page import="java.sql.ResultSet"%>
<jsp:useBean id="cx" class="dao.ClienteDAO" scope="page"></jsp:useBean>
<%   
    String imeidis = request.getParameter("buscadisp");
        
    
    //String s_opc = request.getParameter("f_opc");
    String s_porid = request.getParameter("f_porid");    
    
    if (s_porid.equals("2")) {
%>


<select name="txtSubClie">
    
    <%
      String consultaDisp = "SELECT id_dsipositivo, id_cliente, id_vehiculo FROM dispositivos WHERE imei = '"+imeidis+"'";
      
      ResultSet rs = 	cx.getDatos(consultaDisp);
        while (rs.next()){%>
	<option value="<%=rs.getString("telefono")%>"><%=rs.getString("telefono")%></option>
        
	<%}
        
    %>
</select>
    
<%}%>

