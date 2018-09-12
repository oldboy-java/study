package com.qtrmoon.common;

import java.util.Map;

import org.json.simple.JSONObject;

public class JsonUtils {
	
	/***
	 * Map转JSONObject
	 * @param map
	 * @return
	 */
	public static  JSONObject map2JsonObject(Map<String,Object> map) {
		JSONObject jsonObject = new JSONObject(map);
		return jsonObject;
	}
	
	/***
	 * json字符串转JSONObject
	 * @param json
	 * @return
	 */
	public static net.sf.json.JSONObject string2JsonObject(String json){
		net.sf.json.JSONObject jsonObject = new net.sf.json.JSONObject();
		return jsonObject.fromObject(json);
	}
	
	
	/***
	 * json字符串转Map
	 * @param json
	 * @return
	 */
	public static Map<String,Object>  json2Map(String json){
		return string2JsonObject(json);
	}
}
