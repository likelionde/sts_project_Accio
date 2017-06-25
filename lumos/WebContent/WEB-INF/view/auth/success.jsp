<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
	.send {
	 	width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	}
	.send:hover {
	    background-color: #00BCD4;
	}
	</style>
</head>
<body>
<div align="center">
	<div style="margin-top: 100px;">
	<img src="../img/s.jpg" />
	<div style="margin: 30px; font-size: 25;" >
		<label>인증 성공</label>
		</div>
		<div style="margin: 30px;" >
		<a href="<c:url value='/sale/salelist.do'/>"
		   class="btn send">홈으로 가기</a>

		</div>
	</div>
</div>
</body>
</html>