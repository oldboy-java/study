/** 基于Dubbo的分布式系统架构视频教程，吴水成，wu-sc@foxmail.com，学习交流QQ群：367211134 **/
package wusc.edu.demo.redis;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 
 * @描述: Redis集群测试 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-23,上午1:30:40 .
 * @版本号: V1.0 .
 */
public class RedisClusterTest {
	private static final Log log = LogFactory.getLog(RedisClusterTest.class);

	public static void main(String[] args) {
		
		// 数据库链接池配置
		JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(100);  
        config.setMaxIdle(50);  
        config.setMinIdle(20);  
        config.setMaxWaitMillis(6 * 1000);  
        config.setTestOnBorrow(true);  
		
		// Redis集群的节点集合
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("192.168.126.128", 7111));
		jedisClusterNodes.add(new HostAndPort("192.168.126.129", 7112));
		jedisClusterNodes.add(new HostAndPort("192.168.126.130", 7113));
		jedisClusterNodes.add(new HostAndPort("192.168.126.128", 7114));
		jedisClusterNodes.add(new HostAndPort("192.168.126.129", 7115));
		jedisClusterNodes.add(new HostAndPort("192.168.126.130", 7116));
		
		// 根据节点集创集群链接对象
		//JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes);
		
		// 集群各节点集合，超时时间，最多重定向次数，链接池
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes, 2000, 100, config);
		int num = 1000;
		String key = "tie";
		String value = "";
		for (int i=1; i <= num; i++){
			// 存数据
			jedisCluster.set(key+i, "领带-金利来"+i); 
			// 取数据
			value = jedisCluster.get(key+i); 
			log.info(key+i + "=" + value);
			// 删除数据
			//jedisCluster.del(key+i); 
			//value = jedisCluster.get(key+i); 
			//log.info(key+i + "=" + value);
			
		}
	}
}
