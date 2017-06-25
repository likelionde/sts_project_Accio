<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Message 보내기</title>
	<style>
	.title {
		margin: 40px;
		border: 1px 1px 1px 0px solid #969696;
	}
	.formtext {
		margin: 20px;
	}
	.text {
    	border: 1px solid #888;
    	box-shadow: 10px 10px 0px #00BCD4;
	}
	.box {
		padding: 10px;
	}
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
<div class="container" align="center">
	<div class="row">
	<div class="box col-md-12">
	    <div class="title">
	    	<img src="../img/m1.jpg"/><br><br>
	    	Message 보내기
	    	<hr>
	   	</div>
	   	
			<div class="name">
				To.&nbsp; ${user.stu_num} 
			</div>
			<div class="formtext">
				<form:form commandName="messageForm" method="post">
				<form:textarea type="text" path="contents" rows="10" cols="50" class="text"/>
				<form:errors path="contents"/> <br/>
                <div style="margin-top: 20px;">
					<input type="submit" class="btn send" value="보내기"/>	
				</div>
				</form:form>
			</div>
		</div>
	</div>
</div>
</body>
</html>