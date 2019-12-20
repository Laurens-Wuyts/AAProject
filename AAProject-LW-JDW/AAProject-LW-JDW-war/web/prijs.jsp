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
        <link rel="stylesheet" href="style.css">
        <title>Prijs</title>

        <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    </head>
    <body>
        <div class="page">
            <h1>Gelieve uw reservatie te confirmeren</h1>
            <c:if test="${type == 'Extern'}"><p>huurprijs: ${mom.getMid().getHprs()} euro </p></c:if>
         
            <form action="<c:url value='ctrl.do' />" method='POST'>
                <input class='dark btn' type='submit' name='btn'  value='Akkoord' />
            </form>
        </div>
    </body>
</html>
