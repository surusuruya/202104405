package com.jsp.action.member;

import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.jsp.action.Action;
import com.jsp.controller.FileUploadResolver;
import com.jsp.util.GetUploadPath;
import com.jsp.util.MultipartHttpServletRequestParser;

public class MemberPictureUploadAction implements Action {

	// 업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 500; // 500kb
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 1; // 1mb
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 2; // 2mb
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 화면이 없는애여서 url이 없음
		String url = null;
		
		String uploadFileName = null;
		
		// 1. request 변환이 필요함 - 그래야 저장 파일 가져올 수 있음
		MultipartHttpServletRequestParser multi =
				new MultipartHttpServletRequestParser(request, 
						MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
		
		// 2. 저장할 경로를 가져와야 한다.
		String uploadPath = GetUploadPath.getUploadPath("member.picture.upload");
		
		// 3. 업로드된 이미지 저장
		// 배열로 받지만 하나밖에 없다. regist.jsp에 name=pictureFile인 input이 하나이기 때문
		FileItem[] items = multi.getFileItems("pictureFile");
		
		List<File> uploadFiles = FileUploadResolver.fileUpload(items, uploadPath);
		uploadFileName = uploadFiles.get(0).getName();
		
		// 4. 이전 이미지 삭제
		// regist.jsp의 form태그에 있는 oldPicture
		String oldPicture = multi.getParameter("oldPicture");
		File oldFile = new File(uploadPath + File.separator + oldPicture);
		if (oldFile.exists()) {
			oldFile.delete();
		}
		
		// 5. 저장한 파일명 보내기
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(uploadFileName);
		
		return url;
	}

}
