<%-- 
    Document   : jquerymobile
    Created on : 24/10/2017, 02:06:43 PM
    Author     : Corei3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="jqm/jquery.mobile-1.4.5.min.css">
        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="jqm/jquery.mobile-1.4.5.min.js"></script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div data-role="page" id="pageone">
  <div data-role="header">
    <h1>Welcome To My Homepage</h1>
  </div>

  <div data-role="main" class="ui-content">
    <p>Welcome!</p>
    <a href="#pagetwo">Go to Dialog Page</a>
  </div>

  <div data-role="footer">
    <h1>Footer Text</h1>
  </div>
</div> 

<div data-role="page" data-dialog="true" id="pagetwo">
  <div data-role="header">
    <h1>I'm A Dialog Box!</h1>
  </div>

  <div data-role="main" class="ui-content">
    <p>The dialog box is different from a normal page, it is displayed on top of the current page and it will not span the entire width of the page. The dialog has also an icon of "X" in the header to close the box.</p>
    <a href="#pageone">Go to Page One</a>
  </div>

  <div data-role="footer">
    <h1>Footer Text In Dialog</h1>
  </div>
</div> 
    </body>
</html>
