<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script>
function withDrawal() {

    if (confirm("탈퇴하시겠습니까?") == true) {
    	document.location.href="<c:url value='/withdrawal/${detail.stu_num}/${detail.u_id }'/>"
    } else {
    	document.location.href = "<c:url value='/sale/salelist.do' />";
    }
}
</script>
<div class="mypageForm" style="text-align:center; margin-top:10%;">
	<div class="row" style="margin:auto;width:50%;">
	 <div class="col-md-5" >
	  <label style="font-size:25px;">${detail.stu_num} 학우님♥</label>
		</div>
		<div class="col-md-7" style="text-align:right; padding:15px;">
		<c:if test="${detail.flag ==0 }">
	  <a href="<c:url value='/member/email/sendNumber.do'/>" class="label label-default">인증</a>
	  </c:if>
	  <a onclick="return withDrawal()"  class="label label-warning">탈퇴</a>
		</div>
	<br/><br/>
	<hr>
	
	<div style="margin-top:20;">

		<span class="btn btn-warning btn-circle btn-xl" style="padding-top: 58px;">좋아요<br><label>${detail.like_cnt}</label></span>
		<a href="<c:url value='/message/box/${detail.stu_num}'/>" class="btn btn-warning btn-circle btn-xl">메일함</a>
		<a href="<c:url value='/mypage/saleList.do'/>" class="btn btn-warning btn-circle btn-xl">나의 판매글</a><br>
		<a href="<c:url value='/mypage/pcikList.do'/>" class="btn btn-warning btn-circle btn-xl">내가 찜한 글</a>
		<a href="<c:url value='/mypage/buyList.do' />" class="btn btn-warning btn-circle btn-xl">나의 구매목록</a>
		<a href="<c:url value='/review/${detail.stu_num }' />" class="btn btn-warning btn-circle btn-xl">나의 리뷰</a>
	</div>
	</div>
</div>
