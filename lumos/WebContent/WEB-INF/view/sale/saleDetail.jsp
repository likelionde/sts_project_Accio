<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div style="margin:10% auto; width:55%;">
<table class="table">
	<thead>
	<tr><th colspan="2">${saler.title}</th></tr>
	</thead>
    <tbody>
    <tr>
    	<td>작성자</td>
    	<td>
    	<c:choose>	
    	<c:when test="${saler.user.u_id == sessionScope.loginSession.u_id}">
    	${saler.user.stu_num}
    	</c:when>
    	<c:otherwise>
    	<a href="<c:url value='/member/detail/${saler.user.u_id}'/> ">${saler.user.stu_num}</a>
    	</c:otherwise></c:choose>
    	</td>
    </tr>
    <tr>
    	<td>작성 날짜</td>
    	<td>${saler.s_date}</td>
    </tr>
    <tr>
    	<td>가격</td>
    	<td>${saler.price}원</td>
    </tr>
    <tr>
    	<td>거래방법</td>
    	<td>${saler.transport}</td>
    </tr>
    <tr>
    	<td colspan="2">
		<c:if test="${!empty saler.img}">
			<center><img src="../../image/${saler.img}" width="500px;"></center><br/>
		</c:if>
		${saler.content}<br/>

    	</td>
    </tr>
    

    <c:choose>	
	    <c:when test="${saler.user.u_id == sessionScope.loginSession.u_id}">
	    <tr>
	    	<td></td>
	    	<td style="text-align:right;"> <a href="<c:url value='/sale/saleModify/${saler.s_id}'/> ">수정</a>
	    	&nbsp;&nbsp;&nbsp;<a href="<c:url value='/sale/saleDestroy/${saler.s_id}'/> ">삭제</a></td>
	    </tr>
	    	
		</c:when>
		
		<c:otherwise>
	    <tr>
	     
	    	<td colspan="2" style="text-align:right;">
	    	
	    	<c:choose>
	    	<c:when test="${saler.flag == 0 }">
	    	<a onClick='return myMessage("구매요청이 전송되었습니다.");' href="<c:url value='/request/${saler.s_id}/${sessionScope.loginSession.u_id }'/> ">구매요청</a>
	    	&nbsp;&nbsp;<a href="<c:url value='/pick/${saler.s_id}'/> ">찜하기</a>
	    	
	    	<c:choose>
			<c:when test="${pick eq 1}">
			 <span class="glyphicon glyphicon-heart"></span>
			</c:when>
			<c:otherwise>
			<span class="glyphicon glyphicon-heart-empty"></span>
			</c:otherwise>
			</c:choose>
			
			</c:when>

		  <c:otherwise>
		  		<label>판매 완료</label>
		  </c:otherwise>
		</c:choose>
		</td>
	    </tr>
	    </c:otherwise>
	</c:choose>
    </tbody>
</table>


<!-- 거래요청 테이블 -->
<c:if test="${saler.user.u_id == sessionScope.loginSession.u_id}">
<br><br>
<table class="table">
<thead>
	<tr><th colspan="2">거래요청 List</th></tr>
</thead>
	<tbody>
	<c:forEach var="r" items="${requests}"> 
	    	<tr><td>${r.user.stu_num}님이 거래를 요청하셨습니다!</td>
	      		<td><a onClick='return myMessage("거래가 수락되었습니다.");'href="<c:url value='/request/success/${r.req_id}'/>">수락 </a>&nbsp;&nbsp;&nbsp;
	      		 <a onClick='return myMessage("거래가 거절되었습니다.");' href="<c:url value='/request/deny/${r.req_id}'/>">거절 </a></td>
	      	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>
</div>
</body>
</html>