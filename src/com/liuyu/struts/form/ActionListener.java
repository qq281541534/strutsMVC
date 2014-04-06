package com.liuyu.struts.form;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.jdom.JDOMException;

public class ActionListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("信息：系统已经注销！！");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		ServletContext ac = arg0.getServletContext();
		//获取web.xml中配置struts-config对应的value值
		String xmlPath = ac.getInitParameter("struts-config");
		//获取服务器真实路径
		String tomcatPath = ac.getRealPath("\\");
		
		try {
			Map<String,XmlBean> map = Struts_xml.struts_xml(tomcatPath+xmlPath);
			ac.setAttribute("struts", map);
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("信息：系统已加载完成！！");
		
	}

}
