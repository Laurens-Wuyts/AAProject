<%-- 
    Document   : toevoegen
    Created on : 18-dec-2019, 14:01:09
    Author     : r0614941
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Edit</title>

        <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    </head>
    <body>
        <div class="page">
            <h1>Computer Details:</h1>
            <img src='pc_icon.png' class="sidebyside"/>
            <div class="text sidebyside">
                <form action="<c:url value='ctrl.do' />" method='POST'>
                    Naam:<input type='text' name='naam' value='' />
                    Info:<input type='text' name='info' value='' />
                    <hr />
                    SerieNummer<input type='text' name='nr'  value='' /><br>
                    Aankoopprijs<input type='text' name='aprs'  value='' /><br>
                    HuurPrijs<input type='text' name='hprs' value='' /><br>
                    <input class='dark btn' type='submit' name='btn'  value='Overzicht' />
                    <input class='dark btn' type='submit' name='btn'  value='Toepassen' />
                </form>
            </div>

         </div>
    </body>
</html>
