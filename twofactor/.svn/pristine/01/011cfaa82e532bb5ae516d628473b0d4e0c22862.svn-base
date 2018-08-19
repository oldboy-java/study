package twofactor;

import redis.clients.jedis.Jedis;

public class JedisUtil {
	
	private JedisUtil() {}

	/**
     * get a unix time from redis
     * @param host 
     * @param port
     * @return
     */
    public static long getUnixTimeFromRedis (String host,int port) {
    	long time = 0;
    	Jedis jedis = null;
    	try {
    		jedis = new redis.clients.jedis.Jedis(host,port);
        	time = Long.parseLong(jedis.time().get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis != null) {
				jedis.close();
			}
		}
    	return time;
    }
    
}
