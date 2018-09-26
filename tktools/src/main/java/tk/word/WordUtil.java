package tk.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * Word工具类 （将word模板->转成Freemarker模板完成word导出）
 */
@SuppressWarnings("restriction")
public class WordUtil {

	private static Configuration configuration = null;  
	private static volatile WordUtil wordUtil ;
      
	private WordUtil(){}
	
	/***
	 * 获取实例   WordUtil wordUtil = WordUtil.getInstance(request.getServletContext(), "/template");
	 * @param servletContext 上下文
	 * @param path 模板路径  WebRoot下的路径 如/template:WebRoot下的template目录
	 * @return
	 */
	public  static WordUtil getInstance(ServletContext servletContext,String path){
		if(wordUtil==null){
			synchronized (WordUtil.class) {
				if(wordUtil==null){
					 configuration = new Configuration(); 
					 //设置编码
				     configuration.setDefaultEncoding("utf-8");  
				     //设置模板装载采用从servlet中装载
				     configuration.setServletContextForTemplateLoading(servletContext,path);
				     wordUtil = new WordUtil();
				}
			}
		}
		return wordUtil;
	}
    
	/**
	 * 获取实例 WordUtil wordUtil = WordUtil.getInstance("/student");
	 * @param pathPrefix 模板类路径，以/开头
	 * @return
	 */
	public  static WordUtil getInstance(String pathPrefix){
		if(wordUtil==null){
			synchronized (WordUtil.class) {
				if(wordUtil==null){
					 configuration = new Configuration();
					 //设置编码
				     configuration.setDefaultEncoding("utf-8");
				     //设置模板装载采用从类路径中装载
				     configuration.setClassForTemplateLoading(WordUtil.class, pathPrefix);
				     wordUtil = new WordUtil();
				}
			}
		}
		return wordUtil;
	}
	
	
	/**
	 * 获取实例  WordUtil wordUtil = WordUtil.getInstance(new File(request.getServletContext().getRealPath("/template")));
	 * @param dir 文件系统目录
	 * @return
	 */
	public  static WordUtil getInstance(File dir){
		if(wordUtil==null){
			synchronized (WordUtil.class) {
				if(wordUtil==null){
					 configuration = new Configuration();  
					 //设置编码
				     configuration.setDefaultEncoding("utf-8");  
				     try {
				    	//设置模板装载采用从文件系统目录中装载
						configuration.setDirectoryForTemplateLoading(dir);
					} catch (IOException e) {
						e.printStackTrace();
					}
				     wordUtil = new WordUtil();
				}
			}
		}
		return wordUtil;
	}
	
	/***
	 * 根据模板生成Word文件
	 * @param dataMap 模板填充数据
	 * @param templateFileName 模板名称
	 * @return
	 */
	public File GenerateWordByTemplate(Map<?, ?> dataMap, String templateFileName) {  
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";  
        File f = new File(name);  
        Template t=null;  
        try {  
        	t = configuration.getTemplate(templateFileName);  
        	// 这个地方不能使用FileWriter因为需要指定编码类型否则生成的Word文档会因为有无法识别的编码而无法打开  
        	Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");  
            t.process(dataMap, w);  
            w.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new RuntimeException(ex);  
        }  
        return f;  
    }  
	
	/**
	 * 获取图片Base64字符串(word导出时图片数据采用base64字符串填充)
	 * @param imageInputStream
	 * @return
	 */
	public  static String getImageBase64String(InputStream imageInputStream){
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] data = null;
		try {
			data = new byte[imageInputStream.available()];
			imageInputStream.read(data); 
		    imageInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return encoder.encode(data);
    }
	
	/***
	 * 导出Word
	 * @param dataMap 模板填充数据
	 * @param templateFileName  模板名称
	 * @param response 响应流
	 * @param fileName 导出时word显示文件名
	 */
	public  void exportWord(Map<?, ?> dataMap, String templateFileName,HttpServletResponse response, String fileName) {
		String defaultName = "";
		ServletOutputStream output = null;
		File doc = GenerateWordByTemplate(dataMap, templateFileName);
		try {
			if (!org.springframework.util.StringUtils.isEmpty(fileName)) {
				defaultName = new String(fileName.getBytes("GB2312"),"iso-8859-1");
			}
			response.addHeader("Content-Disposition", "attachment; filename="+ defaultName);
			response.setContentType("application/octet-stream; charset=UTF-8");
			output = response.getOutputStream();
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
			if(doc!=null){
				doc.delete();
			}
		}
	}
	
	
	/***
	 * 导出Word
	 * @param response 响应流
	 * @param doc 导出的文件
	 * @param fileName 导出时word显示文件名
	 */
	public  void exportWord(HttpServletResponse response,File doc, String fileName) {
		String defaultName = "";
		ServletOutputStream output = null;
		try {
			if (!org.springframework.util.StringUtils.isEmpty(fileName)) {
				defaultName = new String(fileName.getBytes("GB2312"),"iso-8859-1");
			}
			response.addHeader("Content-Disposition", "attachment; filename="+ defaultName);
			response.setContentType("application/octet-stream; charset=UTF-8");
			output = response.getOutputStream();
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
			if(doc!=null){
				doc.delete();
			}
		}
	}
}
