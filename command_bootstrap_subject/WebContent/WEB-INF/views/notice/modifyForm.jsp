<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="notice" value="${notice }" />

<title>공지사항 상세보기</title>

<body>

	<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper" >
  	 <section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h6>공지사항 상세보기</h6>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="#">
				        	<i class="fa fa-dashboard">상세보기</i>
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
	<section class="content register-page" style="height: 90vh;">
		<div class="register-box" style="width:90%;">
			<div class="login-logo" style="margin: 0 auto 0;">
				<h6>${notice.nno }번 게시글</h6>
				<span style="text-align:right; font-size:2vh;">
				작성일 : <fmt:formatDate value="${notice.startDate }" pattern="yyyy년 MM월 dd일" /></span>
  			</div>
			<!-- form start -->
			<div class="card">				
				<div class="register-card-body" style="width:100%; margin:0 auto 0; text-align:center;">
					<form role="form" class="form-horizontal" action="regist.do" method="post">
						  <div class="form-group row">
							 <label for="tit" class="col-sm-2" style="font-size:0.9em;" >
							 	<span></span>제목</label>	
							
							<div class="col-sm-10 input-group-sm">
								<input type="hidden" name="nno" id="nno" value="${notice.nno }"/>
								<input class="form-control" name="title" type="text" id="title" 
										value="${notice.title}"/>
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
								<span></span>내용</label>
							<div class="col-sm-10 input-group-sm">
								<textarea class="form-control" rows="15" cols="50" name="content" id="content" 
										style="resize: none;">${notice.content }</textarea>								
							</div>
							
						</div>		
						
                <div class="card-footer" style="width:400px; margin:0 auto 0; background-color: rgba(255,255,255);">
                      <div class="row">
                         
                         <div class="col-sm-6 text-center">
                            <button type="button" onclick="modify()" id="modifyBtn" class="btn btn-warning ">수 정</button>
                         </div>
                      
                         <div class="col-sm-6 text-center">
                           <button type="button" id="listBtn" onclick="CloseWindow();" class="btn btn-primary pull-right">취 소</button>
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

<form id="modifyForm">
	<input type='hidden' name="nno" value=""/>
	<input type='hidden' name="title" value=""/>
	<input type='hidden' name="content" value=""/>
</form>
<script>

//팝업창 닫기
function CloseWindow(parentURL){
	if (parentURL) {
		window.opener.parent.location.href=parentURL;
	} else {
		window.opener.parent.location.reload(true);
	}
	window.close();
}

// 수정
function modify(){
	var url = "modify.do";
	var modifyForm=$('#modifyForm');
	
	modifyForm.find("[name='nno']").val($('div.input-group-sm>input[name="nno"]').val());
	modifyForm.find("[name='title']").val($('div.input-group-sm>input[name="title"]').val());
	modifyForm.find("[name='content']").val($('div.input-group-sm>textarea[name="content"]').val());
	
	modifyForm.attr({
		action:url,
		method:'get'
	}).submit();
}


</script>

</body>
