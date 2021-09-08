<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>	    
    
<script>
	function Summernote_start(targetObj){
		targetObj.summernote({
			placeholder:"여기에 내용을 적으세요.",
			lang: 'ko-KR',
			height:250,
			disableResizeEditor : true,
			callbacks:{
				onImageUpload : function(files, editor, welEditable){  // 재정의 : 이미지 안뿌려짐
					// file size sheck!
					for (var file of files) { // 유효성 체크
						if (file.size > 1024 * 1024 * 5) {
							alert("이미지는 5MB 미만입니다.");
							return;
						}
						if (file.name.substring(file.name.lastIndexOf(".")+1).toUpperCase() != "JPG"){
							alert("JPG 이미지 형식만 가능합니다.");
							return;
						}
						
					}
					for (var file of files) { // 파일 하나씩 던지는 for문
						sendFile(file,this);
					}
				},
				onMediaDelete : function(target){
// 					alert(target[0].src.split("=")[1]); // 지우면 파일명 떨어짐.
					deleteFile(target[0].src); // src를 보낸다.
				}
				
			}
		});
	}
	
	function sendFile(file, el){
// 		alert(file.name); // 이미지 넣으면 알러트창에 파일명이 뜬다.
		var form_data = new FormData();
		form_data.append("file", file);
		$.ajax({
			data: form_data,
			type: "POST",
			url: '<%=request.getContextPath()%>/uploadImg.do',
			cache: false,
			contentType: false,
			processData: false,
			success: function(img_url){
				$(el).summernote('editor.insertImage', img_url);
			},
			error:function(){
				alert("이미지 업로드에 실패했습니다.");
			}
		});
	}
	
	function deleteFile(src){
// 		src=src.replace("getImg.do","deleteImg.do");
		
		var splitSrc = src.split("=");
		var fileName = splitSrc[splitSrc.length-1];
	
		var fileData = {fileName:fileName};
		
		$.ajax({
			url:"<%=request.getContextPath()%>/deleteImg.do",
			data : JSON.stringify(fileData),
			type : "post",
			contentType: "application/json",
			success:function(res){
				console.log(res);
			},
			error: function(){
				alert("이미지 삭제가 불가합니다.");
			}
		});
		
	}
</script>