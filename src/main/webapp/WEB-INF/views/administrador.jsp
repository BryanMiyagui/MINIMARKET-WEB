<%-- 
    Document   : admin
    Created on : 15/10/2019, 09:29:53 AM
    Author     : Administrador
--%>

<!-- libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- librería Tag Security -->
<%@taglib prefix="security" 
          uri="http://www.springframework.org/security/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        <title>ADMINISTRADOR</title>
        
        <!-- Bootstrap core CSS -->
        
        <link href="resources/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!--external css-->
        <link href="resources/lib/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="resources/css/zabuto_calendar.css">
        <link rel="stylesheet" type="text/css" href="resources/lib/gritter/css/jquery.gritter.css" />
        <!-- Custom styles for this template -->
        <link href="resources/css/style.css" rel="stylesheet">
        <link href="resources/css/style-responsive.css" rel="stylesheet">
        <script src="resources/lib/chart-master/Chart.js"></script>


    </head>
   
    <body>
        <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
      <div class="sidebar-toggle-box">
        <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
      </div>
      <!--logo start-->
      <a href="index.html" class="logo"><b>MY<span>MARKET</span></b></a>
      <!--logo end-->
      
      <div class="top-menu">
        <ul class="nav pull-right top-menu">
          <li><a class="logout" href="login.html">Logout</a></li>
        </ul>
      </div>
    </header>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
        <security:authentication var="username" 
                                 property="principal.username"/>
    <aside>
      <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
          <p class="centered"><a href="#"><img src="resources/images/user21.JPG" class="img-circle" width="80"></a></p>
          
          <h5 class="centered">${username}</h5>
          <li class="mt">
            <a class="active" href="login">
              <i class="fa fa-dashboard"></i>
              <span>INICIO</span>
              </a>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-desktop"></i>
              <span>MANTENIMIENTO</span>
              </a>
            <ul class="sub">
              <li><a href="roles">ROL</a></li>
              <li><a href="usuario">USUARIO</a></li>
              <li><a href="cliente">CLIENTE</a></li>
              <li><a href="proveedor">PROVEEDOR</a></li>
              <li><a href="tipoDocumento">TIPO DOCUMENTO</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-cogs"></i>
              <span>VENTA</span>
              </a>
            <ul class="sub">
              <li><a href="venta">DETALLE VENTA</a></li>
              <li><a href="tipoPago">TIPO PAGO</a></li>
            </ul>
          </li>
          <li class="sub-menu">
            <a href="javascript:;">
              <i class="fa fa-book"></i>
              <span>COMPRA</span>
              </a>
            <ul class="sub">
              <li><a href="compra">COMPRA</a></li>
              
            </ul>
          </li>
        </ul>
        <!-- sidebar menu end-->
      </div>
    </aside>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    
    <!--main content end-->
    <!--footer start-->
    
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
  <script src="resources/lib/jquery/jquery.min.js"></script>

  <script src="resources/lib/bootstrap/js/bootstrap.min.js"></script>
  <script class="include" type="text/javascript" src="resources/lib/jquery.dcjqaccordion.2.7.js"></script>
  <script src="resources/lib/jquery.scrollTo.min.js"></script>
  <script src="resources/lib/jquery.nicescroll.js" type="text/javascript"></script>
  <script src="resources/lib/jquery.sparkline.js"></script>
  <!--common script for all pages-->
  <script src="resources/lib/common-scripts.js"></script>
  <script type="text/javascript" src="resources/lib/gritter/js/jquery.gritter.js"></script>
  <script type="text/javascript" src="resources/lib/gritter-conf.js"></script>
  <!--script for this page-->
  <script src="resources/lib/sparkline-chart.js"></script>

  
  <script type="application/javascript">
    
  </script>
    </body>
</html>
