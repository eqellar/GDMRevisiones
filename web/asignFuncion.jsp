<%-- 
    Document   : asignFuncion
    Created on : 6/07/2017, 04:06:08 PM
    Author     : Corei3
--%>

<%@page import="dto.FuncionalidadDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.FuncionalidadDAO"%>
<%
    
        FuncionalidadDAO fun = new FuncionalidadDAO();
        ArrayList<FuncionalidadDTO> listfun = fun.readAll();
        String imei = (String) request.getSession().getAttribute("imei");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="asignafuncionalidad.do" method="post">
            
            <table>
                <tr>
                    <td><input type="text" name="imei" value="<%=imei%>" readonly=""</td>
                </tr>
            </table>
            
             <table border = "1">
            <tr>
                <td>
                    <ul>
                        <%
                            for (int i = 0; i < listfun.size(); i++) {
                                out.println("<li>" + listfun.get(i).getTipo() + "</li>");

                        %>                        

                    
                    <%}
                    %>
                    </ul>

                </td>
                
                
                <td>
                    <ul>
                        <%
                            for (int i = 0; i < listfun.size(); i++) {
                                int idfun = listfun.get(i).getId_funcion();

                        %>  
                        <li>
                            <input type='checkbox' name='<%=idfun%>' />
                        </li>                        
                    <%}
                    %>
                    </ul>

                </td>                
            </tr>
        </table>
                    
                    <div>
                        <input type="submit" value="Guardar..."/>
                    </div>
            
        </form>
       
    </body>
</html>
