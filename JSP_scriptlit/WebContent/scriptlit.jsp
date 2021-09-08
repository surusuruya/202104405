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

	<%
		for(int dan=2; dan<10; dan++){
	%>
<%-- 	<%out.println("<h3>" + dan + "단 입니다. </h3>");%> --%>
	<h3> <%=dan%> </h3>
	<%
			for(int gop=1; gop<10; gop++){
	%>
<%-- 	<%out.println("<p>" + dan + " * " + gop + " = " + dan*gop + "</p>");%> --%>
	<p> <%=dan %> * <%=gop %> = <%=dan*gop %></p>
	<%
			}
	%>

<%-- 	<%		out.println("<br/>");%> --%>
	<br>
	<%
		}	
	%>

</body>
</html>