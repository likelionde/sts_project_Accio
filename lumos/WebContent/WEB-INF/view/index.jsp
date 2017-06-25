<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
 #search{
    border: 2px solid #00BCD4;;
     padding: 5px;
     margin: 5px;
     width: 540px;
 }
 #search td{
 	padding-top:5px;
 }
 .button {
    background-color: transparent !important;
    border-color: transparent;
    border: none;
 }
 .search {
     margin: 10px;
     width: 520px;
     height: 100px;
     font-size: 15px;
 }
 .tdset {
    width: 340px;
 }
 .tdset input {
    width: 95px;
 }
 .tdname {
    width: 120px;
    border-right: 1px solid #ddd;
 }
 .tdset checkbox {
    width: 10px;
 }
 
 </style>
 
</head>
<body>
<script>
function myFunction() {
    var x = document.getElementById('search');

    if (x.style.display === 'none') {
        x.style.display = 'block';
        $('#switch').removeClass('glyphicon-chevron-up');
        $('#switch').addClass('glyphicon-chevron-down');
        
    } else {
        x.style.display = 'none';
        $('#switch').removeClass('glyphicon-chevron-down');
        $('#switch').addClass('glyphicon-chevron-up');
    }
}
</script>

   <div class="row">
      <div class="col-ms-6 col-md-6"></div>
   <div id="search" class="col-ms-6 col-md-6" style="display:none">
	   <table class="search" >
	      <form:form commandName="conditionSearch" method="post">
	      <tr>
	          <td class="tdname">
	          제목
	       </td>
	       <td class="tdset">
	       <div style="margin-left: 40px;">
	         <form:input type="text" path="title"/>
	         </div>
	      </td>
	   </tr>
	   <tr>
	          <td class="tdname">
	         판매자
	       </td>
	       <td class="tdset">
	       <div style="margin-left: 40px;">
	         <form:input type="text" path="stu_num"/>
	         </div>
	      </td>
	   </tr>
	      <tr>
	          <td class="tdname">
	          거래방법
	       </td>
	       <td class="tdset">
	         <form:radiobutton value="직거래" path="transport"/>직거래&nbsp;
	         <form:radiobutton value="택배" path="transport"/>택배
	      </td>
	   </tr>
	   <tr>
	       <td class="tdname">
	         가격
	      </td>
	      <td class="tdset">
	      <div style="margin-left: 40px;">
	         <form:input type="text" path="priceStart" placeholder="0"  />원 ~ &nbsp;&nbsp;
	         <form:input type="text" path="priceEnd" placeholder="1000000" />원
	         </div>
	      </td>
	   </tr>
	   <tr>
	      <td class="tdname">
	             이미지 
	      </td>
	      <td class="tdset">
	         <form:checkbox value="img" path="img"/>
	      </td>
	   </tr>
	   <tr>
	      <td class="tdname">
	         판매자 좋아요순
	      </td>
	      <td class="tdset">
	         <form:checkbox value="like" path="like"/>
	      </td>
	      <td rowspan="3">
	         <button type="submit" class="button">
	         <span class="glyphicon glyphicon-search"></span>
	         </button>
	      </td>
	   </tr>
	   </form:form>
	   </table>
   </div>
</div>

   
   <p style="text-align:right">
   <a onclick="return myFunction();"><span id="switch" class="glyphicon glyphicon-chevron-up"></span></a>&nbsp;
   <a href="<c:url value='/sale/write.do'/> "><span class="glyphicon glyphicon-pencil"></span></a></p>

	<table class="table table-hover">
    <thead>
      <tr>
        <th>제목</th>
        <th>가격</th>
        <th>판매자</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="mi" items="${sales}"> 

      	<tr>
      	
        <td><a href="<c:url value='/sale/saler/${mi.s_id}'/> ">${mi.title}</a>
        <c:if test="${mi.flag==1 }">
        &nbsp;<label class="label label-danger" style="font-size:50%;">판매완료</label>
        </c:if></td>
        <td>${mi.price}원</td>
        <td>${mi.user.stu_num }</td>
      	</tr>
      </c:forEach>
    </tbody>
  </table>
