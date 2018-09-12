package com.qtrmoon.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jdom.Element;

import com.qtrmoon.toolkit.XmlUtil;

public class Constant {
	public static String CONDITION_IN_SESSION = "CONDITION_IN_SESSION";// 查询条件session常量

	public static Map<String, String> CONFIG_VALUE = new HashMap<String, String>();

	public static String PRONAME;
	
	public static void push(String key, String value) {
		CONFIG_VALUE.put(key, value);
	}

	public static String getConstant(String key) {
		return CONFIG_VALUE.get(key.toUpperCase());
	}

	public static boolean getBooleanConstant(String key) {
		return Boolean.parseBoolean(CONFIG_VALUE.get(key.toUpperCase()));
	}

	/**
	 * 
	 */
	public static void createConstant() {
		String path = Constant.class.getResource("/").getPath()+"system-config.xml";
		path = path.replaceAll("%20", " ");
		XmlUtil xmlUtil = new XmlUtil();
		Element groupERoot = xmlUtil.loadXml(path);
		List<Element> constantList = groupERoot.getChildren();
		String workspace = null,nodeName;
		for (Element elem:constantList) {
			nodeName=elem.getName().toUpperCase();
			List<Element> cList = elem.getChildren();
			if(cList.size()>0){
				for (Element ce:cList) {
					push(nodeName+"."+ce.getName().toUpperCase(),ce.getValue());
					push(ce.getName().toUpperCase(),ce.getValue());
				}
			}else{
				push(nodeName, elem.getValue());
			}
		}

		Set key = CONFIG_VALUE.keySet();
		CONFIG_VALUE.put("projectName", PRONAME);
		workspace = CONFIG_VALUE.get("WORKSPACE");
		String name,value;
		for (Iterator<String> iter = key.iterator(); iter.hasNext();) {
			name = iter.next();
			value = CONFIG_VALUE.get(name);
			value = value.replaceAll("\\$\\{workspace\\}", workspace).replaceAll("\\$\\{projectName\\}", PRONAME);
			CONFIG_VALUE.put(name, fmt(value));
		}
	}

	private static String fmt(String value) {
		value = value.replaceAll("\\\\", "/");
		while(value.indexOf("//")>=0){
			value=value.replaceAll("//", "/");
		}
		return value;
	}

	/**
	 * 当服务没有启动或服务尚未启动时使用。
	 * createConstant是在编码过滤器init时调用的，如果在过滤器初始化前使用getConstant则获取不到值，例如ContextServlet启动的监听时就无法使用。
	 * @param string
	 * @return
	 */
	public static String getConstantNoServer(String name) {
		String res=null;
		String path = Constant.class.getResource("/").getPath()+ "system-config.xml";
		path = path.replaceAll("%20", " ");
		XmlUtil xmlUtil = new XmlUtil();
		Element root = xmlUtil.loadXml(path);
		List<Element> constantList = root.getChildren();
		String workspace = null, projectName = null, value;
		for (Element elem:constantList) {
			value = elem.getValue();
			if(elem.getName().equals("workspace")){
				workspace=value;
			}
			if(elem.getName().equals("projectName")){
				projectName=value;
			}
			if(elem.getName().equals(name)){
				value = value.replaceAll("[${}]", "#");// 会把${}三个字符转换成#。
				res=value;
			}
		}
		if(res!=null){
			res = res.replaceAll("##workspace#", workspace);
			res = res.replaceAll("##projectName#", projectName);
			res = res.replaceAll("\\\\", "/");
			res = res.replaceAll("//", "/");
			res = res.replaceAll("//", "/");
		}
		return res;
	}
}
