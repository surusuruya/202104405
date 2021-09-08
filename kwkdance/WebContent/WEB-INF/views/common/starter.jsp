<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>	    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>김원경 무용단</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#btn").on({
		"mouseover" : function(){
			$("#bg").removeClass("hide");
			$("#bg").addClass("show");
			$("#btn").css({
				"background-color" : "white",
				"color" : "black",
				"font-weight" : "bold"
			});
		},
		"mouseout" : function(){
			$("#bg").removeClass("show");
			$("#bg").addClass("hide");
			$("#btn").css({
				"background-color" : "#1e1f1d",
				"color" : "#e0e0e0",
				"font-weight" : "normal"
			});
		}
	});
});




</script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/nanumbrushscript.css);
@import url(http://fonts.googleapis.com/earlyaccess/nanumpenscript.css);
@import url(http://fonts.googleapis.com/earlyaccess/jejumyeongjo.css);
@-webkit-keyframes fadein { /* Safari and Chrome */
    from {
        opacity: 0;
    }
    to {
        opacity: 0.7;
    }
}
.show {
/*   display : block; */
  animation: fadein 1s;
  -webkit-animation: fadein 1s; /* Safari and Chrome */
}
.hide {
  display : none;
}
html {
  margin : 0;
  padding : 0;
}
body {
  padding : 0;
  margin : 0;
}
#img {
  width : 1920px;
  position:fixed;
  background-color : black;
  background-size : cover;
  opacity : 0.8;
  z-index : -1;
}
#title {
  position:absolute;
  left : 1300px;
  top : 800px;
  font-family: 'Nanum Brush Script', serif;
  color : white;
  font-size : 80px;
/*   font-weight : bold; */
  margin : 0;
  width : 308px;
  height : 92px;
}
#btn {
  width : 132px;
  height : 37px;
  background-color : #1e1f1d;
  border-radius : 6px;
  padding : 12px 16px;
  position:absolute;
  left : 890px;
  top : 300px;
  cursor : pointer;
  color : #e0e0e0;
  border : none;
  font-family: 'Jeju Myeongjo', serif;
  font-size : 13px;
}
#bg {
  width : 1920px;
  height : 1056px;
  background-color : black;
  opacity : 0.7;
  z-index : -1;
}
/* 애니메이션 */
</style>
</head>
<body>

  <div class="item">
    <img id="img" src="<%=request.getContextPath() %>/resources/images/ballet-3174227_1920.jpg">
    <p id="title">김원경 무용단</p>
    <div id="bg" class="hide"></div>
    <button id="btn" onClick="location.href='main.jsp'">홈페이지 방문하기</button>
  </div>
  
</body>
</html>