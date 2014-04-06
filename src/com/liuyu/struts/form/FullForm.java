package com.liuyu.struts.form;

import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

public class FullForm {

	public static ActionForm full(String formPath, HttpServletRequest req){
		ActionForm form = null;
		try {
			//通过formPath反射出对应的类
			Class clazz = Class.forName(formPath);
			//调用构造方法实例化该类
			form = (ActionForm) clazz.newInstance();
			//获取该类中的所有属性
			Field[] field_ar = clazz.getDeclaredFields();
			//将所有属性循环
			for(Field f:field_ar){
				//开启沙箱
				f.setAccessible(true);
				//从request的中获取和该类中属性名称相同的数据，然后set给该类
				f.set(form, req.getParameter(f.getName()));
				//关闭沙箱
				f.setAccessible(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("严重Form装载失败。。。。。。。。。。。");
		}
		
		return form;
		
	}
}
