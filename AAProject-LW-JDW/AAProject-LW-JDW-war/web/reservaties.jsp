<%-- 
    Document   : reservaties
    Created on : 27-nov-2019, 15:59:52
    Author     : r0614393
--%>

<%@page import="java.time.YearMonth"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% YearMonth yearMonthObject = YearMonth.of(2019, 12);
   int daysInMonth = yearMonthObject.lengthOfMonth();
   int firstDay = (yearMonthObject.atDay(1).getDayOfWeek().getValue() + 6) % 7; %>

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
                <tr>
                    <%
                        for(int j = 0; j <= (firstDay + daysInMonth)/7; j++) {
                            for(int i = 0; i < firstDay; i++) {
                                out.println("<td class='niet_maand'></td>");
                            }
                        }
                    %>
                    <td>1
                            <div class='uur vrij'>11:00-12:00 Vrij</div>
                            <div class='uur bezet'>12-13 R0614393</div>
                            <div class='uur vrij'>13-14 Vrij</div>
                    </td>
                </tr>
                <tr>
                    <td>4</td>
                    <td>5</td>
                    <td>6</td>
                    <td>7</td>
                    <td>8</td>
                    <td class="niet_open">9</td>
                    <td class="niet_open">10</td>
                </tr>
                <tr>
                    <td>11</td>
                    <td>12</td>
                    <td>13</td>
                    <td>14</td>
                    <td>15</td>
                    <td class="niet_open">16</td>
                    <td class="niet_open">17</td>
                </tr>
                <tr>
                    <td>18</td>
                    <td>19</td>
                    <td>20</td>
                    <td>21</td>
                    <td>22</td>
                    <td class="niet_open">23</td>
                    <td class="niet_open">24</td>
                </tr>
                <tr>
                    <td>25</td>
                    <td>26</td>
                    <td>27</td>
                    <td>28</td>
                    <td>29</td>
                    <td class="niet_open">30</td>
                    <td class="niet_open niet_maand"></td>
                </tr>
            </table>
        </div>
    </body>
</html>
