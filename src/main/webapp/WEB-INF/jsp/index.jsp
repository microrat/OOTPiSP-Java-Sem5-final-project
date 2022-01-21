<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pack.*" %>
<%@page import="java.util.Collection" %>

<% 
@SuppressWarnings("unchecked")
Collection<Spec> specList = (Collection<Spec>)request.getAttribute("specList"); 

%>

<HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>SPEC</TITLE>
        <STYLE>
            TABLE {
                border-collapse: collapse;
            }
            TH, TD {
                border: 1px solid black;
                padding: 5px 30px 5px 10px;
            }
        </STYLE>
    </HEAD>
    <BODY>
      <c:choose>
            <c:when test="${not empty user}">
                ${user.login}&nbsp;&mdash; <A href="logout.html">выйти</A>
            </c:when>
            <c:otherwise>
                <A href="login.jsp">войти</A>
            </c:otherwise>
        </c:choose>
        <c:if test="${user.role=='reg'}">
        <FORM action="deleteSpec.html" method="post">
      	</c:if>
            <TABLE>
                <TR>              
                    <c:if test="${user.role=='reg'}"><TH>Удалить</TH></c:if>
                    <c:if test="${user.role=='reg'}"><TH>Редактировать</TH></c:if>
                    <TH>Просмотреть врачей</TH>
                    <TH><A href="sortSpec.html?field=name">Специальность</A></TH>
                    <TH><A href="sortSpec.html?field=uzk">Узконаправленная(y/n)</A></TH>
                    <TH><A href="sortSpec.html?field=amount">Количество врачей</A></TH>
                    <TH><A href="sortSpec.html?field=salary">Ставка зп</A></TH>
                    <TH><A href="sortSpec.html?field=costs">Общие затраты на оплату труда</A></TH>
                </TR>
                <% for(Spec item : specList){ %>
                    <TR>
                      	<c:if test="${user.role=='reg'}">
	                        <TD><INPUT type="checkbox" name="id" value="<%= item.getId() %>"></TD>
                        </c:if>
                        <c:if test="${user.role=='reg'}">
	                        <TD><A href="editSpec.html?id=<%= item.getId() %>"> <%= item.getId() %></A></TD>
                        </c:if>
                        <TD><A href="indexDoc.html?id=<%= item.getId() %>">просмотр</A></TD>                      
                        <TD><%= item.getName() %></TD>
                        <TD><%= item.getUzk() %></TD>
                        <TD><%= Storage.getCountAmount(item.getId()) %></TD>
                        <TD><%= item.getSalary() %></TD>
                        <TD><%= item.getCosts() %></TD>        
                    </TR>
                <%
                }
                %>
            </TABLE>
       		<c:if test="${user.role=='reg'}">
            <P>
                <A href="editSpec.html">Добавить</A>
                <BUTTON type="submit">Удалить</BUTTON>
            </P>
            </c:if>
        </FORM>
       
      
      <c:if test="${user.role == 'admin'}">           
            <FORM action="deleteUser.html" method="post">
                <TABLE>
                    <TR>
                        <TH>Удалить</TH>
                        <TH>Роль</TH>
                        <TH>Логин</TH>
                        <TH>Пароль</TH>
                    </TR>
                    <c:forEach var="user" items="${usrs}">
                        <TR><TD><INPUT type="checkbox" name="id" value="${user.id}"></TD>                       
                            <TD><A href="editUser.html?id=${user.id}">${user.role}</A></TD>
                            <TD>${user.login}</TD>
                            <TD>${user.password}</TD>
                        </TR>
                    </c:forEach>
                </TABLE>
                <P>
                    <A href="editUser.html">Добавить Пользователя</A>
                    <BUTTON type="submit">Удалить</BUTTON>
                </P>
            </FORM>
            
        </c:if>
      
      
      
    </BODY>
</HTML>