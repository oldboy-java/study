/** 基于Dubbo的分布式系统架构视频教程，吴水成，wu-sc@foxmail.com，学习交流QQ群：367211134 **/
package wusc.edu.demo.redis;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @描述: Redis集群使用测试 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-23,上午1:30:40 .
 * @版本号: V1.0 .
 */
public class RedisClusterSpringTest {
	private static final Log log = LogFactory.getLog(RedisClusterSpringTest.class);

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
			
			JedisCluster jedisCluster = (JedisCluster) context.getBean("jedisCluster");
			int num = 1000;
			String key = "tie";
			String value = "";
			for (int i=1; i <= num; i++){
				// 存数据
				//jedisCluster.set(key+i, "WuShuicheng"+i);
				//jedisCluster.setex(key+i, 60, "WuShuicheng"+i); // 设置有效时间
				
				// 取数据
				value = jedisCluster.get(key+i); 
				log.info(key+i + "=" + value);
				
				// 删除数据
				//jedisCluster.del(key+i); 
				//value = jedisCluster.get(key+i); 
				//log.info(key+i + "=" + value);
			}

			context.stop();
		} catch (Exception e) {
			log.error("==>RedisSpringTest context start error:", e);
			System.exit(0);
		} finally {
			log.info("===>System.exit");
			System.exit(0);
		}
	}
}
