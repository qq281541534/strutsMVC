package com.liuyu.struts.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liuyu.struts.form.ActionForm;
import com.liuyu.struts.form.FullForm;
import com.liuyu.struts.form.XmlBean;

public class ActionServlet extends HttpServlet {

	private static final long serialVersionUID = -1277709078345837977L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取请求路径
		String path = this.getPath(req.getServletPath());
		
		Map<String,XmlBean> map = (Map<String, XmlBean>) this.getServletContext().getAttribute("struts");
		//通过请求路径获取对应的xmlBean
		XmlBean xml = map.get(path);
		String formClass = xml.getFormClass();
		//将req请求过来的信息装载进对应的Form中
		ActionForm form = FullForm.full(formClass, req);
		String actionClass = xml.getActionClass();
		Action action = null;
		String url = "";
		try {
			Class clazz = Class.forName(actionClass);
			action = (Action) clazz.newInstance();
			url = action.execute(req, resp, form, xml.getActionForward());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("严重：控制器异常！！");
		}
		RequestDispatcher dis = req.getRequestDispatcher(url);
		dis.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		super.doPost(req, resp);
	}
	 
	//截取后缀为.do的请求
	public String getPath(String path){
		return path.split("\\.")[0];
	}

}
