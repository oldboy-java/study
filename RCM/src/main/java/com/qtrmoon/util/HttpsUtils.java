package com.qtrmoon.util;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.FormBody.Builder;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.log4j.Logger;

import com.qtrmoon.common.JsonUtils;
import com.qtrmoon.common.RequestBobyContentType;

/**
 * Https工具类
 *
 */
public class HttpsUtils {
	
	private static  Logger logger = Logger.getLogger(HttpsUtils.class);
	
	private static  HashMap<String, List<Cookie>> cookieStore = new HashMap<String, List<Cookie>>();

	/***
	 * 	HttpsGet请求
	 * @param url 请求地址
	 * @return
	 */
	private static String  httpsGetRequest(OkHttpClient okHttpClient,String url) throws Exception{
		final Request request = new Request.Builder().url(url).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		String result = response.body().string();
		if(logger.isDebugEnabled()){
			System.out.println(new String("get response from ").concat(url).concat("\r\n").concat(result));
		}
		return result;
	}
	
	
	/***
	 * 发送HttpGet请求
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static String  sendHttpsGetRequest(String url) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new TrustAllHostnameVerifier()).build();
		return httpsGetRequest(okHttpClient, url);
	}
	
	
	/***
	 * 	发送HttpsGet请求,自动进行cookie管理
	 * @param url 请求地址
	 * @param cookieDomain cookie域
	 * @return
	 */
	public static String  sendHttpsGetRequestAutoCookieManage(String url,String cookieDomain) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new TrustAllHostnameVerifier())
				.cookieJar(new CookieJar() {
					@Override
					public void saveFromResponse(HttpUrl httpUrl,
							List<Cookie> cookies) {
						if(httpUrl.url().toString().indexOf(cookieDomain) > -1){
							cookieStore.put(HttpUrl.parse(cookieDomain).toString(), cookies);
						}
					}

					@Override
					public List<Cookie> loadForRequest(HttpUrl httpUrl) {
						List<Cookie> cookies = null;
						if(httpUrl.url().toString().indexOf(cookieDomain) > -1){
							cookies = cookieStore.get(cookieDomain);
						}
						return cookies != null ? cookies
								: new ArrayList<Cookie>();
					}
				}).build();
			return httpsGetRequest(okHttpClient, url);
	}
	
	
	/***
	 * 	发送HttpsPost请求
	 * @param url 请求地址
	 * @param requestBodyContentType 请求体contentType
	 * @param data Json数据字符串
	 * @return
	 * @throws Exception
	 */
	public static String  sendHttpsPostRequest(String url,String  requestBodyContentType,String data ) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new TrustAllHostnameVerifier()).build();
		if(requestBodyContentType!=null && RequestBobyContentType.json.getContentType().equals(requestBodyContentType)){
			return sendHttpsPostWithJsonRequestBody(okHttpClient,url, data);
		}else if(requestBodyContentType!=null && RequestBobyContentType.form.getContentType().equals(requestBodyContentType)){
			return sendHttpsPostWithCommonFormData(okHttpClient, url, data);
		}
		return null;
	}
	
	
	/***
	 * 发送HttpsPost请求,可以自动进行cookie管理
	 * @param url 请求地址
	 * @param requestBodyContentType  请求体contentType
	 * @param data Json数据字符串
	 * @param cookieDomain cookie的domain
	 * @return
	 * @throws Exception
	 */
	public static String  sendHttpsPostRequestAutoCookieManage(String url,String  requestBodyContentType,String data,String cookieDomain  ) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient.Builder().sslSocketFactory(createSSLSocketFactory()).hostnameVerifier(new TrustAllHostnameVerifier()).
				cookieJar(new CookieJar() {
					@Override
					public void saveFromResponse(HttpUrl httpUrl,
							List<Cookie> cookies) {
						if(httpUrl.url().toString().indexOf(cookieDomain) > -1){
							cookieStore.put(HttpUrl.parse(cookieDomain).toString(), cookies);
						}
					}

					@Override
					public List<Cookie> loadForRequest(HttpUrl httpUrl) {
						List<Cookie> cookies = null;
						if(httpUrl.url().toString().indexOf(cookieDomain) > -1){
							cookies = cookieStore.get(cookieDomain);
						}
						return cookies != null ? cookies
								: new ArrayList<Cookie>();
					}
				}).build();
			
		if(requestBodyContentType!=null && RequestBobyContentType.json.getContentType().equals(requestBodyContentType)){
			return sendHttpsPostWithJsonRequestBody(okHttpClient,url, data);
		}else if(requestBodyContentType!=null && RequestBobyContentType.form.getContentType().equals(requestBodyContentType)){
			return sendHttpsPostWithCommonFormData(okHttpClient, url, data);
		}
		return null;
	}
	
	/***
	 * 发送HttpPost请求，同时请求体是Json格式
	 * @param okHttpClient
	 * @param url 请求地址
	 * @param data Json数据字符串
	 * @return
	 * @throws Exception
	 */
	private  static String sendHttpsPostWithJsonRequestBody(OkHttpClient okHttpClient,String url,String data) throws Exception{
		MediaType JSON = MediaType.parse( RequestBobyContentType.json.getContentType()+"; charset=utf-8");
		RequestBody body = RequestBody.create(JSON, data);
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		String result = response.body().string();
		if(logger.isDebugEnabled()){
			System.out.println(new String("get response from ").concat(url).concat("\r\n").concat(result));
		}
		return result;
	}
	
	
	/***
	 * 发送HttpPost请求，请求体普通表单
	 * @param okHttpClient
	 * @param url
	 * @param Json数据字符串
	 * @return
	 * @throws Exception
	 */
	private  static String sendHttpsPostWithCommonFormData(OkHttpClient okHttpClient,String url,String data) throws Exception{
		Map<String,Object> paramValues = JsonUtils.json2Map(data);
		Builder builder = new FormBody.Builder();
		for (Map.Entry<String, Object> entry : paramValues.entrySet()) {
			builder.add(entry.getKey(), (String)entry.getValue());
		}
		RequestBody body = builder.build();
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		String result = response.body().string();
		if(logger.isDebugEnabled()){
			System.out.println(new String("get response from ").concat(url).concat("\r\n").concat(result));
		}
		return result;
	}
	
	
	/***
	 * 发送HttpPost请求，请求体含文件
	 * @param okHttpClient
	 * @param url
	 * @param data 
	 * @return
	 * @throws Exception
	 */
	/*private  static String sendHttpsPostWithMultipartData(OkHttpClient okHttpClient,String url,String data) throws Exception{
		Map<String,Object> paramValues = JsonUtils.json2Map(data);
		Builder builder = new FormBody.Builder();
		
		RequestBody body = builder.build();
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		String result = response.body().string();
		
		if(logger.isDebugEnabled()){
			System.out.println(new String("get response from ").concat(url).concat("\r\n").concat(result));
		}
		return result;
	}*/
	
	
	
	/**
	 * 信任所有证书
	 *
	 */
	private static class TrustAllCerts implements X509TrustManager {
		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {
			return new X509Certificate[0];
		}
	}

	private static class TrustAllHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}

	private static SSLSocketFactory createSSLSocketFactory() {
		SSLSocketFactory ssfFactory = null;

		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, new TrustManager[] { new TrustAllCerts() },
					new SecureRandom());

			ssfFactory = sc.getSocketFactory();
		} catch (Exception e) {
		}

		return ssfFactory;
	}
}
