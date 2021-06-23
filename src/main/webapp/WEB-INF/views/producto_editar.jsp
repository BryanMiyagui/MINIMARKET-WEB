<%-- 
    Document   : producto_editar
    Created on : 14/01/2020, 11:33:32 PM
    Author     : jbustillos
--%>
<!-- libreria Spring Form -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Producto</title>
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
            <h3><i class="fa fa-angle-right-min"></i>EDITAR PRODUCTOS</h3>
        
        <div class="form-panel-mini">
        
            
            <form:form name="" method="post" modelAttribute="producto" style="padding: 50px" >
                
                
                <div class="form-group">
                  <div class="col-md-4">
                    <div class="input-group input-large">
                      <label class="control-label col-md-4">Codigo:</label>
                      <form:input type="text"  path="id_producto" class="form-control" size="20" maxlength="12" readonly="true" /> 
                    </div>
                  </div>
                </div>
                <hr>
                <div class="form-group">
                  <div class="col-md-4">
                    <div class="input-group input-large">
                      <label class="control-label col-md-4">Nombre</label>
                        <form:input type="text"  path="nombre" class="form-control" size="20" maxlength="64" /> 
                    </div>
                  </div>
                </div>
                <hr>
                <div class="form-group">
                      <div class="col-md-4">
                        <div class="input-group input-large">
                          <label class="control-label col-md-4">Presentación:</label>
                            <select path="unidadMedida" class="form-control">
                                <option value="caja">Caja</option>
                                <option value="bolsa">Bolsa</option>
                                <option value="botella">Botella</option>
                            </select> <br><br>    
                        </div>
                      </div>
                </div>
                <hr>
                <div class="form-group">
                      <div class="col-md-4">
                        <div class="input-group input-large">
                          <label class="control-label col-md-4">Precio:</label>
                            <form:input type="number"  path="precio" step="0.01" min="0" class="form-control" size="20" maxlength="5" /> 
                        </div>
                      </div>
                </div>
                <hr>
                <div class="form-group">
                      <div class="col-md-4">
                        <div class="input-group input-large">
                          <label class="control-label col-md-4">Stock:</label>
                          <form:input type="text"  path="stock" class="form-control" size="20" maxlength="5" readonly="true" /> 

                        </div>
                      </div>
                </div>
                <hr>
                <div class="form-group">
                    <div class="col-md-4">
                        <div class="input-group input-large">
                        <label class="control-label col-md-4">categoria:</label>
                        <form:select path="categoria.id_categoria" class="form-control"
                             items="${lstcategoria}" 
                             itemValue="id_categoria" 
                             itemLabel="descripcion"> 
                        </form:select>             
                        </div>
                    </div>
                </div>
                <hr>
            
                <div class="form-group">
                    <div class="col-md-4">
                        <div class="input-group input-large">
                        <label class="control-label col-md-4">categoria:</label>
                        <form:select path="marca.id_marca" class="form-control"
                             items="${lstmarca}" 
                             itemValue="id_marca" 
                             itemLabel="descripcion"> 
                        </form:select>             
                        </div>
                    </div>
                </div>
             <button class="btn btn-danger btn-xs" type="submit"  >Guardar</button>
             <button class="btn btn-primary btn-xs" type="button" onclick="location.href='<c:url value="/producto"/>'">Cancelar</button>             

        </form:form>
            </div>
            
            <div class="col-sm-4"></div>
        
         </section>
    
  </section>
    </body>
</html>
