package com.tk.redis;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

public class TxMain {

	public static void main(String[] args) {
		
		demo2();
	}
	
	/**
	 * 事务中命令格式和数据类型都正常，事务全部提交
	 */
	public static void demo1() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		
		SessionCallback sessionCallback = new SessionCallback<List>() {
			public List execute(RedisOperations operations) throws DataAccessException {
				//开启事务
				operations.multi();
				
				//执行命令,命令进入命令队列，并未执行
				operations.boundValueOps("name").set("tk");
				
				String name = (String)operations.boundValueOps("name").get();
				System.err.println("命令在命令队列中，未执行，所以name为空，name="+name);
				
				//提交事务,并将执行结果组装成集合后返回
				List result = operations.exec(); //会提交redis去执行命令，但是由于命令出错，不会返回结果
				return result;
			}
		};
		
		List result = (List) redisTemplate.execute(sessionCallback);
		System.err.println("命令执行结果=" + result.toString());
	}
	
	/**
	 * 事务中命令格式和数据类型都正常，事务全部提交
	 */
	public static void demo2() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		
		SessionCallback sessionCallback = new SessionCallback<List>() {
			public List execute(RedisOperations operations) throws DataAccessException {
				//开启事务
				operations.multi();
				
				//执行命令,命令进入命令队列，并未执行
				//命令1:命令格式和数据类型正确，提交事务
				operations.boundValueOps("name").set("tk-demo2"); 
				
				//命令2：命令格式正确，但是数据类型错误（对字符串进行自增操作），会回滚事务，不影响其他命令的执行。因此在实际操作中，应该对操作数据类型做验证，否则出现事务一部分提交，一部分回滚
				operations.boundValueOps("name").increment(1);
				
				//命令3：命令格式和数据类型正确，提交事务
				operations.boundValueOps("age").set("18");
				
				//提交事务,并将执行结果组装成集合后返回，由于命令2出现异常，这里不会返回执行结果
				List result = operations.exec();
				return result;
			}
		};
		
		List result = (List) redisTemplate.execute(sessionCallback);
		System.err.println("命令执行结果=" + result.toString());
	}
}
