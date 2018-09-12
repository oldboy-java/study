package com.qtrmoon.util;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.log4j.Logger;


/***
 * Http工具类
 * @author huatang8
 *
 */
public class HttpUtils {

	private static  Logger logger = Logger.getLogger(HttpUtils.class);

	/***
	 * 发送HttpGet请求
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static String  doGetRequest(String url) throws Exception{
		String result = "";
		OkHttpClient okHttpClient = new OkHttpClient();
		final Request request = new Request.Builder().url(url).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		if(response.isSuccessful()){
			 result = response.body().string();
			if(logger.isDebugEnabled()){
				System.out.println(new String("get response from ").concat(url).concat("\r\n").concat(result));
			}
		}
		return result;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.err.println(HttpUtils.doGetRequest("http://www.qq.com"));
	}
}
