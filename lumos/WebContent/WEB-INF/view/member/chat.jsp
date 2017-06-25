<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	var wsocket;
	
	function connect() {
		wsocket = new WebSocket("ws://localhost:8080/chat/chat-ws");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	function disconnect() {
		var nickname = $("#nickname").val();
		wsocket.send("msg:--"+nickname+" 퇴장--<br>");
		wsocket.close();
	}
	function onOpen(evt) {
		var nickname = $("#nickname").val();
		wsocket.send("msg:--"+nickname+" 입장--<br>");
	}
	function onMessage(evt) {
		var data = evt.data;
		if (data.substring(0, 4) == "msg:") {
			appendMessage(data.substring(4));
		}
	}
	function onClose(evt) {
		appendMessage("연결을 끊었습니다.");
	}
	
	function send() {
		var nickname = $("#nickname").val();
		var msg = $("#message").val();
		wsocket.send("msg: "+nickname+">&nbsp;&nbsp;" + msg);
		$("#message").val("");
	}

	function appendMessage(msg) {
		$("#chatMessageArea").append(msg+"<br>");
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}

	$(document).ready(function() {
		$('#message').keypress(function(event){
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13'){
				send();	
			}
			event.stopPropagation();
		});
		$('#sendBtn').click(function() { send(); });
		$('#enterBtn').click(function() { connect(); });
		$('#exitBtn').click(function() { disconnect(); });
	});
</script>
<style>
	#chatArea {
		width: 80%; height: 350px; overflow-y: auto; border: 1px solid black;
		box-shadow: 10px 10px 0px #00BCD4;
		text-align: left;
		padding:20px;
	}
	.btn2 {
		width: 70px;
		background-color: black;
		color: #ffffff;
	}
	.btn2:hover {
	    background-color: #00BCD4;
	}
	input[type=text] {
		width: 70%;
		height: 35px;
	}
</style>
</head>
<body>
<div align="center">
	<div style="margin: 30px;">
	  <div style="margin-bottom: 40px;">
	  	<label>CHAT</label>
	  </div>
	<input type=hidden id="nickname" value="${user.stu_num}">
	<input type="button" id="enterBtn" value="입장" class="btn btn2">
	<input type="button" id="exitBtn" value="나가기" class="btn btn2">
	<br/><br/>
	<div id="chatArea"><div id="chatMessageArea"></div></div>
    <br/>
    <div style="margin: 10px;">
    <input type="text" id="message">
    <input type="button" id="sendBtn" value="전송" class="btn btn2">
	</div>
	</div>
</div>
</body>
</html>