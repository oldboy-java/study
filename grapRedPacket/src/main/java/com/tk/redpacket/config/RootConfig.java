package com.tk.redpacket.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * SpringIoc配置
 * Created by Administrator on 2018-9-26.
 */
@Configuration
//定义Spring扫描的包和扫描的注解
@ComponentScan(value = "com.tk.readpacket",includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
value = {Service.class})})
//启用事务管理器
@EnableTransactionManagement
public class RootConfig implements TransactionManagementConfigurer {

    private DataSource dataSource;

    /***
     * 初始化数据源
     * @return 数据源连接池
     */
    @Bean(name="dataSource")
    public DataSource initDataSource(){
        if(dataSource != null) {
            return dataSource;
        }
        Properties properties = new Properties();
        properties.setProperty("driverClassName","com.mysql.jdbc.Driver");
        properties.setProperty("url","jdbc:mysql://localhost:3306/red_packet");
        properties.setProperty("username","root");
        properties.setProperty("password","123456");
        properties.setProperty("maxActive","200");
        properties.setProperty("maxIdle","20");
        properties.setProperty("maxWait","30000");

        try {
            dataSource = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /***
     * 配置sqlSessionFactoryBean
     * @return sqlSessionFactoryBean
     */
    @Bean(name="sqlSessionFactoryBean")
    public SqlSessionFactoryBean initSqlSessionFactoryBean(){
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置数据源
        sqlSessionFactoryBean.setDataSource(initDataSource());

        //配置mybatis配置文件
        Resource resource = new ClassPathResource("mybatis/MyBatisConf.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);
        return sqlSessionFactoryBean;
    }

    /***
     * 初始化自动扫描配置器
     * @return Mapper扫描器
     */
    @Bean(name="mapperScannerConfigurer")
    public MapperScannerConfigurer initMapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //设置Mapper扫描基路径
        msc.setBasePackage("com.tk.redpacket");
        //设置sqlSessionFactoryBean
        msc.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        //设置要扫描的注解
        msc.setAnnotationClass(Mapper.class);
        return msc;
    }

    /***
     * 实现接口方法，注册注解事务
     * @return
     */
    @Override
    @Bean(name = "annotationDrivenTransactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        //设置数据源
        dataSourceTransactionManager.setDataSource(initDataSource());
        return dataSourceTransactionManager;
    }
}
