<%-- 
    Document   : actualizarcliente
    Created on : 24/03/2017, 07:34:10 PM
    Author     : Corei3
--%>

<%@page session="true"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ClienteDTO"%>
<%@page import="dao.ClienteDAO"%>

<%
    ClienteDAO clie = new ClienteDAO();
    ArrayList<ClienteDTO> listclie = clie.readAll();
    String d = (String) request.getSession().getAttribute("logout");    
    String tipouser = (String) request.getSession().getAttribute("tipouser");
    String nombreUsuario = (String) request.getSession().getAttribute("nombreUsuario");
    //request.getSession().setAttribute("nombreUsuario", nombreUsuario);
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
            function extraer() {

                //var porId = document.getElementById("idcliente").value; //Se crea una variable con el valor del select con ID = idcliente
                //document.getElementById("resultado").value = porId; //Se le asigna el valor antes capturado con la variable porId al elemento con id=resultado 
                //alert("cambiar a select dependiente");
                $("#i_porid").val("2");
                $("#i_opc").val("1");

                $.post("comboNombreClie.jsp", $("#actcliente").serialize(), function (actcliente) {
                    $("#i_name").html(actcliente);
                });
            }

            function extraevendedor() {
                //alert("combo2");
                $.post("actClieVendedor.jsp", $("#actcliente").serialize(), function (data) {
                    $("#i_vendedor").html(data);
                });

            }

            function verifica() {
                var porId = document.getElementById("idcliente").value; //Se crea una variable con el valor del select con ID = idcliente
                document.getElementById("resultado").value = porId; //Se le asigna el valor antes capturado con la variable porId al elemento con id=resultado 
                if (document.getElementById('btnactivar').checked)
                {
                    document.getElementById('idcliente').disabled = true;
                    document.getElementById('idnewalias').disabled = false;
                    document.getElementById('btnidact').disabled = false;
                    document.getElementById('idnewname').disabled = false;
                    document.getElementById('idnewvendedor').disabled = false;

                    var textoAlias = actcliente.txtAlias.options[porId].text;
                    document.getElementById("idnewalias").value = textoAlias;

                    var textoNombre = actcliente.txtName.options[0].text;
                    document.getElementById("idnewname").value = textoNombre;

                    var textoVendedor = actcliente.txtVendedor.options[0].text;
                    document.getElementById('idnewvendedor').value = textoVendedor;

                } else
                {
                    document.getElementById('idcliente').disabled = false;
                    document.getElementById('idnewalias').disabled = true;
                    document.getElementById('btnidact').disabled = true;
                    document.getElementById('idnewname').disabled = true;
                    document.getElementById('idnewvendedor').disabled = true;
                }
            }


        </script>
    </head>

    <body>        
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Actualizar Clientes</h2></div>
        <hr>
        <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
        <hr>
        <h1>Seleccione el Alias para actualizar los datos del cliente</h1>
        <form action="atualizarcliente.do" method="post" id="actcliente">
            <table>
                <tr>
                    <td>		                             
                        <input type="hidden" name="resultado" id="resultado">
                        <input type="hidden" name="f_porid" id="i_porid">
                    </td>
                </tr>
                <tr>
                    <td align="right">Alias Actual</td>
                    <td> 

                        <select name="txtAlias" id="idcliente" onchange="extraer();
                                extraevendedor()">
                            <option value="" >--Seleccione Alias--</option>
                            <%                            for (int i = 0; i < listclie.size(); i++) {
                                    out.println("<option value=\"" + listclie.get(i).getId_cliente() + "\">" + listclie.get(i).getAlias() + "</option>");
                                }
                            %>		
                        </select>
                    </td>
                    <td>


                    </td>

                    <td align="right">Nuevo Alias</td>
                    <td>
                        <input type="text" name="txtNuevoAlias" id="idnewalias" disabled=""/>
                    </td>
                </tr>
                <tr>
                    <td align="right">Nombre Actual</td>
                    <td>
                        <select disabled="" name="txtName" id="i_name" onchange="">
                            <option value=""></option>
                        </select>					
                    </td>
                    <td></td>

                    <td align="right">Nuevo Nombre</td>
                    <td>
                        <input type="text" name="txtNuevoNombre" id="idnewname" disabled="" size="50"/>
                    </td>

                </tr>
                <tr>                
                    <td align="right">Vendedor Actual</td>
                    <td>
                        <select disabled="" name="txtVendedor" id="i_vendedor">
                            <option value=""></option>
                        </select>
                    </td>
                    <td></td>

                    <td align="right">Nuevo Vendedor</td>
                    <td>
                        <input type="text" name="txtNuevoVendedor" id="idnewvendedor" disabled=""/>
                    </td>

                    <td></td>

                </tr>


                <tr>
                    <td align="right">Editar</td>
                    <td><input type="checkbox" name="btnactivar" id="btnactivar" value="Editar..." onclick="verifica()"/></td>
                    <td></td>
                    <td><input type="submit" name="btnAct" id="btnidact" value="Actualizar..." disabled=""/></td>
                </tr>
            </table>
        </form>
                        <%
        } else {

        %>
        <h1>Su sesión ah expirado, favor iniciar sesión</h1>
        <a href="index.jsp">Inicio de Sesión</a>        
        <%
            }
        %>
    </body>
</html>
