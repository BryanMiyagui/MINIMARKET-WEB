<%-- 
    Document   : access_denied
    Created on : 15/10/2019, 09:35:33 AM
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
        <title>access_denied</title>
    </head>
    <body>
        <h3>Error!</h3>
        
        <!-- se obtiene el nombre del usuario (??) -->
        <security:authentication var="username" 
                                 property="principal.username"/>
        
        Estimado(a) <b>${username}</b>; <br>
        Usted no tiene permiso para acceder a esta página. 
        
        <a href="<c:url value='/index'/>">Index</a> | 
        <a href="<c:url value='/logout'/>">Logout</a>
    </body>
</html>
