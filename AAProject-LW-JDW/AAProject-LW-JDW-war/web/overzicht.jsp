<%-- 
    Document   : overzicht
    Created on : 13-nov-2019, 15:29:41
    Author     : r0614941
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello ${type}</h1>
        <form action="ctrl.do" method="post">
            <intput type="submit" name="btn" value="Logout" />
        </form>
    </body>
</html>
