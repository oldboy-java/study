package tk.http;

import java.io.File;
import java.io.IOException;
import java.net.UnknownServiceException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.FormBody.Builder;


/***
 * Http工具类
 *
 */
public class HttpUtils {


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
		}
		return result;
	}
	
	
	
	/***
	 * 发送HttpGet请求
	 * @param url 请求地址
	 * @return
	 * @throws Exception
	 */
	public static String get(String url) throws Exception{
		String result = "";
		OkHttpClient okHttpClient = new OkHttpClient();
		final Request request = new Request.Builder().url(url).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		if(response.isSuccessful()){
			result = response.body().string();
		}
		return result;
	}
	
	
	/***
	 * 发送普通POST请求
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public  static String post(String url,Map<String,String> data) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient();
		Builder builder = new FormBody.Builder();
		for (Map.Entry<String, String> entry : data.entrySet()) {
			builder.add(entry.getKey(), entry.getValue());
		}
		RequestBody body = builder.build();
		final Request request = new Request.Builder().url(url).post(body).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		String result = response.body().string();
		return result;
	}
	
	/**
	 * 获取远程地址的byte内容（远程文件）
	 * @param url
	 * @return
	 */
	public static byte[] getBytes(String url) throws Exception{
		ResponseBody responseBody = getReponseBody(url);
		return responseBody.bytes();
	}
	
	/**
	 * 返回远程地址的ResponseBody
	 * @param url 远程地址
	 * @return
	 */
	private static ResponseBody getReponseBody(String url) throws Exception{
		OkHttpClient okHttpClient = new OkHttpClient();
		final Request request = new Request.Builder().url(url).build();
		Call call = okHttpClient.newCall(request);
		Response response = call.execute();
		if(response.isSuccessful()){
		   return 	response.body();
		}
		return null;
	}
	
	
	
	/***
	 * 上传文件
	 * @param url 上传地址
	 * @param params 普通参数
	 * @param filesMap 文件Map
	 * @param fileParamName 上传文件接口接受参数名
	 * @param uploadCallback 上传回调接口
	 */
    public static void uploadFile(final String url,  final Map<String, String> params, Map<String, File> filesMap,String fileParamName, final UploadCallback  uploadCallback) {
              OkHttpClient client = new OkHttpClient.Builder().writeTimeout(30, TimeUnit.SECONDS).build(); //设置超时时间
                
                try {
                    MediaType mediaType = MediaType.parse("multipart/form-data; charset=utf-8");//定义multipart/form-data类型
                    MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);//构造MultipartBodyBuilder
                   
                    //添加普通参数
                    if (params != null) {
                        for (Map.Entry<String,String> entry : params.entrySet()) {
                        	requestBodyBuilder.addFormDataPart(entry.getKey(), entry.getValue());
                        }
                    }
                    
                    //添加文件
                    if (filesMap != null) {
                        for (Map.Entry<String,File> entry : filesMap.entrySet()) {
                        	 requestBodyBuilder.addFormDataPart(fileParamName, entry.getKey(), RequestBody.create(mediaType, entry.getValue()));
                        }
                    }
                   
                    RequestBody requestBody = requestBodyBuilder.build();//构造请求体
                    Request request = new Request.Builder().url( url).post(requestBody).build();//构造请求
                    Response response = client.newCall(request).execute();//发送请求
                    uploadCallback.onSuccess(response.body().string());//接口回调成功方法
                } catch (IOException e) {
                    e.printStackTrace();
                    uploadCallback.onError(e.getMessage());//接口回调失败方法
                }
    }
    
    
    /***
	 * 上传文件
	 * @param url 上传地址
	 * @param params 普通参数
	 * @param filesMap 文件Map
	 * @param fileParamName 上传文件接口接受参数名
	 * @param uploadCallback 上传回调接口
	 */
    public static void uploadFileByte(final String url,  final Map<String, String> params, Map<String, byte[]> filesMap,String fileParamName, final UploadCallback  uploadCallback) {
              OkHttpClient client = new OkHttpClient.Builder().writeTimeout(30, TimeUnit.SECONDS).build(); //设置超时时间
                
                try {
                    MediaType mediaType = MediaType.parse("multipart/form-data; charset=utf-8");//定义multipart/form-data类型
                    MultipartBody.Builder requestBodyBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);//构造MultipartBodyBuilder
                   
                    //添加普通参数
                    if (params != null) {
                        for (Map.Entry<String,String> entry : params.entrySet()) {
                        	requestBodyBuilder.addFormDataPart(entry.getKey(), entry.getValue());
                        }
                    }
                    
                    //添加文件
                    if (filesMap != null) {
                        for (Map.Entry<String,byte[]> entry : filesMap.entrySet()) {
                        	 requestBodyBuilder.addFormDataPart(fileParamName, entry.getKey(), RequestBody.create(mediaType, entry.getValue()));
                        }
                    }
                   
                    RequestBody requestBody = requestBodyBuilder.build();//构造请求体
                    Request request = new Request.Builder().url( url).post(requestBody).build();//构造请求
                    Response response = client.newCall(request).execute();//发送请求
                    uploadCallback.onSuccess(response.body().string());//接口回调成功方法
                } catch (IOException e) {
                    e.printStackTrace();
                    uploadCallback.onError(e.getMessage());//接口回调失败方法
                }
    }
}
