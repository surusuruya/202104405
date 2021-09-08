package com.jsp.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONResolver {

	public static void view(HttpServletResponse response, Object target) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// target을 String타입으로 변환시켜 출력한다.
		out.println(mapper.writeValueAsString(target));
		
		out.close();
	}
}
