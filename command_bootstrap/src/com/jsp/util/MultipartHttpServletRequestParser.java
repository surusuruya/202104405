package com.jsp.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.josephoconnell.html.HTMLInputFilter;
import com.jsp.exception.NotMultipartFormDataException;

public class MultipartHttpServletRequestParser {
	//업로드 파일 환경 설정
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 200; // 200MB
	
	Map<String, String[]> paramString = new HashMap<String, String[]>();
	Map<String, List<FileItem>> paramFile = new HashMap<String, List<FileItem>>();
	
	public MultipartHttpServletRequestParser(HttpServletRequest request)
												throws NotMultipartFormDataException,
													   UnsupportedEncodingException,
													   FileUploadException{
		this(request, MEMORY_THRESHOLD, MAX_FILE_SIZE, MAX_REQUEST_SIZE);
	}
	
	public MultipartHttpServletRequestParser(HttpServletRequest request,
											 int memory_threshold,
											 int max_file_size,
											 int max_request_size)
													throws NotMultipartFormDataException,
														   UnsupportedEncodingException,
														   FileUploadException{
		
		//객체를 받아야 업로드가 가능하기에 객체생성
		ServletFileUpload upload = ServletFileUploadBuilder.build(request, memory_threshold, max_file_size, max_request_size);
		
		List<FileItem> formItems = upload.parseRequest(request);
		
		for(FileItem item : formItems) {
			// 1.1필드
			String paramName = item.getFieldName();
			
			if(item.isFormField()) { // 일반 parameter : text
				
				String[] paramValues = item.getString("utf-8").split(",");
				this.paramString.put(paramName, paramValues);
				
			}else { //1.2 file
				List<FileItem> files = this.paramFile.get(paramName);
				
				if(files == null) {
					files = new ArrayList<FileItem>();
					this.paramFile.put(paramName, files);
				}
				files.add(item); //for문으로 받고 있는데 얘를 왜 추가 했을까?... 
             // file들은 하나씩 온다 그래서 map에 ArrayList박아 넣고 하나식 add해서 넣는것 | 리스트형태는 알아서 채워줌 그래서 List임 Array아님
				
			}
		}
		
	}
	
	public String getParameter(String paramName) {
		String[] param = this.paramString.get(paramName);
		String result = null;
		if(param != null) result = param[0];
		return result;
	}
	
	public String getXSSParameter(String paramName) {
		String result = HTMLInputFilter.htmlSpecialChars(getParameter(paramName));
		return result;
	}
	
	public String[] getParameterValues(String paramName) {
		return this.paramString.get(paramName);
	}
	
	public String[] getXSSParameterValues(String paramName) {
		String[] paramValues = new String[this.paramString.get(paramName).length];
		for(int i=0; i<paramValues.length; i++) {
			paramValues[i]
					= HTMLInputFilter.htmlSpecialChars(this.paramString.get(paramName)[i]);
		}
		return paramValues;
	}
	
	public Enumeration<String> getParameterNames(){
		List<String> paramNames = new ArrayList<String>();
		
		if(paramString.size() > 0) {
			for(String paramName : paramString.keySet()) {
				paramNames.add(paramName);
			}
		}
		if (paramFile.size() > 0) {
			for (String paramName : paramFile.keySet()) {
				paramNames.add(paramName);
			}
		}
		Enumeration<String> result = Collections.enumeration(paramNames);
		
		return result;
	}
	
	public FileItem getFileItem(String paramName) {
		
		List<FileItem> itemList = paramFile.get(paramName);
		FileItem result = null;
		
		if(itemList != null)  result = itemList.get(0);
		
		return result;
	}
	
	public FileItem[] getFileItems(String paraName) {
		List<FileItem> items = paramFile.get(paraName);
		FileItem[] files = null;
		if(items!=null) {
			files = new FileItem[items.size()];
			items.toArray(files);
		}
		return files;
	}
	
}

















