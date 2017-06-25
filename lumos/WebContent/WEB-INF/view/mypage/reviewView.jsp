<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰</title>
<style>
	.box {
		border-top: 1px solid #00BCD4;
		border-bottom: 1px solid #00BCD4;
		height: 55px;
		padding: 15px;
		text-align:center;
	}
	.message {
		background-color: #ffffff;
		padding: 15px;
		width: 70%;
		text-align:left;
		border-bottom: 1px solid #E7E7E7;
	}
</style>
 <script>
 $(function () {
	// Hide all elements which id starts with text.
	$("[id^=text]").hide();
	$("#img").show();

	$(".button").click(function () {
		$("[id^=text]").hide();
		$("#text" + $(this).data("rel")).toggle();
		/* $("#img").hide(); */
	});
	});
 </script>
</head>
<body>
<div style="text-align:center;">
<div id="img" style="margin-top: 20px;">
<img src="../img/r.jpg" />
</div>
<div class="row" style="text-align: center; margin-top: 30px; ">
	<div class="box">
		<div class="col-md-6 col-sm-6 col-xs-6 button" data-rel="1"><a href="#">내가쓴 후기</a></div>
		<div class="col-md-6 col-sm-6 col-xs-6 button" data-rel="2"><a href="#">나에대한 후기</a></div>
	</div>
</div>

<div id="text1" align="center">
<br>
	<c:forEach var="r" items="${My}"> 
	<div class="message">
		<div style="margin-bottom:30px">
			<font size="2">- ${r.sStuNum} 판매자 -</font><br>
		</div>
		<div>
			${r.review.content}
			<br><br>
		</div>
		<div style="text-align:right;">
			<font size="2">${r.review.r_date} </font>&nbsp;
			<a href="<c:url value='/reviewModify/${r.review.r_id}'/>">
			<font size="2">수정</font></a>
			<a href="<c:url value='/reviewDelete/${r.review.r_id}'/>">
			<font size="2">삭제</font></a>
		</div>
	</div><br>
	</c:forEach>
</div>

<div id="text2" align="center">
<br>
 	<c:forEach var="r" items="${aboutMe}"> 
	<div class="message">
		<div style="margin-bottom:30px">
			<font size="2">- ${r.stu_num} 님이 쓴 후기-</font><br>
		</div>
		<div>
			${r.review.content}
			<br><br>
		</div>
		<div style="text-align:right;">
			<font size="2">${r.review.r_date} </font>
		</div>
	</div><br>
	</c:forEach>
	
</div>

</div>
</body>
</html>