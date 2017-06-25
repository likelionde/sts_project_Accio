<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
	.review {
		border: 1px solid black;
		box-shadow: 10px 10px 0px #00BCD4;
	}
	.box {
		margin: 40px;
	}
	input[type=submit] {
		width: 100px;
	 	background-color: #000000;
	 	color: #ffffff;
	}
	.text {
		border: 0px solid #ffffff;
		}
</style>

<div align="center" style="margin:70px;">
	<div class="box"> 
		<label>REVIEW</label>
	</div>
	
	<form:form commandName="reviewForm" method="post">
	<div class="review box">
		<div class="box">
		<textarea rows="15" cols="60" class="text" id="content" name="content">${review.content}</textarea>
		</div>
		
		</div>
		<div class="box">
		<input type="submit" value="작성" class="btn"/>
		</div>
	</form:form>
	
</div>


