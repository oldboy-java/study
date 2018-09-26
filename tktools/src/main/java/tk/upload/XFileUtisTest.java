package tk.upload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import tk.http.HttpUtils;
import tk.http.UploadCallback;

public class XFileUtisTest {


	/**
	 * 上传文件Byte（OkHttp)
	 */
	@Test
	public  void uploadFileBytesWithOkhttp() throws IOException{
		Map<String, byte[]> map2 = new HashMap<String,byte[]>();
		File f3 = null;
		File f4 = null;
		try {
			f3 = new File("E://Test1.jpg");
			f4 = new File("E://中国.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map2.put("Test1.jpg", FileUtils.readFileToByteArray(f3));
		map2.put("中国.jpg", FileUtils.readFileToByteArray(f4));
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("project", "fbs");
		
		HttpUtils.uploadFileByte("http://192.168.6.225/upload-service/file/upload.action", params, map2,"file", 
				new UploadCallback() {
					@Override
					public void onSuccess(String result) {
						System.err.println(result);
					}
					
					@Override
					public void onError(String msg) {
						System.err.println(msg);
					}
				});
	}
	
	/**
	 * 上传文件（OkHttp)
	 */
	@Test
	public  void uploadFileWithOkhttp(){
		Map<String, File> map = new HashMap<String,File>();
		File f1 = null;
		File f2 = null;
		try {
			f1 = new File("E://Test1.jpg");
			f2 = new File("E://中国.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("Test1.jpg",f1);
		map.put("中国.jpg", f2);
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("project", "fbs");
		
		HttpUtils.uploadFile("http://192.168.6.225/upload-service/file/upload.action", params, map,"file", 
		new UploadCallback() {
			@Override
			public void onSuccess(String result) {
				System.err.println(result);
			}
			
			@Override
			public void onError(String msg) {
				System.err.println(msg);
			}
		});

	}
	
	/**
	 * 用HttpConnection上传文件到远程服务器
	 */
	@Test
	public  void uploadWithHttpConnection(){
		Map<String, File> map = new HashMap<String,File>();
		File f1 = null;
		File f2 = null;
		try {
			f1 = new File("E://Test1.jpg");
			f2 = new File("E://中国.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("Test1.jpg",f1);
		map.put("中国.jpg", f2);
		
		Map<String,String> params = new HashMap<String,String>();
		params.put("project", "fbs");
		System.err.println(XFileUtils.uploadFileToRemoteService(map,params,"http://192.168.6.225/upload-service/file/upload.action"));
	}
}
