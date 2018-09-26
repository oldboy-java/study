package tk.response;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/***
 * 响应输出工具类
 *
 */
public class ResponseUtil {

	/**
	 * 输出json
	 * @param json json字符串
	 * @param response
	 * @throws Exception
	 */
	public static void responseJson(String json,HttpServletResponse response) throws Exception{
		response(json, "application/json; charset=utf-8", response);
	}
	
	/**
	 * 响应输出
	 * @param str 输出内容
	 * @param contentType 响应类型
	 * @param response
	 * @throws Exception
	 */
	public static void response(String str,String contentType,HttpServletResponse response) throws Exception{
		response.setContentType(contentType);
		PrintWriter writer = response.getWriter();
		writer.print(str);
		writer.close();
	}
	
	/**
	 * 设置响应头
	 * @param value 内容
	 * @param response
	 * @throws Exception
	 */
	public static void setResponseHeader(String header,String value,HttpServletResponse response) throws Exception{
		response.addHeader(header, value);
	}
}
