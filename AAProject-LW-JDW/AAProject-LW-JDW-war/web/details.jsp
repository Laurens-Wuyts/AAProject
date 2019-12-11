<%-- 
    Document   : details
    Created on : 27-nov-2019, 15:49:34
    Author     : r0614393
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Details</title>

        <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    </head>
    <body>
        <div class="page">
            <h1>Computer Details:</h1>
            <img src='pc_icon.png' class="sidebyside"/>
            <div class="text sidebyside">
                <h2>${m.mnaam}</h2>
                <p>${m.minfo}</p>
                <p></p>
                <hr />
                <p>Opleiding: ${m.mopl}<p>
            </div>

            <div class='btns'>
                <form action="<c:url value='ctrl.do' />" method='POST'>
                        <input class='dark btn' type='submit' name='btn'  value='Reserveer' />
                        <input class='dark btn' type='submit' name='btn'  value='Overzicht' />
                </form>
            </div>
        </div>
    </body>
</html>
