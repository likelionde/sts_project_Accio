<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 가입</title>
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
		<label>회원가입</label><hr>
	</div>
	<form:form commandName="UserForm" method="post">
	<table>
	<tr>
		<td style="width: 40%;"><label for="stu_num">학번</label></td>
		<td><form:input type="text" path="user.stu_num" /><br>
			<form:errors path="user.stu_num"/><br/></td>
	</tr>
	<tr>
		<td style="width: 40%;"><label for="pwd">비밀번호</label></td>
		<td><form:input type="password" path="user.pwd"/><br>
			<form:errors path="user.pwd"/><br/></td>
	</tr>
	<tr>
		<td style="width: 40%;"><label for="confirmPassword">비밀번호 확인</label></td>
		<td><form:input type="password" path="confirmPassword" /><br>
			<form:errors path="confirmPassword"/> <br/></td>
	</tr>
		</table>
		<div style="margin-top: 30px;">
    <input type="submit" value="가입" class="btn send"/>
    </div>
	</form:form>
	

	</div>
</div>
</body>
</html>