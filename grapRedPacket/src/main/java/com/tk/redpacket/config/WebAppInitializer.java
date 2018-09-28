package com.tk.redpacket.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletRegistration;

/**
 * Created by Administrator on 2018-9-26.
 * DispatcherServlet初始化
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * SpringIoc环境配置
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ RootConfig.class };
    }

    /***
     * DispatcherServlet环境配置
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    /***
     * 配置DispatchServlet拦截请求
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"*.do"};
    }

    /***
     * 上传文件配置
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {

        super.customizeRegistration(registration);
    }
}
