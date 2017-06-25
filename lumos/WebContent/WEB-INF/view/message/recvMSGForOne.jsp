<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>받은메일</title>
<style>
	.title {
		margin: 40px;
		border: 1px 1px 1px 0px solid #969696;
	}
	.content {
		padding: 10px;
		box-shadow: 10px 10px 0px #00BCD4;
		border: 1px solid black;
		width: 600px;
		height: 240px;
	}
	.send {
	 	width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	 	margin-top: 30px;
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
	    	<img src="../../img/m1.jpg"/><br>
	    	Message
	    	<hr>
	   	</div>
	   	<div>
	   	'${msg.send_user}' 님이 보낸 메세지<br><br>
	   		<font size="2">${msg.m_date}</font><br><br>
	   	</div>
	   	<div class="content">
	   	<div style="margin-top: 20px"> 
	   	${msg.contents }
	   	</div>
	   	</div>
	   	<c:choose>
	   		<c:when test="${msg.send_user eq '알수없음'}">
	   		<div class="btn send">
	   		  탈퇴한 회원
	   		  </div>
	   		</c:when>
	   		<c:when test="${msg.send_user eq 'admin' }">
	   		 
	   		</c:when>
	   		<c:otherwise>
	   		<div class="btn send">
	   			<a href="<c:url value='/message/${msg.send_user}'/>"><font color="#ffffff">답장</font></a>
	   			</div>
	   			
	   		</c:otherwise>
	   		
	   	</c:choose>
	   	<div class="btn send">
	   			<a href="<c:url value='/message/box/${msg.rec_user}'/>"><font color="#ffffff">메세지함</font></a>
	   		</div>
	   </div>
	</div>
</div>

</body>
</html>