<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="padding-top: 40px;">
	<div>
	<p style="font-size:50px;">${member.stu_num}</p>
	<hr>
	<p style="text-align:right;"><span class="badge">${like}</span>&nbsp;<a href="<c:url value='/member/like/${member.u_id}'/>"><span class="glyphicon glyphicon-thumbs-up"></span></a>&nbsp;&nbsp; 
	<a href="<c:url value='/message/${member.stu_num}'/>"><span class="glyphicon glyphicon-envelope"></span></a></p>
	</div>
</div>

<div class="row" style="margin-top:40px">
	<div class="col-md-6">
	<table class="table table-hover">
		<thead>
		<tr><th colspan="2">판매글</th></tr>
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
	
	<div class="col-md-6">
	<table class="table">
		<thead>
		<tr><th colspan="2">후기</th></tr>
		</thead>
		<tbody>
	<c:forEach var="r" items="${review}"> 
		<tr>
			<td>${r.stu_num}</td>
			<td> ${r.review.content}<br><font size="1" style="margin-top: 10px; text-align:right;">${r.review.r_date}</font></td>
			</tr> 
	</c:forEach>
	</tbody>
	</table>
	</div>
</div>
