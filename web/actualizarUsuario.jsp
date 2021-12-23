<%-- 
    Document   : actualizarUsuario
    Created on : 11/05/2017, 08:30:38 PM
    Author     : Corei3
--%>


<%@page session="true"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.UsuarioDTO"%>
<%@page import="dao.UsuarioDAO"%>


    <%
        UsuarioDAO clie = new UsuarioDAO();
        ArrayList<UsuarioDTO> listusu = clie.readAll();
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
            
            function extraeUser()
            {
                //alert("cambiar a select dependiente");

                $("#i_porid").val("2");

                $.post("actUserNombre.jsp", $("#data").serialize(), function (data) {
                    $("#i_nombre").html(data);
                });
            }

            function extraeApe()
            {
                //alert("combo2");
                $.post("actUserApellido.jsp", $("#data").serialize(), function (data) {
                    $("#i_apellido").html(data);
                });
            }
            function extraeTipo()
            {
                //alert("combo3");
                $.post("actUserNivel.jsp", $("#data").serialize(), function (data) {
                    $("#i_tipo").html(data);
                });
            }
            
            function habilita(){
                document.getElementById('btnEdit').disabled = false;
            }
            function llenarBox() {
                //var comboid = document.getElementById("i_usuario"); //Se crea una variable con el valor del select con ID = idcliente
                //document.getElementById("user_id").value = comboid; //Se le asigna el valor antes capturado con la variable porId al elemento con id=resultado 

                if (document.getElementById('btnEdit').checked)
                {
                    document.getElementById("i_usuario").disabled = true;
                    document.getElementById("newUser").disabled = false;
                    document.getElementById("txtfname").disabled = false;
                    document.getElementById("txtname").disabled = false;
                    document.getElementById("txtnivel").disabled = false;
                    document.getElementById("txtpssw").disabled = false;
                    document.getElementById("btnActualizar").disabled = false;
                    
                    var textoUsuario = data.i_usuario.options[i_usuario.selectedIndex].text;
                    document.getElementById("newUser").value = textoUsuario;
                    document.getElementById("usu").value = textoUsuario;
                    var textoNombre = data.txtNombreUser.options[0].text;
                    document.getElementById("txtname").value = textoNombre;
                    var textoApellido = data.txtApellido.options[0].text;
                    document.getElementById("txtfname").value = textoApellido;
                    
                }else{
                    document.getElementById("i_usuario").disabled = false;
                    document.getElementById("newUser").disabled = true;
                    document.getElementById("txtfname").disabled = true;
                    document.getElementById("txtname").disabled = true;
                    document.getElementById("txtnivel").disabled = true;
                    document.getElementById("txtpssw").disabled = true;
                    document.getElementById("btnActualizar").disabled = true;
                }

            }
        </script>
    </head>

    <body>
        <%
            if (nombreUsuario != null) {
        %>
        <div align="left"><img src="images/global.jpg">  <img src="images/fu.jpg" align="right"> <h2 align="center">Actualizar Usuarios</h2></div>
        <hr>
         <h5><a href="sistema.jsp">Regresa a Inicio</a></h5>
         <hr>
    <h1>Seleccione el Usuario que desea actualizar</h1>
    <form action="actualizausuario.do" method="post" id="data">
        <table>
            <tr>
                <td>		                             

                    <input name="f_porid" id="i_porid" hidden="">
                    <input name="user_id" id="user_id" hidden="">
                </td>
            </tr>
            <tr>
                <td align="right">Usuario Actual</td>
                <td> 

                    <select name="txtUsuarioUser" id="i_usuario" onchange="extraeUser(), extraeApe();extraeTipo(), habilita()">
                        <option value="" >--Seleccione Usuario--</option>
                        <%                            for (int i = 0; i < listusu.size(); i++) {
                                out.println("<option value=\"" + listusu.get(i).getId_usuario() + "\">" + listusu.get(i).getUsuario() + "</option>");
                            }
                        %>		
                    </select>

                <td align='right' >Nuevo Usuario</td>
                
                <td><input type="text" name="txtNuevoUsuario" id="newUser" disabled=""></td>
                <td> <input type="text" name="usu" id="usu"  hidden=""></td>
                </td>                
            </tr>
            <tr>
                <td align="right">Nombre Actual</td>
                <td>
                    <select name="txtNombreUser" id="i_nombre" disabled="">
                    </select>


                </td>

                <td align="right">Nuevo Nombre</td>
                <td>                    
                    <input type="text" name="txtname" id="txtname"  disabled=""/>
                </td>

            </tr>
            <tr>                
                <td align="right">Apellido Actual</td>
                <td>
                    <select disabled="" name="txtApellido" id="i_apellido">
                        <option value=""></option>
                    </select>
                </td>
                <td align="right">Nuevo Apellido</td>
                <td>
                    <input type="text" name="txtNuevoApellido" id="txtfname"  disabled=""/>
                </td>
            </tr>
            <tr>                
                <td align="right">Nivel Actual</td>
                <td>
                    <select disabled="" name="txtTipo" id="i_tipo">
                        <option value=""></option>
                    </select>                
                </td>
            
                <td align="right">Nuevo Nivel</td>
                <td>
                    <select name="txtNuevoNivel" id="txtnivel" disabled="">
                        <option value="0">---Selecione Nivel---</option>
                        <option value="3">3.Consulta</option>
                        <option value="2">2.Monitoreo</option>
                        <option value="1">1.Adminitrador</option>

                    </select>
                </td>
            </tr>
            <tr>                
                <td></td>
                <td></td>
                <td align="right">Nuevo Password</td>
                <td>
                    <input type="text" name="txtNuevoPassword" id="txtpssw" disabled=""/>
                </td>

                
               

            </tr
            
            <tr>
                <td align='right'>Editar ==></td>
                <td><input type="checkbox" name="btnEditar" id="btnEdit" onclick="llenarBox()" disabled=""/></td>
               <td></td>
               <td><input type="submit" name="btnActualizar" id="btnActualizar" value="Actualizar..." disabled="" /></td>
                           
                

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
