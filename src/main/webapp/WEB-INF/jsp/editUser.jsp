<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${not empty usr}">
        <c:set var="role" value="${usr.role}"/>
        <c:set var="password" value="${usr.password}"/>
        <c:set var="login" value="${usr.login}"/>
    </c:when>
    <c:otherwise>
        <c:set var="role" value=""/>
        <c:set var="password" value=""/>
        <c:set var="login" value=""/>
    </c:otherwise>
</c:choose>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Тест JSP</TITLE>
    </HEAD>
    <BODY>
        <FORM action="saveUser.html" method="post">

            <c:if test="${not empty usr}">
                <INPUT type="hidden" name="id" value="${usr.getId()}">
            </c:if>

            <P>Роль:</P>
            <INPUT type="text" name="role" value="${role}">

            <P>Логин:</P>
            <INPUT type="text" name="login" value="${login}">

            <P>Пароль:</P>
            <INPUT type="text" name="password" value="${password}">

            <BUTTON type="submit">Сохранить</BUTTON>
            <A href="index.html">Назад</A>
        </FORM>
   </BODY>
</HTML>