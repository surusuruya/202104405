<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<body>

  <!-- Content Wrapper. Contains page content -->
  <div  style="max-width:800px;min-width:420px;margin:0 auto;min-height:812px;">
   
   
	<section class="content-header">
	  	<div class="container-fluid">
	  		<div class="row md-2">
	  			<div class="col-sm-6">
	  				<h1>상세보기</h1>  				
	  			</div>
	  			<div class="col-sm-6">
	  				<ol class="breadcrumb float-sm-right">
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>자료실
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	상세보기
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
   
      <!-- Main content -->
    <section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
						<div class="card-tools">
							<button type="button" id="modifyBtn" class="btn btn-warning" onclick="modify_go();">MODIFY</button>						
						    <button type="button" id="removeBtn" class="btn btn-danger" onclick="remove_go();">REMOVE</button>
						    <button type="button" id="listBtn" class="btn btn-primary" onclick="CloseWindow();">CLOSE</button>
					    </div>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label>
							<input type="text" class="form-control" id="title" value="${pds.title }" readonly disabled  />							
						</div>
						<div class="row">	
							<div class="form-group col-sm-4" >
								<label for="writer">작성자</label>
								<input type="text" class="form-control" id="writer" value="${pds.writer }" readonly />
							</div>		
							
							<div class="form-group col-sm-4" >
								<label for="regDate">작성일</label>
								<input type="text" class="form-control" id="regDate"
									value="<fmt:formatDate value="${pds.regDate }" pattern="yyyy-MM-dd"/>" readonly/>
							</div>
							<div class="form-group col-sm-4" >
								<label for="viewcnt">조회수</label>
								<input type="text" class="form-control" id="viewcnt" value="${pds.viewcnt }" readonly />
							</div>
						</div>		
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div id="content">${pds.content }</div>	
						</div>
						
					</div>													
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row  -->
    </section>
    <!-- /.content -->
    
    <div class="col-md-12">
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">첨부파일</h3>
            
              </div>
              <!-- /.card-header -->
              <div class="card-body">
				<c:forEach items="${pds.attachList }" var="attach">
              	<div class="info-box" style="width:50%; cursor:pointer;"
              	 	onclick="loaction.href='<%=request.getContextPath()%>/pds/getFiles.do?ano=${attach.ano }';">
              	<span class="info-box-icon bg-warning"><i class="far fa-copy"></i></span>
				
              	<div class="info-box-content">
                	<span class="info-box-text">
                	<fmt:formatDate value="${pds.regDate }" pattern="yyyy-MM-dd"/></span>
                	<span class="info-box-number">${fn:substringAfter(attach.fileName,'$$') }</span>
              	</div>
              	<!-- /.info-box-content -->
            	</div>
				</c:forEach>
              </div>
              <!-- /.card-body -->
            </div>
            <!-- /.card -->
          </div>
  </div>
  <!-- /.content-wrapper -->

<form role="form">
	<input type="hidden" name="pno" value="${pds.pno }" />
</form>

<script>
var formObj = "";
window.onload=function(){
	formObj = $("form[role='form']");
}

function modify_go(){
// 	alert("click modify btn");
	formObj.attr('action', 'modifyForm.do').submit();
	
}
function remove_go(){
// 	alert("click remove btn");
	var answer = confirm("정말 삭제하시겠습니까?");
	if(answer) formObj.attr('action', 'remove.do').submit();
}
</script>

</body>