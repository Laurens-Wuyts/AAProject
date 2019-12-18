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
        <h1>Gelieve uw reservatie te confirmeren</h1>
        <c:if test="${type == 'Extern'}">huurprijs:${mom.getMid().getHprs}</c:if>
        
         
        <form action="<c:url value='ctrl.do' />" method='POST'>
                          <input class='light btn' type='submit' name='btn'  value='Akkoord' />
        </form>
    </body>
</html>
