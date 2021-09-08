<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>	    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script>
	alert("게시글이 삭제되었습니다.\n 공지사항 페이지로 이동합니다.");
	
	window.onload=function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/getMcode.do?mName=공지목록",
			type:"get",
			success:function(menu){
				window.opener.parent.location.href="/index.do?mCode="+menu.mcode;
				window.close();
			}
		});
		
	}
</script>
</body>
</html>