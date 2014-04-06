package com.liuyu.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyu.struts.action.Action;
import com.liuyu.struts.form.ActionForm;
import com.liuyu.web.form.LoginForm;

public class LoginAction implements Action {

	public String execute(HttpServletRequest req, HttpServletResponse resp,
			ActionForm form, Map<String, String> actionForward) {
		LoginForm logForm = (LoginForm) form;
		String url = "shibai";
		if("111".equals(logForm.getName())){
			url = "chenggong";
		}
		return actionForward.get(url);
	}

}
