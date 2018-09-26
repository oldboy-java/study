package tk.upload;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.internet.MimeUtility;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;


public class XFileUtils {

	
	/**
	 *  本地文件上传
	 * @param file 文件对象
	 * @param folder 文件相对于basePath的保存文件夹
	 * @param basePath 上传服务器存储基路径
	 * @return UploadResponseVo
	 */
	public static UploadResponseVo uploadFileLocal(MultipartFile file,String folder,String basePath){
		String originalFileName = file.getOriginalFilename();
		//扩展名
		String extention = (".").concat(getFileExt(originalFileName));
		//新文件名
		String newSclj = UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase().concat(extention);
		//创建文件夹
		makeDir(basePath+folder);
		
		String finalFilePath = basePath+folder+newSclj;
		
		//构造上传响应对象
		UploadResponseVo uploadResponseVo = new UploadResponseVo();
		//文件地址
		uploadResponseVo.setFilePath(folder+newSclj);
		//文件大小
		uploadResponseVo.setFileSize(getPrintSize(file.getSize()));
		//文件扩展名
		uploadResponseVo.setFileType(extention.toLowerCase());
		//文件名
		uploadResponseVo.setFileName(originalFileName);
		try {
			file.transferTo(new File(finalFilePath));
			//上传状态
			uploadResponseVo.setState("SUCCESS");
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		return uploadResponseVo;
	}
	
	
	/***
	 * 本地文件上传
	 * @param request 请求
	 * @param basePath 上传服务器存储基路径
	 * @return
	 * @throws Exception 
	 */
	public static List<UploadResponseVo> uploadFileLocal(HttpServletRequest request,String basePath) throws Exception{
		String folder="";
	    List<UploadResponseVo> response  = new ArrayList<UploadResponseVo>();
		DiskFileItemFactory factory = new DiskFileItemFactory();  
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setHeaderEncoding("utf-8");
        List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);//解析request请求
		} catch (FileUploadException e1) {
			e1.printStackTrace();
		}  
		
