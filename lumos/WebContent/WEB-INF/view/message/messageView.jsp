<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
 	.box {
 		background-color: rgba(0,188,212,0.3);
 		border-radius: 50%;
 		width: 300px;
 		height: 300px;
 		margin-top: 200px;
 		padding: 50px;
 	}
 	.abtn {
 		background-color: #ffffff;
 	}
</style>
</head>
<body>
<div align="center">
	<div class="box">
		<div style="margin-top:25px;padding:30px;">
			메세지가 <br>전송되었습니다.
			</div>
		<div>
			<a href="<c:url value='/message/box/${sessionScope.loginSession.stu_num}'/>"
			   class="btn abtn">메세지함</a>
		</div>
	</div>
</div>
</body>
</html>