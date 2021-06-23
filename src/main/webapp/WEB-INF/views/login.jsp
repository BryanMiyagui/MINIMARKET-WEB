<%-- 
    Document   : login
    Created on : 15/10/2019, 11:05:48 AM
    Author     : Administrador
--%>
<!-- libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
          <title>login</title>
           <c:url  var="ruta" value="/resources/images"/>
          <link href="resources/css/MyStyle.css" rel="stylesheet" type="text/css"/>
        
    </head>
    <body>
        <div id="cuadro">
            <div class="container">
            
        <form name="" method="post" action="/company/login">
             <center>  
                 <img src="${ruta}/logine.jpg" width="100" height="100" />
            <p id="titulo"> INICIAR SECCIÓN </p>
           <hr>
            <!-- token de seguridad -->
            <input type="hidden" 
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            
            <!-- si existe el cierre de sesión -->
            <c:if test="${param.logout != null}">
                <p style="color:green">
                    Usted ha cerrado sesión!
                </p>
            </c:if>
            
            <!-- si existe error de logeo -->
            <c:if test="${param.error != null}">
                <p style="color:red">
                    Error, username y/o password incorrecto!
                </p>
            </c:if>
                
         Usuario: <input type="text" name="txtUsername" placeholder="&#128273; Ingrese usuario"/> <br><br>
         Contraseña: <input type="password" name="txtPassword" placeholder="&#128273; Ingrese contraseña"/> <br><br>
        
             </center> 
            <button type="submit" id="boton">Iniciar sesión</button>
        </form>
              </div>        
          </div>     
    </body>
</html>
