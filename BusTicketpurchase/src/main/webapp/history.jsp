<%@ page import="entity.Direction" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Previous Bookings
</title>
</head>
<body>
<h1><p align ="center">Your previous booking</p></h1><br><br>
<div align="center">
    <form action="servlet4" method="post">
    <left></left>
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>hourOfDeparture</th>
            <th>select</th>
        </tr>
    <c:forEach var="user" items="${directions}">
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.hourOfDeparture}" /></td>
                <td>
                    <a href="name.jsp">Select</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
</div>

</body>
</html>