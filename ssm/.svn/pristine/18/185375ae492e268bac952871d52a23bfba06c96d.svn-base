package com.liuli.ssm.util.datasource;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.ReflectionUtils;
import javax.sql.DataSource;

/**
 * 定义动态数据源，实现通过集成Spring提供的AbstractRoutingDataSource，只需要实现determineCurrentLookupKey方法即可 
 *  
 * 由于DynamicDataSource是单例的，线程不安全的，所以采用ThreadLocal保证线程安全，由DynamicDataSourceHolder完成。
 * @author	刘力
 * @date	2017年9月17日下午6:06:20
 * @version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	private Integer slaveCount;  
	  
    // 轮询计数,初始为-1,AtomicInteger是线程安全的  
    private AtomicInteger counter = new AtomicInteger(-1);  
  
    // 记录读库的key  
    private List<Object> slaveDataSources = new ArrayList<Object>(0);  
    
	@Override
	protected Object determineCurrentLookupKey() {
		Object key = null;
		// 使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key  
        if (DynamicDataSourceHolder.getDataSourceKey().equals(Source.master.toString())) {  
             key = DynamicDataSourceHolder.getDataSourceKey();   
        }else {
            key = getSlaveKey();  
        }
        System.out.println("选择数据源key="+key);
        return key; 
	}
	
	 @SuppressWarnings("unchecked")  
	    @Override  
	    public void afterPropertiesSet() {  
	        super.afterPropertiesSet();  
	  
	        // 由于父类的resolvedDataSources属性是私有的子类获取不到，需要使用反射获取  
	        Field field = ReflectionUtils.findField(AbstractRoutingDataSource.class, "resolvedDataSources");  
	        field.setAccessible(true); // 设置可访问  
	  
	        try {  
	            Map<Object, DataSource> resolvedDataSources = (Map<Object, DataSource>) field.get(this);  
	            // 读库的数据量等于数据源总数减去写库的数量  
	            this.slaveCount = resolvedDataSources.size() - 1;  
	            for (Map.Entry<Object, DataSource> entry : resolvedDataSources.entrySet()) {  
	                if (Source.master.toString().equals(entry.getKey())) {  
	                    continue;  
	                }  
	                slaveDataSources.add(entry.getKey());  
	            }  
	        } catch (Exception e) {  
	           e.printStackTrace(); 
	        }  
	    }  
	  
	    /** 
	     * 轮询算法实现 
	     *  
	     * @return 
	     */  
	    public Object getSlaveKey() {  
	        // 得到的下标为：0、1、2、3……  
	        Integer index = counter.incrementAndGet() % slaveCount;  
	        if (counter.get() > 9999) { // 以免超出Integer范围  
	            counter.set(-1); // 还原  
	        }  
	        return slaveDataSources.get(index);  
	    }  

}
