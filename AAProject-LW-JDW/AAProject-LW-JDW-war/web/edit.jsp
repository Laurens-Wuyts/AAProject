<%-- 
    Document   : edit
    Created on : 11-dec-2019, 14:32:16
    Author     : r0614393
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
                    ${m.mid}<input type="hidden" name="mid" value="${m.mid}"  />
                    Naam:<input type='text' name='naam' value='${m.mnaam}' />
                    Info:<input type='text' name='info' value='${m.minfo}' />
                    <hr />
                    Opleiding: ${m.mopl}<br>
                    SerieNummer<input type='text' name='nr'  value='${m.msnr}' /><br>
                    Aankoopprijs<input type='text' name='aprs'  value='${m.aprs}' /><br>
                    HuurPrijs<input type='text' name='hprs' value='${m.hprs}' /><br>
                    <input class='dark btn' type='submit' name='btn'  value='Overzicht' />
                    <input class='dark btn' type='submit' name='btn'  value='Aanpassen' />
                </form>
            </div>

         </div>
    </body>
</html>
