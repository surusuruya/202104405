package com.jsp.action.pds;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.action.Action;
import com.jsp.controller.FileDownloadResolver;
import com.jsp.dto.AttachVO;
import com.jsp.service.PdsService;

public class PdsGetFileAction implements Action {
	
	private PdsService pdsService;
	public void setPdsService(PdsService pdsService) {
		
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 이미 파일명을 jsp에서 바꿨기 때문에 파일정보를 db에서 조회를 한 번 해줘야 한다.
		String url = null;
		
		int ano = Integer.parseInt(request.getParameter("ano"));
		
		AttachVO attach = pdsService.getAttachByAno(ano);
		
		String fileName = attach.getFileName();
		String savedPath = attach.getUploadPath();
		
		FileDownloadResolver.sendFile(fileName, savedPath, request, response);
		
		return url;
	}

}
