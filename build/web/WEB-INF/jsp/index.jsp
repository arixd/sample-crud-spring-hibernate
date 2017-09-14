<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <a href="redirectCreate.htm">insert data</a>
        <table style="border-collapse: collapse;" cellpadding="7px" border="1px";>
            <tr><td>ID<TD>NAME<TD>ACTION
            <c:forEach items="${list}" var="emp">
                <TR><TD>${emp.id}
                    <TD>${emp.name}
                    <TD>
                        <a href="edit.htm?id=${emp.id}">Edit </a>| 
                        <a href="remove.htm?id=${emp.id}" onclick="return confirm('Are you sure')">Remove</a>
            </c:forEach>
        </table>
    </body>
</html>