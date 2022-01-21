<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${not empty spec}">
        <c:set var="name" value="${spec.name}"/>
        <c:set var="uzk" value="${spec.uzk}"/>
        <c:set var="amount" value="${spec.amount}"/>
        <c:set var="salary" value="${spec.salary}"/>
    </c:when>
    <c:otherwise>
        <c:set var="name" value=""/>
        <c:set var="uzk" value=""/>
        <c:set var="amount" value=""/>
        <c:set var="salary" value=""/>
    </c:otherwise>
</c:choose>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Редактирование/добавление специальности</TITLE>
    </HEAD>
    <BODY>
        <FORM action="saveSpec.html" method="post">

            <c:if test="${not empty spec}">
                <INPUT type="hidden" name="id" value="${spec.id}">
            </c:if>

            <P>Название специальности:</P>

            <INPUT type="text" name="name" value="${spec.name}">

            <P>Узконаправленная(y/n):</P>

            <INPUT type="text" name="uzk" value="${spec.uzk}">

           	<P>Количество врачей:</P>
           	
           	<INPUT type="date" name="amount" value="${spec.amount}">
           	
           	<P>Ставка зп:</P>
           	
           	<INPUT type="date" name="salary" value="${spec.salary}">
           	
            <BUTTON type="submit">Сохранить</BUTTON>
            <A href="index.html">Назад</A>
        </FORM>
   </BODY>
</HTML>