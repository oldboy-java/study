package com.tk.redpacket.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

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
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import redis.clients.jedis.JedisPoolConfig;

/**
 * SpringIoc配置
 * Created by Administrator on 2018-9-26.
 */
@Configuration
//定义Spring扫描的包和扫描的注解
@ComponentScan(value = "com.tk.readpacket", includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = {Service.class})})
//启用事务管理器
@EnableTransactionManagement
public class RootConfig implements TransactionManagementConfigurer {

    private DataSource dataSource;

    /***
     * 初始化数据源
     * @return 数据源连接池
     */
    @Bean(name = "dataSource")
    public DataSource initDataSource() {
        if (dataSource != null) {
            return dataSource;
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean initSqlSessionFactoryBean() {
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
    @Bean(name = "mapperScannerConfigurer")
    public MapperScannerConfigurer initMapperScannerConfigurer() {
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

    /***
     * 创建RedisTemplate
     * @return
     */
    @Bean(name = "redisTemplate")
    public RedisTemplate initRedisTemplate() {
        //创建JedisPoolConfig
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("redis.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("redis.pool.maxIdle")));//最大空闲连接数
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("redis.pool.maxTotal")));//最大连接数
        jedisPoolConfig.setMaxWaitMillis(Integer.parseInt(properties.getProperty("redis.pool.maxWaitMillis")));//最大等待毫秒数

        //创建JedisConnectionFactory
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setHostName(properties.getProperty("redis.host"));//设置主机
        jedisConnectionFactory.setPort(Integer.parseInt(properties.getProperty("redis.port")));//设置端口
        //调用后初始化方法
        jedisConnectionFactory.afterPropertiesSet();

        //定义序列化器
        RedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        RedisSerializer stringRedisSerializer = new StringRedisSerializer();

        //创建RedisTemplate
        RedisTemplate redisTemplate = new RedisTemplate();
        //设置连接工厂
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        //设置序列化器
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(stringRedisSerializer);
        redisTemplate.setDefaultSerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setHashValueSerializer(stringRedisSerializer);
        return redisTemplate;
    }
    
    

}
