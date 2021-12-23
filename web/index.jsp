<%-- 
    Document   : index
    Created on : 24/02/2017, 12:57:09 PM
    Author     : Corei3
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
            <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>Documento sin t&iacute;tulo</title>
                <script src="js/jquery-2.1.4.js" type="text/javascript"></script>
                <link href="bootstrap/bootstrap.min.css" rel="stylesheet"/>    
                <link href="bootstrap/bootstrap-theme.css" rel="stylesheet"/>
                <link href="css/normalize.css" rel="stylesheet">
                    <link href="css/estilos.css" rel="stylesheet">
                        <link href="css/paraiconos.css" rel="stylesheet" />
                        <link href="fonts/OleoScript-Regular.ttf" rel="stylesheet" />
                        <link rel="stylesheet" href="css/paraicono.css">
                            <link rel="stylesheet" href="alertaschidas/sweetalert.css"/>
                            <script src="alertaschidas/sweetalert-dev.js"></script>

                            </head>
                            <style>
                                @font-face{
                                    font-family:Fuentechida;
                                    src:url(fonts/OleoScript-Regular.ttf);
                                }
                                body{
                                    background-image: url(images/gateway.JPG);
                                    background-size:cover;
                                    background-repeat: no-repeat;
                                    background-attachment:fixed;
                                }
                                .formulario{
                                    transition: 2s;
                                    margin-top: 100px;
                                    width: 30%;
                                    box-shadow: 0px 0px 40px rgba(102,102,102 ,1),0px 0px 80px rgba(120,0,0 ,1);
                                }

                                .formulario:hover{
                                    transition: .8s;
                                    background-color: rgba(0,0,0,.5);
                                }


                                .logo{
                                    height: 40px;
                                    margin-top: 20px;
                                }

                                .logo2{
                                    height: 47px;
                                    margin-top: 20px;
                                }


                                .espaciado{
                                    margin-top: 40px;
                                }

                                fieldset{
                                    transition: 2s;
                                    margin-bottom: 50px;
                                    border-color: rgba(255,102,51 ,5);
                                    border-style: groove;
                                    border-width: 5px;
                                    border-radius: 10px;
                                }



                                h3,h4{

                                    color:white;
                                    text-align: center;
                                    font-family: fuentechida;
                                }

                                .Input{
                                    transition: .8s;
                                    background-color: rgba(0,153,255,.2);
                                    color: white;
                                    border-color:#006;
                                    border-bottom-color:black;
                                    border-bottom-style:groove;
                                    border-left:none;
                                    border-right:none;
                                    border-top:none;
                                    border-width: 4px;

                                }

                                .Input:hover{
                                    transition: .8s;
                                    background-color:rgba(55,71,79 ,.5);
                                    box-shadow:inset;
                                    border-bottom-color:white;
                                }

                                .Input:focus{
                                    transition: .8s;
                                    border-bottom-color:green;
                                }



                                @media screen and (max-width:750px) {

                                    .logo{
                                        height: 50px;

                                    }
                                    .formulario{
                                        transition: 2s;
                                        width: 95%;
                                        margin-top: 10px;
                                    }
                                }
                            </style>


                            <body>
                                <div class="container formulario">
                                    <div class="row">
                                        <div class="col-xs-1 col-xs-offset-1">
                                            <img src="images/gdm_trans.png" class="logo center-block"></img>                   
                                        </div>
                                        <div class="col-xs-4 col-xs-offset-5">
                                            <img src="images/fu_trans.png" class="logo2 center-block"></img>    
                                        </div>

                                    </div>


                                    <div class=" espaciado">

                                    </div>
                                    <div class="row">
                                        <fieldset class="col-xs-10 col-xs-offset-1">


                                            <legend class="hidden-xs">
                                                <h3>Inicio de Sesión</h3>
                                            </legend>

                                            <form role="form" class="form-horizontal" action="login.do" method="post">

                                                <div class="form-group">
                                                    <label class="col-xs-12" for="usuario"><h4>Usuario</h4></label>
                                                    <div class="col-xs-10 col-xs-offset-1">

                                                        <input type="text" id="usuario" name="txtUsuario" class="form-control Input">

                                                    </div>

                                                </div>
                                                <div class="form-group">
                                                    <label class="col-xs-12" for="password"><h4>Password</h4></label>
                                                    <div class="col-xs-10 col-xs-offset-1">
                                                        <input type="password" id="password" name="txtPassword" class="form-control col-xs-12 Input">
                                                    </div>

                                                </div>

                                                <div class="form-group">
                                                    <button type="submit" class="btn btn-success center-block">Aceptar</button>

                                                </div>

                                            </form>
                                        </fieldset>

                                    </div>
                                </div>


                            </body>
                            </html>