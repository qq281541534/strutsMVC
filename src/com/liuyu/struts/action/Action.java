package com.liuyu.struts.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyu.struts.form.ActionForm;

/**   
 * @Description: action接口，用于其它action实现 
 * @author ly  
 * @date 2014-3-19
 * @version V1.0   
 */
public interface Action {
	
	String execute(HttpServletRequest req, HttpServletResponse resp,ActionForm form,Map<String,String> actionForward);
}
