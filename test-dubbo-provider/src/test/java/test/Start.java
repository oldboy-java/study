package test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liuli.dubbo.service.UserService;

public class Start {

	public static void main(String[] args) throws Exception {
		  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
	                new String[] { "spring/spring-*.xml" });  
		  
	        context.start();  
	        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  
	}

}
