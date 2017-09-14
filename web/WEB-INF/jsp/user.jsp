<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <spring:url value="/users/add.htm" var="urlAddUser"/>
        
        <a href="${urlAddUser}">Add User</a>
        <c:if test="${not empty msg}">
            <div class="alert alert-${css} alert-dismissible" role="alert">
                <button type="button" class="close" data-dismiss="alert" 
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <strong>${msg}</strong>
            </div>
        </c:if>
        <table  style="border-collapse: collapse;" cellpadding="7px" border="1px";>
            <tr><td>#ID<TD>Name<td>Email<td>Framework<TD>Action
                    <c:forEach var="user" items="${list}">
                <tr><td>${user.id}<td>${user.name}
                    <td>${user.email}
                    <td>${user.framework}
                    <td> <spring:url value="/users/find/${user.id}/view.htm" var="userUrl" />
                        <spring:url value="/users/user/${user.id}/update.htm" var="updateUrl" />
                        <spring:url value="/users/${user.id}/delete" var="deleteUrl" /> 

                        <button onclick="location.href = '${userUrl}'">[ View ]</button>
                        <button onclick="location.href = '${updateUrl}'">[ Update ]</button>
                        <button onclick="this.disabled = true; post('${deleteUrl}')">Delete</button>
                    </c:forEach>
        </table>
    </body>
</html>