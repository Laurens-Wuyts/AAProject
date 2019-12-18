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
                    <input type='text' value='${m.mnaam}' />
                    <input type='text' value='${m.minfo}' />
                    <hr />
                    <input type='text' value='${m.mopl}' />
                    <input type='text' value='${m.msnr}' />
                    <input type='text' value='${m.aprs}' />
                    <input type='text' value='${m.hprs}' />
                    <input class='dark btn' type='submit' name='btn'  value='Overzicht' />
                </form>
            </div>

            <div class='btns'>
                <form action="<c:url value='ctrl.do' />" method='POST'>
                        <input class='dark btn' type='submit' name='btn'  value='Aanpassen' />
                </form>
            </div>
        </div>
    </body>
</html>
