package com.liuli.ssm.util.datasource;

/**
 * 使用ThreadLocal技术来记录当前线程中的数据源的key
 * @author	刘力
 * @date	2017年9月17日下午6:04:04
 * @version 1.0
 */
public class DynamicDataSourceHolder {

    //使用ThreadLocal记录当前线程的数据源key  
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();  
  
    /** 
     * 设置数据源key 
     * @param key 
     */  
    public static void putDataSourceKey(String key) {  
        holder.set(key);  
    }  
  
    /** 
     * 获取数据源key 
     * @return 
     */  
    public static String getDataSourceKey() {  
        return holder.get();  
    }  
    
}
