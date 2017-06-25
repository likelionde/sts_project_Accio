<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div style="margin:10% auto; width:55%;">
<table class="table table-hover">
	<thead>
	<tr><th colspan="2">나의 판매글</th></tr>
	</thead>
	<tbody>
	<c:forEach var="mi" items="${sales}"> 
	<tr>
	<td><a href="<c:url value='/sale/saler/${mi.s_id }'/>"> ${mi.title }</a></td>
	<td>${mi.s_date}</td></tr>
	</c:forEach>
	</tbody>
</table>
</div>