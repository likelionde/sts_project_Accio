<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>판매글 수정</title>
<style>
	.saleform {
		margin: 40px;
		width: 570px;
		height: 80%;
		border: 1px solid black;
		box-shadow: 10px 10px 0px #00BCD4;
		
	}
	input[type=text] {
   	    border: none;
    	border-bottom: 1px solid #000000;
    	width:100%;
	}
	input[type=number] {
		border: none;
    	border-bottom: 1px solid #000000;
    	width:95%;	
	}
	.box {
		padding: 30px;
		margin-left: 10px;
		text-align: left;
	}
	input[type=submit] {
		width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	}
	.btn:hover {
	    background-color: #00BCD4;
	}
	.textarea {
		border-top: 0px;
		border-left: 0px;
		border-right: 0px;
		border-bottom: 1px solid #000000;
	}
</style>
</head>
<body>
<div align="center">
<div style="margin-top:40px;">
	<img src="../../img/mc.jpg" />
</div>
<div class="saleform">
<form:form commandName="saleForm" method="post" enctype="multipart/form-data">
<div class="box">
<label for="title">제목</label>
<form:input type="text" path="title" value="${saler.title}"/>
<form:errors path="title"/> <br/>
</div>

<div class="box">
<label for="price">가격</label>
<form:input type="number" path="price" value="${saler.price}"/>원
<form:errors path="price"/><br/>
</div>

<div class="box">
<label for="pwd">거래 방법</label>&nbsp;&nbsp;

<c:choose>
	<c:when test="${saler.transport eq '직거래'}">
	<form:radiobutton path="transport" value="직거래" checked="checked" />직거래&nbsp;&nbsp;
	<form:radiobutton path="transport" value="택배" />택배<br/>
	</c:when>
	<c:otherwise>
	<form:radiobutton path="transport" value="직거래"/>직거래&nbsp;&nbsp;
	<form:radiobutton path="transport" value="택배"  checked="checked" />택배<br/>
	</c:otherwise>
</c:choose>
<form:errors path="transport"/><br/>
</div>
<div class="box">
<label for="pwd">내용</label>
<textarea id="content" name="content" rows="10" cols="50">${saler.content}</textarea><br/>
<form:errors path="content"/><br/>
</div>

<input type="file" name="file"/><br/> 

<input type="submit" value="글쓰기" class="btn"/>

</form:form>
</div>
</div>
</body>

</html>