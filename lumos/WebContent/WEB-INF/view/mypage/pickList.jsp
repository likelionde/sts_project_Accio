<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div style="margin:10% auto; width:55%;">
<table class="table table-hover">
	<thead>
	<tr><th colspan="2">내가 찜한 글</th></tr>
	<tr><th>제목</th><th>작성일</th></tr>
	</thead>
	<tbody>
	
	<c:forEach var="pick" items="${picks}"> 
	<tr>
	<td><a href="<c:url value='/sale/saler/${pick.sale.s_id}'/>"> ${pick.sale.title}</a></td>
	<td>${pick.sale.s_date}</td>
	</c:forEach>
	</tbody>
</table>
</div>
