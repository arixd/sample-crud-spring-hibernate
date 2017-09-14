<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${userForm['new']}">
                <h1>Add User</h1>
            </c:when>
            <c:otherwise>
                <h1>Update User</h1>
            </c:otherwise>
        </c:choose>
        <br/>
        <spring:url value="/users" var="userActionUrl"/>
        <f:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">
            <f:hidden path="id"/>

            <spring:bind path="name">
                <label>Name</label>
                <f:input path="name" type="text" id="name" placeholder="name"/>
                <f:errors path="name"/>
            </spring:bind>

            <spring:bind path="email">
                <label>Email</label>
                <f:input path="email" id="email" placeholder="email"/>
                <f:errors path="email"/>
            </spring:bind>

            <spring:bind path="password">
                <label>Password</label>
                <f:input path="password" type="password" id="password" placeholder="password"/>
                <f:errors path="password"/>
            </spring:bind>


            <spring:bind path="confirmPassword">
                <label>confirm Password</label>
                <f:input path="confirmPassword" type="password" id="password" placeholder="password"/>
                <f:errors path="confirmPassword"/>
            </spring:bind>

            <spring:bind path="address">
                <label>Address</label>
                <f:textarea path="address" rows="5" id="address" placeholder="address" />
                <f:errors path="address"/>
            </spring:bind>

            <spring:bind path="newsletter">
                <label>Newsletter</label>
                <f:checkbox  path="newsletter" rows="5" id="newsletter" placeholder="newsletter" />
                <f:errors path="newsletter"/>
            </spring:bind>

            <spring:bind path="framework">
                <label>Web Frameworks</label>
                <f:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" />
                <f:errors path="newsletter"/>
            </spring:bind>
            <spring:bind path="sex">
                <label>Sex</label>
                <label><f:radiobutton path="sex" value="M"/>Male</label>                
                <label><f:radiobutton path="sex" value="F"/>Famale</label>
                <f:errors path="sex"/>
            </spring:bind>

            <spring:bind path="country">
                <label>Country</label>
                <f:select path="country">
                    <f:option value="NONE" label="---Select---"/>
                    <f:options items="${countryList}"/>
                </f:select>
                <f:errors path="country"/>
            </spring:bind>

            <spring:bind path="skill">
                <label>Java Skil</label>
                <f:select path="skill">
                    <f:option value="NONE" label="---Select----"/>
                    <f:options items="javaSkillList"/>
                </f:select>
                <f:errors path="skill"/>
            </spring:bind>

            <c:choose>
                <c:when test="${userForm['new']}">
                    <button type="submit">Add</button>
                </c:when>
                <c:otherwise>
                    <button type="submit">Update</button>
                </c:otherwise>
            </c:choose>

        </f:form>
    </body>
</html>