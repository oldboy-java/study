package insertTools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONObject;
import okhttp3.Call;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.junit.Test;

import com.qtrmoon.util.HttpsUtils;

public class OkHttp3Test {

	private final static HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

	@Test
	public void testHttpPost() {
		// 登录
		login();
		
		//获取简历数
		getJlCount();
	}
	
	public static void getJlCount() {
		String url = "http://192.168.1.225:8088/RMS/student/web/jl/myJlCount.action?xsid=%d";

		OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

		Request request = new Request.Builder().url(String.format(url, 31)).header("JSESSIONID", "BC0C5633BF6C5D52E47CA24AA9C5276F")
				.build();

		Call call = okHttpClient.newCall(request);

		try {
			Response response = call.execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void login(){
		String url = "http://192.168.1.225:8088/RMS/student/web/toLogin.action";

		OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new CookieJar() {
					@Override
					public void saveFromResponse(HttpUrl httpUrl,
							List<Cookie> list) {
						cookieStore.put(httpUrl.host(), list);
					}

					@Override
					public List<Cookie> loadForRequest(HttpUrl httpUrl) {
						List<Cookie> cookies = cookieStore.get(httpUrl.host());
						return cookies != null ? cookies
								: new ArrayList<Cookie>();
					}
				}).build();

		// 准备表单参数
		RequestBody body = new FormBody.Builder().add("xh", "333").add("mm", "123456").build();

		// 构造Request对象
		Request request = new Request.Builder().url(url).post(body).build();

		Call call = okHttpClient.newCall(request);

		try {
			Response response = call.execute();
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testHttpsGet() {
		try {
			String response = HttpsUtils
					.sendHttpsGetRequest("https://api.kandycn.com/v1.3/domains/accessTokens?key=DAK9d52eeb8475d48f5aa7d05f796a2f697&domain_api_secret=DAS86c13043ce3e42349e8ba0f213a107d8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testHttpsGetJsonRequestBody() {
		JSONObject data = new JSONObject();
		data.put("user_id", "zzzxxx991");
		data.put("user_email", "zzzxxx99@qq.com");
		data.put("user_password", "gb123456");

		try {
			String response = HttpsUtils
					.sendHttpsPostRequest(
							"https://api.kandycn.com/v1.3/domains/users/user_id?key=DATffd8cb4f5ead431cb3fe3472aeab7128",
							"application/json", data.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void generateKandyAccount() {

	}

}
