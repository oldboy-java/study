package com.liuli.ssm.util.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;

import com.liuli.ssm.annotation.DataSource;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 定义切换数据源切面  
 * 获取datasource对象之前往HandleDataSource中指定当前线程数据源路由的key
 * @author	刘力
 * @date	2017年9月17日下午6:41:03
 * @version 1.0
 */
public class DataSourceAspect {

	 /**  
     * 在dao层方法之前获取datasource对象之前在切面中指定当前线程数据源路由的key  
     */  
     public void before(JoinPoint point)  {   
    	 	//拦截的服务实现类
             Object target = point.getTarget();  
             System.out.println(target.toString());  
             //拦截的服务方法名
             String method = point.getSignature().getName();  
             System.out.println(method);  
             
             //拦截的服务接口class对象
             Class<?>[] classz = target.getClass().getInterfaces();  
             
             //拦截的接口中方法参数
             Class<?>[] parameterTypes = ((MethodSignature) point.getSignature())  
                     .getMethod().getParameterTypes();  
             try {  
            	 //获取接口的方法（注解是放在接口方法上的）
                 Method m = classz[0].getMethod(method, parameterTypes);  
                 System.out.println(m.getName());  
                 if (m != null && m.isAnnotationPresent(DataSource.class)) {  
                     DataSource data = m.getAnnotation(DataSource.class);  
                     System.out.println("用户选择数据库库类型："+data.value());  
                     DynamicDataSourceHolder.putDataSourceKey(data.value().toString());
                 }  
                   
             } catch (Exception e) {  
                 e.printStackTrace();  
             }  
        } 
}
