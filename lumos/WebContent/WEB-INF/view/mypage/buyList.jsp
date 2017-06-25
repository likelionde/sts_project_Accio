<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div style="margin:10% auto; width:55%;">

<table class="table table-hover">
	<thead>
	<tr><th colspan="2">구매목록</th></tr>
	</thead>
	<tbody>
	<c:forEach var="mi" items="${saleinfos}"> 
	<tr>
	<td><a href="<c:url value='/sale/saler/${mi.sale.s_id}'/>" >${mi.sale.title}</a></td>
	<td><a href="<c:url value='/review/${mi.user.u_id}/${mi.info_id }' />" >리뷰쓰기</a></td></tr>
	</c:forEach>
	</tbody>
</table>

</div>
