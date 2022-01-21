<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pack.*" %>
<%@page import="java.util.Collection" %>


<c:choose>
    <c:when test="${not empty doctor}">
        <c:set var="fio" value="${doctor.fio}"/>
        <c:set var="bday" value="${doctor.bday}"/>
        <c:set var="hiring" value="${doctor.hiring}"/>
        <c:set var="number" value="${doctor.number}"/>
        <c:set var="id_spec" value="${doctor.specId}"/>
    </c:when>
    <c:otherwise>
        <c:set var="id_spec" value="${idSp}"/>
        <c:set var="fio" value=""/>
        <c:set var="bday" value=""/>
        <c:set var="hiring" value=""/>
        <c:set var="number" value=""/>
    
       
    </c:otherwise>
</c:choose>


<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Edit</TITLE>
    </HEAD>
    <BODY>
        <FORM action="saveDoc.html?id_spec=${id_spec}" method="post">

            <c:if test="${not empty doctor}">
                <INPUT type="hidden" name="id" value="${doctor.id}">
            </c:if>

            <P>ФИО:</P>

            <INPUT type="text" name="fio" value="${fio}">

            <P>Дата рождения:</P>

            <INPUT type="text" name="bday" value="${bday}">
            
            <P>Дата приема на работу:</P>

            <INPUT type="text" name="hiring" value="${hiring}">
            
            <P>Номер участка(0 если участка нет):</P>

            <INPUT type="text" name="number" value="${number}">
			
         
           	
            <BUTTON type="submit">Сохранить</BUTTON>
            <A href="indexDoc.html?id=${id_spec}">Назад</A>
        </FORM>
   </BODY>
</HTML>