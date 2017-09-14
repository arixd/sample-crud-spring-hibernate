<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <h1>User Detail</h1>
        <table>
            <tr><td>ID 
                <td>
            <tr><td>${user.id}
            <tr><td>Name<td>
            <tr><td>${user.name}
            <tr><td>Email<td>
            <tr><td>${user.email}
            <tr><td>Address<td>
            <tr><td>${user.address}
            <tr><td>Newsletter<td>
            <tr><td>${user.newsletter}
            <tr><td>Web Frameworks<td>
            <tr><td>${user.framework}
            <tr><td>Sex<td>
            <tr><td>${user.sex}
            <tr><td>Number<td>
            <tr><td>${user.number}
            <tr><td>Country<td>
            <tr><td>${user.country}
            <tr><td>Skill<td>
            <tr><td>${user.skill}
        </table>
    </body>
</html>