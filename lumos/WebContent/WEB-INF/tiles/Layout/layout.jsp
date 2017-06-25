<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles"  uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"    uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ACCIO</title>

<!-- bootstrap -->
<link href="<c:url value="/bootstrap/css/lumos.css" />" rel="stylesheet" type="text/css">

<!-- font awesome -->
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
<div class="container" style="height:100%;">
 <table style="width: 100%; height:100%;">
      <tr style="height:5%">
        <td>
          <tiles:insertAttribute name="header" /><br>
        </td>
      </tr>
      <tr style="vertical-align: top;">
        <td>
          <tiles:insertAttribute name="content" /><br>
        </td>
      </tr>
      <tr style="height:5%">
        <td>
          <tiles:insertAttribute name="footer" /><br>
        </td>
      </tr>
    </table>
</div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/bootstrap/js/bootstrap.js" />"></script>
</body>
</html>