package com.jsp.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import com.jsp.util.MakeFileName;

public class FileUploadResolver {

	public static List<File> fileUpload(FileItem[] items, String uploadPath) throws Exception{
		List<File> uploadFileList = new ArrayList<File>();
		
		File file = new File(uploadPath);
		if (!file.mkdirs()) {
			System.out.println(uploadPath + "가 이미 존재합니다.");
		}
		if (items != null) {
			for (FileItem item : items) {
				
				String fileName = new File(item.getName()).getName();// 사용자 파일명
				fileName = MakeFileName.toUUIDFileName(fileName, "$$"); // 고유한 파일명
				String filePath = uploadPath + File.separator + fileName;
				// 이 상태로 저장
				File storeFile = new File(filePath);
				
				try {
					item.write(storeFile);
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
				
				uploadFileList.add(storeFile);
				
			} // for end
			
		} // if end
		
		return uploadFileList;
	}
	
}
