package com.tk.redpacket.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Administrator on 2018-9-26.
 */
@Configuration

//定义SpringMVC扫描的包
@ComponentScan(value = "com.tk.redpacket", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = Controller.class)})

//启动Spring MVC配置
@EnableWebMvc

//启用异步任务
@EnableAsync
public class WebConfig extends AsyncConfigurerSupport {

    /***
     * 配置视图解析器
     * @return 视图解析器
     */
    @Bean(name = "internalResourceViewResolver")
    public ViewResolver initViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        //可以在JSP页面中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }

    /***
     * 初始化RequestMappingHandlerAdapter，并加入Http的Json转换器
     * @return RequestMappingHandlerAdapter对象
     */
    @Bean(name = "initRequestMappingHandlerAdapter")
    public HandlerAdapter initRequestMappingHandlerAdapter() {
        //创建RequestMappingHandlerAdapter适配器
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();

        //HTTP JSON转换器
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();

        //MappingJackson2HttpMessageConverter接受JSON类型消息的转换
        MediaType mediaType = MediaType.APPLICATION_PROBLEM_JSON_UTF8;
        List<MediaType> mediaTypeList = new ArrayList<MediaType>();
        mediaTypeList.add(mediaType);

        //加入转换器的支持类型
        jackson2HttpMessageConverter.setSupportedMediaTypes(mediaTypeList);

        //往适配器加入json转换器
        requestMappingHandlerAdapter.getMessageConverters().add(jackson2HttpMessageConverter);
        return requestMappingHandlerAdapter;
    }

    /**
     * 创建异步任务连接池AsyncTaskExecutor
     * @return
     */
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);//线程池维护线程的最小数量
        taskExecutor.setMaxPoolSize(10);//线程池维护线程的最大数量
        taskExecutor.setQueueCapacity(200); //等待任务队列的长度
        taskExecutor.setKeepAliveSeconds(60);//空闲线程存活时间
        //线程池对拒绝任务（无线程可用）的处理策略ThreadPoolExecutor.CallerRunsPolicy策略 ,调用者的线程会执行该任务,如果执行器已关闭,则丢弃.
        taskExecutor.setRejectedExecutionHandler(getThreadPoolExecutorCallerRunsPolicy());
        taskExecutor.initialize(); //初始化
        return taskExecutor;
    }

    @Bean
    public ThreadPoolExecutor.CallerRunsPolicy getThreadPoolExecutorCallerRunsPolicy() {
        ThreadPoolExecutor.CallerRunsPolicy callerRunsPolicy = new ThreadPoolExecutor.CallerRunsPolicy();
        return callerRunsPolicy;
    }
}
