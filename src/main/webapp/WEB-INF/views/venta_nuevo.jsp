<%-- 
    Document   : venta_nuevo
    Created on : 25/01/2020, 01:47:50 PM
    Author     : jbustillos
--%>

<!-- libreria Spring Form -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!-- librería Tag Security -->
<%@taglib prefix="security" 
          uri="http://www.springframework.org/security/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registrar Venta</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
        
        <style>
            body {
                background: #007BFF;
                background: linear-gradient(to right, #e9ecef, #e9ecef);
                
            }
            
            .form-panel-mini {

                background: #FFFFFF;
                margin: 3px;
                margin-right: 50px;
                box-shadow: 0px 3px 2px #aab2bd;
                text-align: left;
                        
                }

            .main-content-min {
                margin-left: 100px;
            }

             .wrapper{
                display: inline-block;
                margin-top: 60px;
                padding-left: 15px;
                padding-right: 15px;
                padding-bottom: 15px;
                padding-top: 0px;
                width: 100%;
            }
            .fa {
               display: inline-block;
               font: normal normal normal 14px/1 FontAwesome;
               font-size: inherit;
               text-rendering: auto;
               -webkit-font-smoothing: antialiased;
               -moz-osx-font-smoothing: grayscale;
            }   
            .black-bg {
                background: #22242a;
                border-bottom: 1px solid #393d46;
            }
            .header {
                   position: fixed;
                   left: 0;
                   right: 0;
                   z-index: 1002;
            }
            a.logo {
                font-size: 24px;
                color: #f2f2f2;
                float: left;
                margin-top: 0px;
                text-transform: uppercase;
            }

            a.logo b {
                font-weight: 900;
            }

            a.logo:hover, a.logo:focus {
                text-decoration: none;
                outline: none;
            }

            a.logo span {
                color: #4ECDC4;
            }
            
table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even){background-color: #F0F8FF}

th {
  background-color: #00BFFF;
  color: white;
}
        </style>
    </head>
    <body>
        <header class="header black-bg">
            <div class="sidebar-toggle-box">
              <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
            </div>
            <a href="index.html" class="logo"><b>MI<span>MARKET</span></b></a>
            <div class="nav notify-row" id="top_menu"></div>
            <div class="top-menu">
                <ul class="nav pull-right top-menu"></ul>
            </div>
        </header>
       
        <section class="main-content-min">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right-min"></i>REALIZAR VENTA</h3>
        
        <div class="form-panel-mini">
        
            
            
            <form:form name="" method="post" modelAttribute="venta" style="padding: 20px">
  
                <div class="form-group">
                  <div class="col-md-8">
                    <table > 
                        
                        <tr>
                            
                            <td>
                                <div class="input-group input-large">
                                  <label class="control-label col-md-4">Fecha:</label>
                                    <form:input type="text" path="fecha_venta" readonly="true" class="form-control" size="20" maxlength="12" /> 


                                </div>
                            </td>
                            <td>
                            <div class="input-group input-large">

                                <label class="control-label col-md-4">Usuario:</label>
                                <form:input type="text" path="userVo.username" readonly="true" class="form-control" size="20" maxlength="16" /> 
                            </div>
                            </td>
                        </tr>
                    </table>
                  </div>
                </div> 
                                      
                <div class="form-group">
                  <div class="col-md-8">
                    <table>
                        <tr>
                            <td>
                                <div class="input-group input-large">
                                  <label class="control-label col-md-4">Cliente:</label>

                                        <form:select path="cliente.id_cliente" class="form-control"  maxlength="64"
                                                     items="${lsCliente}" 
                                                     itemValue="id_cliente" 
                                                     itemLabel="nombre"  required="">   
                                        </form:select> 

                                  </div>
                                </td>
                                <td>
                                    
                                    <div class="input-group input-large">
                                     <label class="control-label col-md-4">Pago:</label>

                                          <form:select path="tipoPago.id_tipoPago" class="form-control"  maxlength="64"
                                                        items="${lsTipoPago}" 
                                                        itemValue="id_tipoPago" 
                                                        itemLabel="descripcion" required="">   
                                           </form:select>
                                    </div>                                   
                                </td>
                        </tr>
                    </table>
                  </div>                   
            </div>
                    <!-- Detalle de compra -->
             
                    <table class="table table-bordered table-hover table-striped">                             
                        <tr>
                            <th>
                                <button type="submit" name="btnAdicionar">Adicionar</button>                            
                            </th>
                            <th>Producto</th>  
                            <th>Cantidad</th>      
                        </tr>
                    </table>
                    <table class="table ">         
                        <thead class="thead-light">
                        <tr>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th></th>
                            <th>
                                <select  name="id_producto" class="control-label col-md-4">
                                    <c:forEach items="${lsProducto}" var="card"> 
                                        <option value="${card.id_producto}">${card.nombre}</option>
                                    </c:forEach>
                                </select>      

                            </th>
                         
                            <th>
                                <input type="text" class="form-control active" 
                                            name="cantidad" size="1" /> 
                            </th>      
                        </tr>
                    </table> 
                    
                    <table >
                        <tr>
                            <td><b>Producto</b></td>
                            <td><b>Descripcion</b></td>
                            <td><b>Precio</b></td>
                            <td><b>Cantidad</b></td>
                            <td><b>IGV</b></td>
                            <td><b>Total</b></td>
                        </tr>
                        
                        <c:forEach var="item" items="${bCarritoVenta}">
                            <tr>
                                <td>${item.id_producto}</td>
                                <td>${item.producto}</td>
                                <td>${item.precio}</td>
                                
                                <td>${item.cantidad}</td>
                                
                                <td>${(item.precio * 0.18)}</td>
                                <td>${(item.precio * item.cantidad)}</td>
                            </tr>
                        </c:forEach>

                        <tr>
                            <td><b></b></td>
                            <td><b></b></td>
                            <td><b></b></td>
                            
                            <td><b></b></td>
                            <td><b>SubToal</b></td>
                            <td><b>${bSubTotal}</b></td>
                        </tr>
                         <tr>
                            <td><b></b></td>
                            <td><b></b></td>
                            <td><b></b></td>
                            
                            <td><b></b></td>
                            <td><b>IGV</b></td>
                            <td><b>${bIgv}</b></td>
                        </tr>
                        <tr>
                            <td><b></b></td>
                            <td><b></b></td>
                            <td><b></b></td>
                            
                            <td><b></b></td>
                            <td><b>Total</b></td>
                            <td><b>${bTotal}</b></td>
                        </tr>                        
                    </table>
          
                    <br>
                <button class="btn btn-primary btn-xs" type="submit" name="btnGuardar" >Guardar</button>
                <button class="btn btn-danger btn-xs" type="submit"  name="btnCancelar">Cancelar</button>             

                    
                    
                    
            </form:form> 

        </div> 
      
    </section>
    
        </section>
    </body>
</html>
