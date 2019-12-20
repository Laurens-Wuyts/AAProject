<%-- 
    Document   : login
    Created on : 6-nov-2019, 15:25:59
    Author     : r0614941
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inloggenpagina</title>
    </head>
    <body>
        <h1>Log je in</h1>
        <form method= "post" action="j_security_check" >
            <input type="text" name= "j_username" >
            <input type="password" name= "j_password" >
            <input type="submit" name="knop" value="inloggen" /> 
        </form>
    </body>
</html>
