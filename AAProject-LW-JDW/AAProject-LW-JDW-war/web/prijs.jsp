<%-- 
    Document   : prijs
    Created on : 18-dec-2019, 14:43:30
    Author     : r0614941
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! ${moid}</h1>
        <form action="<c:url value='ctrl.do' />" method='POST'>
                          <input class='light btn' type='submit' name='btn'  value='Akkoord' />
        </form>
    </body>
</html>
