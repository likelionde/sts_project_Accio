<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메세지함</title>
<style>
	.box {
		border-top: 1px solid #00BCD4;
		border-bottom: 1px solid #00BCD4;
		height: 55px;
		padding: 15px;
		text-align:center;
	}
	.message {
		background-color: #E7E7E7;
		padding: 15px;
		width: 70%;
		text-align:left;
	}
	.message2 {
		background-color: rgba(0,188,212,0.3);
		padding: 15px;
		width: 70%;
		text-align:left;
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
<img src="../../img/mm.jpg" />
</div>
<div class="row" style="text-align: center; margin-top: 30px; ">
	<div class="box">
		<div class="col-md-6 col-sm-6 col-xs-6 button" data-rel="1"><a href="#">받은 메세지</a></div>
		<div class="col-md-6 col-sm-6 col-xs-6 button" data-rel="2"><a href="#">보낸 메세지</a></div>
	</div>
</div>

<div id="text1" align="center">
	<br>
	<c:forEach var="m" items="${recv_m}"> 
		<div class="message">
       		<a href="<c:url value='/message/recv/${m.m_id}'/>">
       		<font size="2">보낸사람</font> ${m.send_user}</a><br>
       	</div>
       	<br>
	</c:forEach>
</div>


<div id="text2" align="center">
	<br>
	<c:forEach var="m" items="${send_m}"> 
	<c:set var="f" value="${m.flag}" />
	 <c:choose>
	  <c:when test="${f eq 1}">
		<div class="message2">
      	 		<a href="<c:url value='/message/send/${m.m_id}'/>">
                <font size="2">받는사람  </font>${m.rec_user} &nbsp;
      	 		<span class="glyphicon glyphicon-ok"></span>
      	 		</a><br>
		</div>
		<br>
	  </c:when>
	  <c:otherwise>
	  	<div class="message">
      	 		<a href="<c:url value='/message/send/${m.m_id}'/>">
      	 		<font size="2">받는사람  </font>${m.rec_user}</a><br>
		</div>
		<br>
	  </c:otherwise>
	 </c:choose>
	</c:forEach>
</div>
<hr>
</div>
</body>
</html>