<%-- 
    Document   : reservaties
    Created on : 27-nov-2019, 15:59:52
    Author     : r0614393
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.time.YearMonth"%>
<%@page import="beans.Momenten"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% YearMonth yearMonthObject = (YearMonth)session.getAttribute("date");
   int daysInMonth = yearMonthObject.lengthOfMonth();
   int firstDay = (yearMonthObject.atDay(1).getDayOfWeek().getValue() - 1); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>Reservaties</title>

        <!--FONTS-->
        <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic" rel="stylesheet">
    </head>
    <body>
        <div class="page wide">
            <h1>Reservaties:</h1>
            <table class='calendar'>
                <tr>
                    <th>Maandag</th>
                    <th>Dinsdag</th>
                    <th>Woensdag</th>
                    <th>Donderdag</th>
                    <th>Vrijdag</th>
                    <th>Zaterdag</th>
                    <th>Zondag</th>
                </tr>
                <%
                int dag = ((-1)*(firstDay)) + 1;
                for(int j = 0; j <= (firstDay + daysInMonth)/7; j++) {
                    out.println("<tr>");
                    for(int i = 0; i < 7; i++, dag++) {
                        out.print("<td class='");
                        if(i == 5 || i == 6) {
                            out.print("niet_open ");
                        }
                        if(dag <= 0 || dag > daysInMonth) {
                            out.println("niet_maand'></td>");
                        } else {
                            out.println("'>" + dag);
                            for(Momenten m : (List<Momenten>)session.getAttribute("momvrij")) {
                                Date d = Date.valueOf(yearMonthObject.atDay(dag));
                                if(m.getDatum().compareTo(d) == 0) {
                                    out.println("<a href='ctrl.do?btn=ResMom&moid=" + m.getMoid() +"'><div class='uur vrij' >" + m.getStrt() + " Vrij</div></a>");
                                }
                            }
                            
                            for(Momenten m : (List<Momenten>)session.getAttribute("momres")) {
                                Date d = Date.valueOf(yearMonthObject.atDay(dag));
                                if(m.getDatum().compareTo(d) == 0)
                                    out.println("<div class='uur bezet'>" + m.getStrt() + " Bezet</div>");
                            }
                            out.println("</td>");
                        }
                    }
                    out.println("</tr>");
                }
                %>
<!--                    <td>1
                            <div class='uur vrij'>11:00-12:00 Vrij</div>
                            <div class='uur bezet'>12-13 R0614393</div>
                            <div class='uur vrij'>13-14 Vrij</div>
                    </td>
                -->
            </table>
        </div>
    </body>
</html>
