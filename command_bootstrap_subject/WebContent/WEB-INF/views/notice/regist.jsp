<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>공지사항등록</title>

<body>

	<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>공지사항등록</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">공지사항관리</i>
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	등록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
  	</section>
	<!-- Main content -->
	<section class="content register-page">
		<div class="register-box" style="width:90%;">
			<div class="login-logo">
    			<a href="<%=request.getContextPath()%>/notice/registForm.do"><b>공지사항등록</b></a>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body" style="width:90%; margin:0 auto 0; text-align:center;">
					<form role="form" class="form-horizontal" action="regist.do" method="post">						
						  <div class="form-group row">
							 <label for="tit" class="col-sm-2" style="font-size:0.9em;" >
							 	<span style="color:red;font-weight:bold;">*</span>제목</label>	
							<div class="col-sm-10 input-group-sm">
								<input class="form-control" name="title" type="text" id="title"
										placeholder="제목을 입력하세요" />
							</div>								
						</div>
						  <div class="form-group row">
							 <label for="wrt" class="col-sm-2" style="font-size:0.9em;" >작성자</label>	
							<div class="col-sm-10 input-group-sm">
								<input readonly class="form-control" name="writer" value="${loginUser.id }" id="writer" />
							</div>								
						</div>
						<div class="form-group row">
							<label for="name" class="col-sm-2" style="font-size:0.9em;">
								<span style="color:red;font-weight:bold;">*</span>내용</label>
							<div class="col-sm-10 input-group-sm">
								<textarea class="form-control" rows="15" cols="60" name="content" id="content" style="resize: none;"></textarea>								
							</div>
							
						</div>		
						
						<div class="card-footer" style="width:300px; margin:0 auto 0;" >
							<div class="row">								
								<div class="col-sm-6">
									<button type="button" id="registBtn" onclick="regist_go();" class="btn btn-info">등록하기</button>
							 	</div>
							 	
							 	<div class="col-sm-6">
									<button type="button" id="cancelBtn" onclick="CloseWindow();"
										class="btn btn-default float-right">&nbsp;&nbsp;&nbsp;취 &nbsp;&nbsp;소&nbsp;&nbsp;&nbsp;</button>
								</div>
							
							</div>
						</div>
					</form>					
				</div><!-- register-card-body -->
			</div>
		</div>
	</section>		<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<form id="noticeForm">
	<input type='hidden' name="title" value="" />
	<input type='hidden' name="writer" value="" />
	<input type='hidden' name="content" value="" />
</form>

<script>
function regist_go(url){
	if(!url) url="registCom.do";
	
	var jobForm=$('#noticeForm');
	
	jobForm.find("[name='title']").val($('div.input-group-sm>input[name="title"]').val());
	jobForm.find("[name='writer']").val($('div.input-group-sm>input[name="writer"]').val());
	jobForm.find("[name='content']").val($('div.input-group-sm>textarea[name="content"]').val());
	
	jobForm.attr({
		action:url,
		method:'get'
	}).submit();
	
}

//팝업창 닫기
function CloseWindow(parentURL){
	if (parentURL) {
		window.opener.parent.location.href=parentURL;
	} else {
		window.opener.parent.location.reload(true);
	}
	window.close();
}

</script>

</body>
