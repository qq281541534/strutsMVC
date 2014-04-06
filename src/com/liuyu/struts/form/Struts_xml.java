package com.liuyu.struts.form;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * jdom方式解析struts-xml配置文件
 * @author ly
 *
 */
public class Struts_xml {

	public static Map<String, XmlBean> struts_xml(String xmlPath) throws JDOMException, IOException{
		
		Map<String, XmlBean> map = new HashMap<String, XmlBean>();
		SAXBuilder builder = new SAXBuilder();
		
		Document document = builder.build(new File(xmlPath));
		//获取根节点（struts）
		Element root = document.getRootElement();
		
		Element actionroot = root.getChild("action-mapping");
		
		List<Element> actions = actionroot.getChildren();
		for(Element e:actions){
			XmlBean xmlBean = new XmlBean();
			
			String name = e.getAttributeValue("name");
			
			xmlBean.setBeanName(name);
			//将formbeans放入到
			Element actionform = root.getChild("formbeans");
			List<Element> form = actionform.getChildren();
			for(Element x:form){
				if(name.equals(x.getAttributeValue("name"))){
					String formclass = x.getAttributeValue("class");
					xmlBean.setFormClass(formclass);
					break;
				}
				
			}
			
			String path = e.getAttributeValue("path");
			xmlBean.setPath(path);
			String type = e.getAttributeValue("type");
			xmlBean.setActionClass(type);
			
			List<Element> forward = e.getChildren();
			Map<String,String> forwards = new HashMap<String, String>();
			for(Element ex:forward){
				String fname = ex.getAttributeValue("name");
				String fvalue = ex.getAttributeValue("value");
				forwards.put(fname, fvalue);
			}
			xmlBean.setActionForward(forwards);
			map.put(path, xmlBean);
		}
		return map;
	}
	
	
	public static void struts_xml() throws JDOMException, IOException{
		
		SAXBuilder builder = new SAXBuilder();
		
		Document document = builder.build(new File("WebContent/WEB-INF/struts-config.xml"));
		//获取根节点（struts）
		Element root = document.getRootElement();
		//通过根节点获取第一级子节点（formbeans）
		Element actionform = root.getChild("formbeans");
		//获取formbeans下的所有节点（bean）
		List<Element> form = actionform.getChildren();
		//循环所有bean,并取出其中的属性
		for(Element e:form){
			String name = e.getAttributeValue("name");
			String clazz = e.getAttributeValue("class");
		}
		
		Element actionroot = root.getChild("action-mapping");
		List<Element> actions = actionroot.getChildren();
		for(Element e:actions){
			String name = e.getAttributeValue("name");
			String path = e.getAttributeValue("path");
			String type = e.getAttributeValue("type");
			
			List<Element> forward = e.getChildren();
			for(Element ex:forward){
				String fname = ex.getAttributeValue("name");
				String fvalue = ex.getAttributeValue("value");				
			}
		}
	}
	
	public static void main(String[] args) throws JDOMException, IOException {
		Map<String, XmlBean> map = new Struts_xml().struts_xml("WebContent/WEB-INF/struts-config.xml");
		Set set = map.keySet();
		for(Iterator<String> it = set.iterator(); it.hasNext();){
			String key = it.next();
			System.out.println(key);
			System.out.println(map.get(key));
		}
	}
	
}
