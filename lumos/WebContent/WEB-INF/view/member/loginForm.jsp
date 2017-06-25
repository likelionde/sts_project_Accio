<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>LOGIN</title>
<style>
	.box {
		margin: 20px;
	}
	.send {
	 	width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	}
	.send:hover {
	    background-color: #00BCD4;
	}
	tr {
		width: 100%;
		height: 50px;
		padding: 10px;
	}
	input {
		height: 40px;
		font-family: sans-serif;
	}
	

</style>
</head>
<body>
<div align="center">
	<div style="margin-top: 60px; text-align: left:">
	<div  style="margin-top: 30px;">
		<label>로그인</label><hr>
	</div>
	<form:form commandName="loginForm" method="post">
	<table>
	<tr>
		<td style="width: 40%;"><label for="stu_num">아이디</label></td>
		<td><form:input type="stu_num" path="stu_num"/><br>
			<form:errors path="stu_num"/> <br/></td>
	</tr>
	<tr>
		<td style="width: 40%;"><label for="pwd">암호</label></td>
		<td><form:input type="password" path="pwd"/><br>
			<form:errors path="pwd"/> <br/></td>
	</tr>
	</table>
	<div style="margin-top: 30px;">
		<input type="submit" value="로그인" class="btn send" />
		</div>

</form:form>
</div>
</div>
</body>
</html>