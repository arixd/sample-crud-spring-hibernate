<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        <spring:url value="/users" var="userActionUrl"/>        
        <table  style="background:#eee; width:100%; border-radius:5px;  border-collapse: collapse;" cellpadding="7px" border="0px";>
        <f:form class="form-horizontal" method="post" modelAttribute="userForm" action="${userActionUrl}">
            <f:hidden path="id"/>
            <tr><td>Name
                    <td><f:input path="name" type="text" id="name" placeholder="name"/>
                <tr><td colspan="2">
                        <f:errors path="name"/>
                <tr><td>Email
                    <td><f:input path="email" id="email" placeholder="email"/>
                <tr><td colspan="2"><f:errors path="email"/>
                <tr><td>Password
                    <td><f:input path="password" type="password" id="password" placeholder="password"/>
                <tr><td colspan="2"><f:errors path="password"/>
                <tr><td>Addres
                    <td><f:textarea path="address" id="address" placeholder="address"/>
                <tr><td colspan="2"><f:errors path="address"/>
                        
                <tr><td>News letter
                    <td> <f:checkbox path="newsletter" id="newsletter" />
                        
                <tr><td>Web Frameworks
                <td><f:checkboxes path="framework" items="${frameworkList}" element="label class='checkbox-inline'" />
                <tr><td colspan="2"><f:errors path="framework"/>
            
                <tr><td>Sex
                    <td><f:radiobutton path="sex" value="M" />Male
                    |<f:radiobutton path="sex" value="F" />   Famale
                <tr><td>Number
                    <td><f:radiobuttons path="number" items="${numberList}"/>
                <tr><td colspan="2"><f:errors path="number"/>
            
                <tr><td>Country
                    <td><f:select path="country">
                            <f:option value="None" label="---Select----"/>
                            <f:options items="${countryList}"/>
                        </f:select>
                <tr><td colspan="2"><f:errors path="country"/>
                        
                <tr><td>Java Skill
                    <td><f:select path="skill" items="${javaSkillList}" multiple="true" size="5"/>
                    <td><td><f:errors path="skill"/>
                <tr><td><input type="submit" value="Simpan"/>
            </f:form>
        </table>
    </body>
</html>