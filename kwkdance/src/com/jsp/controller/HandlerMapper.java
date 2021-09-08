package com.jsp.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import com.jsp.action.Action;
import com.jsp.context.ApplicationContext;

public class HandlerMapper {

	private Map<String, Action> commandMap = new HashMap<String, Action>();
	
	public HandlerMapper() throws Exception{
		String path = "com/jsp/properties/url";
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path);
		
		Set<String> actionSetHome = rbHome.keySet();
		
		Iterator<String> it = actionSetHome.iterator();
		
		while (it.hasNext()) {
			// command = key
			String command = it.next();
			
			// key값에 해당되는 문자열 반환
			String actionClassName = rbHome.getString(command); 
			
			try {
				Class<?> actionClass = Class.forName(actionClassName);
				Action commandAction = (Action) actionClass.newInstance();
				
				// 의존 주입
				Method[] methods = actionClass.getMethods();
				for (Method method : methods) {
					if (method.getName().indexOf("set") == 0) {
						String paramType = method.getParameterTypes()[0].getName();
						paramType = paramType.substring(paramType.lastIndexOf(".")+1);
						
						paramType = (paramType.charAt(0) + "").toLowerCase() + paramType.substring(1);
						
						method.invoke(commandAction, ApplicationContext.getApplicationContext().get(paramType));
						
						System.out.println("[HandlerMapper:invoke]"
								+ ApplicationContext.getApplicationContext().get(paramType));
					}
				}
				
				commandMap.put(command, commandAction);
				System.out.println("[HandlerMapper]" + command + ":" + commandAction + " 가 준비되었습니다.");
			} catch (ClassNotFoundException e) {
				System.out.println("HandlerMapper]" + actionClassName + "이 존재하지 않습니다.");
				throw e;
			} catch (InstantiationException e) {
				System.out.println("HandlerMapper]" + actionClassName + "인스턴스를 생성할 수 없습니다.");
				throw e;
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				throw e;
			}
			
		}
	} // 생성자 끝
	
	public Action getAction(String url) {
		Action action = commandMap.get(url);
		return action;
	}
}
