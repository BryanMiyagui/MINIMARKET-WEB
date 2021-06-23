<%-- 
    Document   : roles_nuevo
    Created on : 19/01/2020, 10:57:43 PM
    Author     : jbustillos
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registrar roles</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </head>
    </head>
  <body style="padding: 20px">
        <center>
        <div id="cuadro1">
            
        <center>
        <h3 id="titulo1">Registro Roles</h3> <br>
        </center>
        <form:form name="" method="post"  modelAttribute="roles">
   
            <br>
            
            Rol <form:input type="text" path="type" size="16" value=""/><br><br>
            <button type="submit">Guardar</button>
            <button type="button" onclick="location.href='<c:url value="/roles"/>'">Cancelar</button>

        </form:form>
        </div> 
    </center>
    </body>
</html>
