<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<style>
	.send {
	 	width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	}
	.send:hover {
	    background-color: #00BCD4;
	}
	input {
		width: 300px;
		height: 40px;
	}
</style>
<title></title>
</head>
<body>
<div align="center">
	<div style="margin-top: 100px;">
	<img src="../img/a.jpg" />
	<div style="margin: 30px;" >
		<a href="<c:url value='http://portal.dongduk.ac.kr/'/>"
		   style=" color: #00BCD4;"
		   target="_blank">동덕여대 포털</a> 메일에서 인증메일을 확인후 입력해주세요.
	</div>
		<form:form commandName="AuthenticationForm" method="post">
		<form:input type="text" path="number" placeholder="인증번호를 입력하세요" />
		<input type="submit" value="인증" class="btn send" />
		</form:form>
</div>
</div>
</body>
</html> 