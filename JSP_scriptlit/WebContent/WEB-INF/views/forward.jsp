<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>	    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="<%=request.getContextPath()%>/js/jquery-3.6.0.min.js"></script>
</head>
<body>

	<h3> 아이디: <%=request.getAttribute("id") %></h3>
	<h3> 패스워드: <%=request.getAttribute("pwd") %></h3>

</body>
</html>
