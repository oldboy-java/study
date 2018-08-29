package com.ygbi.common;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.ygbi.cert.MySSLProtocolSocketFactory;

/**
 * ����ץȡ��ع�����
 * @author Administrator
 *
 */
public class Crawler {
	Log logger = LogFactory.getLog(Crawler.class.getClass()); 
	
	/**
	 * urlͨ������ʽ��ȡԴ�ļ�
	 * @param wurl
	 * @return
	 * @throws MalformedURLException
	 */
	public String getHtml(String wurl) throws MalformedURLException{
		String temp = null;
		URL url = new URL(wurl);
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
			while((temp=input.readLine()) != null ){
				sb.append(temp);
			}
			//System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws MalformedURLException{
		Crawler craw = new Crawler();
		String html = craw.clientGetHtml("http://index.1688.com/alizs/market.htm?cat=1");
		System.out.println(html);
	}
	/**
	 * urlͨ������ʽ��ȡԴ�ļ�
	 * @param wurl
	 * @param zfState
	 * @return
	 * @throws MalformedURLException
	 */
	public String getHtml(String wurl,String zfState,int collectItemId){
		System.out.println(wurl);
		String temp = null;
		URL url = null;
		try {
			url = new URL(wurl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		try {
			InputStream ins = url.openStream();
			InputStreamReader in = new InputStreamReader(ins,zfState);
			BufferedReader input = new BufferedReader(in);
			while((temp=input.readLine()) != null ){
				sb.append(temp);
			}
			//System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
			logger.error("��ĿID��"+collectItemId+" URL:"+wurl+" ������Ϣ��url����info��"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("��ĿID��"+collectItemId+" URL:"+wurl+" ������Ϣ���Ҳ���url����info��"+e.getMessage());
		}
		return sb.toString();
	}
	
	/**
	 * urlͨ������ʽ��ȡԴ�ļ�--�Ұ��Ҽ�
	 * @param wurl
	 * @param zfState
	 * @return
	 * @throws InterruptedException 
	 * @throws MalformedURLException
	 */
	public String getHtmlFor5(String wurl,String zfState,int collectItemId, int count) throws InterruptedException{
		String temp = null;
		URL url = null;
		try {
			url = new URL(wurl);
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		StringBuffer sb = new StringBuffer();
		try {
			InputStreamReader in = new InputStreamReader(url.openStream(),zfState);
			BufferedReader input = new BufferedReader(in);
			while(!in.ready()){    
				Thread.sleep(1000); // wait for stream to be ready.    
            }    
			while((temp=input.readLine()) != null ){
				sb.append(temp);
			}
			//System.out.println(sb.toString());
		} catch (UnsupportedEncodingException e) {			
			e.printStackTrace();
			logger.error("��ĿID��"+collectItemId+" URL:"+wurl+" ������Ϣ��url����info��"+e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("��ĿID��"+collectItemId+" URL:"+wurl+" ������Ϣ���Ҳ���url����info��"+e.getMessage());
			if(count < 3){
				return getHtmlFor5(wurl,zfState,collectItemId,count+1);
			}
		}
		return sb.toString();
	}
	
	
	/**
	 * ȡ��ҳ��Դ�ļ�
	 * @param url ��ҳ��URL��ַ
	 * @return ��ҳ��HTML
	*/ 
	public String clientGetHtml(String url){
		//����
		
		HttpClient httpClient = new HttpClient();  
		Protocol myhttps = new Protocol("https", new MySSLProtocolSocketFactory(), 443);   
		Protocol.registerProtocol("https", myhttps);   
//		httpClient.getHostConfiguration().setProxy("112.253.6.182", 8080);
//		httpClient.getParams().setAuthenticationPreemptive(true);
		GetMethod getMethod = new GetMethod(url);
		String html = "";
		try {
			httpClient.executeMethod(getMethod);
			html = getMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			getMethod.releaseConnection();
			httpClient.getHttpConnectionManager().closeIdleConnections(0);
		}
		/**
		FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\����\\b.txt");
			fw.write(html.trim());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		return html;
	}
	/**
	 * ȡ����������ʽ��html
	 * @param html ��ҳ��Դhtml
	 * @param regex ������ʽ
	 * @return html String
	 */
	public String getMatchHtml(String html,String regex){
		String mHtml = "";
		//Pattern.CASE_INSENSITIVE�����ִ�Сд
		//Pattern.DOTALL���ʽ'.'����ƥ�������ַ���������ʾһ�еĽ�������Ĭ������£����ʽ'.'��ƥ���еĽ�����
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		Matcher ma = pat.matcher(html);
		while(ma.find()){
			mHtml = mHtml + ma.group();
		}		
		return mHtml;
	}	
	/**
	 * ȡ���TR,��Ҫ��һ�У�tr��
	 * @param tableStr ���HTML
	 * @return String����
	 */
	public List<String> getTRList(String tableStr){
		List<String> trStr = new ArrayList<String>();
		String regex = "</tr>";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		String[] trs = pat.split(tableStr);
		for(int i=0;i<trs.length;i++){
			if(trs[i] != "" && trs[i].trim().length() != 0 && !trs[i].contains("table")){
				trStr.add(trs[i]);
			}
		}
		return trStr;
	}
	/**
	 * ȡ���TR,Ҫ��һ�У�tr��
	 * @param tableStr ���HTML
	 * @param regex �ָ�������ʽ
	 * @return String����
	 */
	public List<String> getTRList(String tableStr,String regex){
		List<String> trStr = new ArrayList<String>();
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		String[] trs = pat.split(tableStr);
		for(int i=0;i<trs.length;i++){
			if(trs[i] != "" && trs[i].trim().length() != 0 && !trs[i].contains("table")){
				trStr.add(trs[i]);
			}
		}
		return trStr;
	}
	
	/**
	 * ȡTR�������td��
	 * @param trStr
	 * @return
	 */	
	public List<String> getTDList(String trStr){
		List<String> tdStr = new ArrayList<String>();
		String regex = "(<td>)|(</td>)";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		String[] tds = pat.split(trStr);
		for(int i=0;i<tds.length;i++){
			if(tds[i] !="" && tds[i].trim().length() != 0 && !tds[i].contains("tr") && !tds[i].contains("td") ){
				tdStr.add(tds[i]);
			}
			
		}
		return tdStr;
	}
	/**
	 * ȡTR�������td��,�Լ�д�ָ�������ʽ
	 * @param trStr
	 * @param regex ������ʽ
	 * @return
	 */	
	public List<String> getTDList(String trStr,String regex){
		List<String> tdStr = new ArrayList<String>();
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		String[] tds = pat.split(trStr);
		for(int i=0;i<tds.length;i++){
			if(tds[i] !="" && tds[i].trim().length() != 0 && !tds[i].contains("tr") && !tds[i].contains("td") ){
				tdStr.add(tds[i]);
			}
			
		}
		return tdStr;
	}
	
	/**
	 * ȡ��ͷ��
	 * @param tableStr ���html
	 * @param tdRegex  tr������и����
	 * @return
	 */
	public List<String> getTRTitleDateList(String tableStr,String tdRegex){
		List<String> trStr = new ArrayList<String>();
		String regex = "</tr>";
		Pattern pat = Pattern.compile(regex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
		String[] trs = pat.split(tableStr);
		if(tdRegex != "" && tdRegex != null){
			for(int i=0;i<trs.length;i++){
				if(trs[i].contains("table")){
					Pattern pat1 = Pattern.compile(tdRegex, Pattern.CASE_INSENSITIVE|Pattern.DOTALL);
					String[] trs1 = pat1.split(trs[i]);
					for(int j=0;j<trs1.length;j++){
						if(trs1[j] != "" && !trs1[j].contains("table") && !trs1[j].contains("td")){
							trStr.add(trs1[j]);
						}
					}
					break;
				}
			}
		}else{
			for(int i=0;i<trs.length;i++){
				trStr.add(trs[i]);
			}
		}

		return trStr;
	}
	
	/**
	 * ȡ����
	 * @param pageHtml 
	 * @param regex
	 */
	public String getDate(String pageHtml,String regex){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(pageHtml);
		String date = "";
		if(m.find()) {
			if (!"".equals(m.group())) {
				date = m.group();
				date = date.replaceAll("��", "-");
				date = date.replaceAll("��", "-");
				date = date.replaceAll("/", "-");
			}
		}
		return date;
	}
	

	/**
	 * ����URL���ض�̬���غ��ҳ��HTML
	 * ��Ҫ��jar���У�htmlunit-2.9.jar��commons-lang-2.5.jar��selenium-server-2.39.0.jar��selenium-server-standalone-2.39.0.jar
	 * @param url ��ַ
	 * @return String
	 */
	public String getAjaxHtml(String url){
        // ģ��һ�������  
        final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);  
        webClient.setThrowExceptionOnFailingStatusCode(false);       
        webClient.setActiveXNative(false);  
        webClient.setCssEnabled(false);  
        webClient.setThrowExceptionOnScriptError(false);  
        webClient.setAjaxController(new NicelyResynchronizingAjaxController());            
        webClient.setJavaScriptEnabled(true);
        //webClient.setAjaxController(new NicelyResynchronizingAjaxController());            
        // ģ���������һ��Ŀ����ַ  
        HtmlPage page = null;
		try {
			page = webClient.getPage(url);
			 //System.out.println("page.asText()============"+page.asText()); //��ʾҳ������				
		} catch (FailingHttpStatusCodeException e1) {
			e1.printStackTrace();
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}  
		//�÷�����getPage()����֮����ò�����Ч  
        webClient.waitForBackgroundJavaScript(1000*10);  
        webClient.setJavaScriptTimeout(1000);  
		//System.out.println("page.asXml()============="+page.asXml().trim().substring(0, 200000));//��ʾjs�������html
        /**FileWriter fw = null;
		try {
			fw = new FileWriter("D:\\����\\d.txt");
			fw.write(page.asXml());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return page.asXml().trim();
	}
	

	
	
	public void getAjaxHtml(){
		String url = "http://list.tmall.com/search_product.htm?spm=a220m.1000858.1000721.2.3ca598&active=1&from=sn_1_cat&area_code=330100&hotsale=0&search_condition=23&style=g&sort=d&n=60&s=0&cat=50072111#J_crumbs";
	        // ģ��һ�������  
	        final WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);  
	        webClient.setThrowExceptionOnScriptError(false);  
	        webClient.setThrowExceptionOnFailingStatusCode(false);  
	        // ����webClient����ز���  
	        webClient.setJavaScriptEnabled(true);  
	        webClient.setActiveXNative(false);  
	        webClient.setCssEnabled(false);  
	        webClient.setThrowExceptionOnScriptError(false);  
	        webClient.waitForBackgroundJavaScript(600*1000);  
	        webClient.setAjaxController(new NicelyResynchronizingAjaxController());  
	          
	        webClient.setJavaScriptEnabled(true);    
	        // ģ���������һ��Ŀ����ַ  
	        HtmlPage page = null;
			try {
				page = webClient.getPage(url);
				 //System.out.println("page.asText()============"+page.asText()); 				
				 //System.out.println("page.getTextContent()===="+page.getTextContent()); 
			} catch (FailingHttpStatusCodeException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}  
//	      �÷�����getPage()����֮����ò�����Ч  
	        webClient.waitForBackgroundJavaScript(1000*3);  
	        webClient.setJavaScriptTimeout(0);  
	        System.out.println("page.asXml().length()======="+page.asXml().trim().length());
			 //System.out.println("page.asXml()============="+page.asXml().trim()); 
			 FileWriter fw = null;
		  try {
			fw = new FileWriter("D:\\Test11.txt");
			fw.write(page.asXml().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    }  
	
}
