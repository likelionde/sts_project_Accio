<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
  <html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value='/sale/salelist.do' />"><img src="<c:url value='/img/accio.gif'/> " width="100"></a>
    </div>
    <%-- <ul class="nav navbar-nav">
      <li><a href="<c:url value='/member/list.do'/>">회원 목록</a></li> <!-- 없어도 되는 기능 -->
    </ul> --%>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${empty sessionScope.loginSession}">
      <li><a href="<c:url value='/member/regist.do'/>"><span class="glyphicon glyphicon-plus"></span></a></li>
      <li><a href="<c:url value='/member/login.do'/>"><span class="glyphicon glyphicon-log-in"></span></a></li>
    </c:if>
    <c:if test="${not empty sessionScope.loginSession}">
    	<li><a href="<c:url value='/member/mypage.do'/> "><span class="glyphicon glyphicon-user"></a></li>    	
		<li><a href="<c:url value='/chat.do' />" ><span class="glyphicon glyphicon-comment"></span></a></li>
		<li><a onClick='return myMessage("로그아웃 되었습니다.");'href="<c:url value='/member/logout.do'/> "><span class="glyphicon glyphicon-log-out"></span></a></li>
	</c:if>
    </ul>
  </div>
</nav>

</body>
</html>