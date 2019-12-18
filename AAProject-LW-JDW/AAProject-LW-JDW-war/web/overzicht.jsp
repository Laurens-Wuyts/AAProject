<%-- 
    Document   : overzicht
    Created on : 13-nov-2019, 15:29:41
    Author     : r0614393
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
        <title>Overzicht</title>
    </head>
    <body>
       gebruiker: ${gebruiker.login}
         opl       ${gebruiker.opl}
        login: ${login}
        <div class="container">
            <c:forEach var="machine" items="${machines}">
                <div class='pc_info'>
                    <img src='pc_icon.png' class='sidebyside'/>
                    <div class='box sidebyside'>
                        <div class='info'>
                            <h3>${machine.mnaam}</h3>
                            <p>Opleiding: ${machine.mopl}</p>
                        </div>
                        <div class='btns'>
                            <form action="<c:url value='ctrl.do' />" method='POST'>
                                <input type="hidden" value="${machine.mid}" name="mid" />
                                <c:if test="${type != 'Docent'}"><input class='light btn' type='submit' name="btn" value='Reserveer' /></c:if>
                                <c:if test="${type != 'Extern'}"><input class='light btn' type='submit' name="btn" value='Details' /></c:if>
                                <c:if test="${type == 'Docent' && gebruiker.opl.equals(machine.mopl)}"><input class='light btn' type='submit' name='btn'  value='Edit' />
                                                                 <input class='light btn' type='submit' name='btn'  value='Verwijder' /> </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class='btns_bottom'>
            <c:if test="${type == 'Docent'}">
                <form action="<c:url value='ctrl.do' />" method='POST'>
                    <input class='dark btn' type='submit' name='btn' value='Toevoegen' />
                </form>
            </c:if>
        </div>
        <form action="<c:url value='ctrl.do' />" method="post">
            <input class='dark btn' type="submit" name="btn" value="Logout" />
        </form>
    </body>
</html>