        Iterator<FileItem> iter = items.iterator();  
        while (iter.hasNext()) {  
            FileItem item = (FileItem) iter.next();  
            if (!item.isFormField()) {   // 如果是文件字段  
                String fileName = item.getName();
                long sizeInBytes = item.getSize();  //文件的大小，以字节为单位 
        		String extention = (".").concat(XFileUtils.getFileExt(fileName));//扩展名
        		String newSclj = UUID.randomUUID().toString().trim().replaceAll("-", "").toLowerCase().concat(extention);//新文件名
        		makeDir(basePath+folder);//创建文件夹
        		String finalFilePath = basePath+folder+newSclj;//最终磁盘存储路径
        		
        		UploadResponseVo uploadResponseVo = new UploadResponseVo();//构造上传响应对象
        		uploadResponseVo.setFilePath(folder+newSclj);//文件地址
        		uploadResponseVo.setFileSize(getPrintSize(sizeInBytes));//文件大小
        		uploadResponseVo.setFileType(extention.toLowerCase());//文件扩展名
        		uploadResponseVo.setFileName(fileName);//文件名
        		
                File uploadedFile = new File(finalFilePath); 
                uploadedFile.setReadable(true);
                try {
					item.write(uploadedFile); //写入文件到当前服务器磁盘  
					uploadResponseVo.setState("SUCCESS");
					response.add(uploadResponseVo);
				} catch (Exception e) {
					e.printStackTrace();
				}  
            } else{//如果是表单域 ，就是非文件上传元素 必须要判断的 
            	 String name = item.getFieldName(); //获取name属性的值
            	 if("project".equals(name)){ //普通参数名称project用于设置相对文件存储基路径的存储目录
            		 folder = item.getString()+"/";//获取value属性的值
            	 }
            } 
        } 
        return response;
	}
	
	private  static String getPrintSize(long size) {  
        // 如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义  
        double value = (double) size;  
        if (value < 1024) {  
            return String.valueOf(value) + "B";  
        } else {  
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();  
        }  
        // 如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位  
        // 因为还没有到达要使用另一个单位的时候  
        // 接下去以此类推  
        if (value < 1024) {  
            return String.valueOf(value) + "KB";  
        } else {  
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();  
        }  
        if (value < 1024) {  
            return String.valueOf(value) + "MB";  
        } else {  
            // 否则如果要以GB为单位的，先除于1024再作同样的处理  
            value = new BigDecimal(value / 1024).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();  
            return String.valueOf(value) + "GB";  
        }  
    }  
	
	//创建上传文件夹
	private static void makeDir(String dirPath){
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdirs();
		} 
	}
	
	/***
	 * 获取文件扩展名
	 * @param fileName 文件名称
	 * @return png、doc等
	 */
	private static String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	
	/***
	 * 本地文件下载
	 * 
	 * @param response
	 * @param req 
	 * @param filePath 文件地址
	 * @param fileName 下载显示文件名
	 * @param contentType
	 *            application/vnd.android.package-archive;charset=UTF-8
	 *            application/msword;charset=UTF-8
	 */
	public static void download(HttpServletResponse response,HttpServletRequest req,String filePath, String fileName, String contentType) {
		String userAgent = req.getHeader("user-agent");
		ServletOutputStream output = null;
		String newFileName="";
		String rtn="";
		try {
			newFileName = URLEncoder.encode(fileName, "UTF8");  
			// 如果没有UA，则默认使用IE的方式进行编码 
			rtn = "filename=\"" + newFileName + "\"";  
			if (userAgent != null)  {  
			     userAgent = userAgent.toLowerCase();  
			     if (userAgent.indexOf("msie") != -1) {  // IE浏览器，只能采用URLEncoder编码   
			        rtn = "filename=\"" + newFileName + "\"";  
			     } else if (userAgent.indexOf("opera") != -1){  // Opera浏览器只能采用filename*  
			        rtn = "filename*=UTF-8''" + newFileName;  
			     }else if (userAgent.indexOf("safari") != -1 ){    // Safari浏览器，只能采用ISO编码的中文输出  
			         rtn = "filename=\"" + new String(fileName.getBytes("UTF-8"),"ISO8859-1") + "\"";  
			     }else if (userAgent.indexOf("applewebkit") != -1 ){   // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出  
			    	  newFileName = MimeUtility.encodeText(fileName, "UTF8", "B");  
			          rtn = "filename=\"" + newFileName + "\"";  
			       } else if (userAgent.indexOf("mozilla") != -1){ // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出    
			          rtn = "filename*=UTF-8''" + newFileName;  
			       }  
			   }  
			 
			response.addHeader("Content-Disposition", "attachment;"+rtn);
			response.setContentType(contentType);
			output = response.getOutputStream();
			File doc = new File(filePath);
			FileUtils.copyFile(doc, output);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (output != null) {
					output.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/***
	 * 远程上传：这里参数写设置顺序（2和1）,决定了服务端List<FileItem>中FileItem的顺序
	 * 为保证普通参数可用于后续文件处理，需先设置普通参数，后设置文件参数
	 * @param fileHashMap 上传文件对象Map key文件名称,Value是文件
	 * @param ordinaryParamPairs 普通参数键值对
	 * @param remoteUploadServiceApiUrl  远程上传服务Api地址
	 */
	public static String uploadFileToRemoteService(Map<String, File> fileHashMap, Map<String, String> params, String remoteUploadServiceApiUrl) { 
		 String response = null;
		 HttpURLConnection conn  = null;
		 String BOUNDARY = "---------7d4a6d158c9"; // 定义数据分隔线 
		 String PREFIX = "--", LINEND = "\r\n";
	     String MULTIPART_FROM_DATA = "multipart/form-data";
	     String CHARSET = "UTF-8";
	        
		try {  
			//实例化URL对象
            URL url = new URL(remoteUploadServiceApiUrl); 
            // 调用URL对象的openConnection()方法，创建HttpURLConnection对象
            conn = (HttpURLConnection) url.openConnection();  
            //设置连接用来输出
            conn.setDoOutput(true); 
            //设置连接可用来输入
            conn.setDoInput(true); 
            //设置使用POST方法
            conn.setRequestMethod("POST"); 
            
            // 设置Http请求头信息
            conn.setUseCaches(false);  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
            conn.setRequestProperty("Accept-Charset", "UTF-8");  
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA+"; boundary=" + BOUNDARY);  
            
           /* ########################## 以下部分是向远程服务器写数据   ####################################*/
          
            //1 设置普通参数
            StringBuilder sb = new StringBuilder();
            if(params != null && params.size() > 0) {
            	for (Map.Entry<String, String> entry : params.entrySet()){
                    sb.append(PREFIX);
                    sb.append(BOUNDARY);
                    sb.append(LINEND);
                    sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);// 拼接参数名，格式就是Content-Disposition: form-data; name="key" 其中key就是当前循环的键值对的键 
                    sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
                    sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
                    sb.append(LINEND);
                    sb.append(entry.getValue());
                    sb.append(LINEND);
                }
            }
            
            //调用HttpURLConnection对象的getOutputStream()方法构建输出流对象
            OutputStream out = new DataOutputStream(conn.getOutputStream()); 
            if(sb.toString().length() > 0) {
            	 out.write(sb.toString().getBytes());//写普通参数
            }
           
            //2 设置文件参数
            if(fileHashMap != null &&fileHashMap.size() > 0) {
            	 //循环处理多个文件对象
            	for (Map.Entry<String, File>  entry : fileHashMap.entrySet()){
            		 StringBuilder tmp = new StringBuilder(); 
            		 tmp.append(PREFIX);  
            		 tmp.append(BOUNDARY);  
            		 tmp.append(LINEND);  
            		// filename是post中传参的键 filename是文件的名称
                     tmp.append("Content-Disposition: form-data;name=\"file"  + "\";filename=\"" + entry.getKey() + "\"" + LINEND);  //服务端接收是参数名称为file1,file2....
                     tmp.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                     tmp.append(LINEND);
                     out.write(tmp.toString().getBytes());
                     
                     InputStream is = new FileInputStream(entry.getValue()); 
                     int len = 0;  
                     byte[] bufferOut = new byte[1024];  
                     while ((len = is.read(bufferOut)) != -1) {  
                         out.write(bufferOut, 0, len);  
                     }  
                     out.write(LINEND.getBytes()); // 多个文件时，二个文件之间加入这个  
                     is.close();  
            	}
            }
            // 请求结束标志
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes(); 
            out.write(end_data);  
            out.flush();  
            out.close();  
            /* ########################## 以上部分是向远程服务器写数据   ####################################*/
            
            
            /* ########################## 以下部分是从远程服务器读取数据   ####################################*/
            if(conn.getResponseCode() == 200) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
                String line = null;  
                StringBuilder res = new StringBuilder();
                while ((line = reader.readLine()) != null) {  
                	res.append(line); 
                }
                response = res.toString();
            }
            /* ########################## 以上部分是从远程服务器读取数据    ####################################*/
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{
        	if(conn != null){
        		conn.disconnect();
        	}
        } 
		return response;
    }  
	
	
	/***
	 * 远程上传：这里参数写设置顺序（2和1）,决定了服务端List<FileItem>中FileItem的顺序
	 * 为保证普通参数可用于后续文件处理，需先设置普通参数，后设置文件参数
	 * @param fileHashMap 上传文件对象Map key文件名称,Value是文件
	 * @param ordinaryParamPairs 普通参数键值对
	 * @param remoteUploadServiceApiUrl  远程上传服务Api地址
	 */
	public static String uploadFileStreamToRemoteService(Map<String, InputStream> fileHashMap, Map<String, String> params, String remoteUploadServiceApiUrl) { 
		 String response = null;
		 HttpURLConnection conn  = null;
		 String BOUNDARY = "---------7d4a6d158c9"; // 定义数据分隔线 
		 String PREFIX = "--", LINEND = "\r\n";
	     String MULTIPART_FROM_DATA = "multipart/form-data";
	     String CHARSET = "UTF-8";
	        
		try {  
			//实例化URL对象
            URL url = new URL(remoteUploadServiceApiUrl); 
            // 调用URL对象的openConnection()方法，创建HttpURLConnection对象
            conn = (HttpURLConnection) url.openConnection();  
            //设置连接用来输出
            conn.setDoOutput(true); 
            //设置连接可用来输入
            conn.setDoInput(true); 
            //设置使用POST方法
            conn.setRequestMethod("POST"); 
            
            // 设置Http请求头信息
            conn.setUseCaches(false);  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");  
            conn.setRequestProperty("Accept-Charset", "UTF-8");  
            conn.setRequestProperty("Accept", "*/*");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
            conn.setRequestProperty("Content-Type", MULTIPART_FROM_DATA+"; boundary=" + BOUNDARY);  
            
           /* ########################## 以下部分是向远程服务器写数据   ####################################*/
          
            //1 设置普通参数
            StringBuilder sb = new StringBuilder();
            if(params != null && params.size() > 0) {
            	for (Map.Entry<String, String> entry : params.entrySet()){
                    sb.append(PREFIX);
                    sb.append(BOUNDARY);
                    sb.append(LINEND);
                    sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + LINEND);// 拼接参数名，格式就是Content-Disposition: form-data; name="key" 其中key就是当前循环的键值对的键 
                    sb.append("Content-Type: text/plain; charset=" + CHARSET + LINEND);
                    sb.append("Content-Transfer-Encoding: 8bit" + LINEND);
                    sb.append(LINEND);
                    sb.append(entry.getValue());
                    sb.append(LINEND);
                }
            }
            
            //调用HttpURLConnection对象的getOutputStream()方法构建输出流对象
            OutputStream out = new DataOutputStream(conn.getOutputStream()); 
            if(sb.toString().length() > 0) {
            	 out.write(sb.toString().getBytes());//写普通参数
            }
           
            //2 设置文件参数
            if(fileHashMap != null &&fileHashMap.size() > 0) {
            	 //循环处理多个文件对象
            	for (Map.Entry<String, InputStream>  entry : fileHashMap.entrySet()){
            		 StringBuilder tmp = new StringBuilder(); 
            		 tmp.append(PREFIX);  
            		 tmp.append(BOUNDARY);  
            		 tmp.append(LINEND);  
            		// filename是post中传参的键 filename是文件的名称
                     tmp.append("Content-Disposition: form-data;name=\"file"  + "\";filename=\"" + entry.getKey() + "\"" + LINEND);  //服务端接收是参数名称为file1,file2....
                     tmp.append("Content-Type: application/octet-stream; charset=" + CHARSET + LINEND);
                     tmp.append(LINEND);
                     out.write(tmp.toString().getBytes());
                     
                     InputStream is = entry.getValue(); 
                     int len = 0;  
                     byte[] bufferOut = new byte[1024];  
                     while ((len = is.read(bufferOut)) != -1) {  
                         out.write(bufferOut, 0, len);  
                     }  
                     out.write(LINEND.getBytes()); // 多个文件时，二个文件之间加入这个  
                     is.close();  
            	}
            }
            // 请求结束标志
            byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINEND).getBytes(); 
            out.write(end_data);  
            out.flush();  
            out.close();  
            /* ########################## 以上部分是向远程服务器写数据   ####################################*/
            
            
            /* ########################## 以下部分是从远程服务器读取数据   ####################################*/
            if(conn.getResponseCode() == 200) {
            	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));  
                String line = null;  
                StringBuilder res = new StringBuilder();
                while ((line = reader.readLine()) != null) {  
                	res.append(line); 
                }
                response = res.toString();
            }
            /* ########################## 以上部分是从远程服务器读取数据    ####################################*/
        } catch (Exception e) {  
            e.printStackTrace();  
        }finally{
        	if(conn != null){
        		conn.disconnect();
        	}
        } 
		return response;
    }  

}
