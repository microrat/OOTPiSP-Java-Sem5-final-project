<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="pack.*" %>
<%@page import="java.util.Collection" %>


<%
@SuppressWarnings("unchecked")
Collection<Doc> docList = (Collection<Doc>)request.getAttribute("docList");
Spec spec = Storage.readByIdSpec((Integer)request.getAttribute("id"));
%>
 <HTML>
    <HEAD>
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <TITLE>Doctors</TITLE>
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
        <c:if test="${user.role=='reg'}">
        <FORM action="deleteDoc.html?id=<%=spec.getId() %>" method="post">
        </c:if>
            <TABLE>
                <TR>  
                    <c:if test="${user.role=='reg'}"><TH>Удалить</TH></c:if>
                    <c:if test="${user.role=='reg'}"><TH>Специальность</TH></c:if>
                    <TH><A href="sortDoc.html?field=fio&id=<%=spec.getId() %>">ФИО</A></TH>
                    <TH><A href="sortDoc.html?field=bday&id=<%=spec.getId() %>">ДР</A></TH>
                    <TH><A href="sortDoc.html?field=hiring&id=<%=spec.getId() %>">Прием на работу</A></TH>
                    <TH><A href="sortDoc.html?field=number&id=<%=spec.getId() %>">Участок</A></TH>
                    <TH><A href="sortDoc.html?field=payment&id=<%=spec.getId() %>">Зарплата</A></TH>                    
                </TR>
                <%
                for(Doc doctor : docList){
                %>
                    <TR>
                         <c:if test="${user.role=='reg'}"><TD><INPUT type="checkbox" name="ids" value="<%=doctor.getId() %>"></TD></c:if>
                         <c:if test="${user.role=='reg'}"><TD><A href="editDoc.html?id=<%=doctor.getId() %>"><%=spec.getName() %> </A></TD></c:if>
                         <TD><%=doctor.getFio() %></TD>
                         <TD><%=doctor.getBday() %></TD>
                         <TD><%=doctor.getHiring() %></TD>
                      
                        <% if(doctor.getNumber()>0){ %>
			<TD><%=doctor.getNumber() %></TD>
			<% }else{ %>
			<TD>Нет участка</TD>
				<%} %>
                         
                         <%
                        doctor.setPayment();
                         %>                       
                        <TD><%=doctor.getPayment() %></TD>
                    </TR>
                <%
                }
                %>
            </TABLE>
        <c:if test="${user.role=='reg'}">
            <P>
                <A href="editDoc.html?idSp=<%= spec.getId() %>">Добавить</A>
                <BUTTON type="submit">Удалить</BUTTON>
            </P>
        </FORM>
        <A href="index.html">Назад</A>
         </c:if>
    </BODY>
</HTML>