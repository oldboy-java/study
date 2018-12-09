package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 定义航班查询任务
 * @author	刘力
 * @date	2018年10月14日下午3:06:23
 * @version 1.0
 */
public class FlightQueryTask extends Thread implements FlightQuery {

	private String origin; //出发地
	private String dest; //目的地
	private String airline; //航线
	private List<String> flightLists = new ArrayList<String>(); //存放查询航班结果
	
	public FlightQueryTask() {
		super();
	}

	public FlightQueryTask(String airline,String origin, String dest) {
		super();
		this.origin = origin;
		this.dest = dest;
		this.airline = airline;
	}

	@Override
	public void run() {
		System.out.printf("%s-query from %s to %s\n",this.airline,this.origin,this.dest);
		//生成随机数
		int randomval = ThreadLocalRandom.current().nextInt(10);
		try {
			
			TimeUnit.SECONDS.sleep(randomval); //模拟查询
			this.flightLists.add(this.airline+"-"+randomval);//模拟查询结果返回
			System.out.printf("The Flight:%s list query successful\n",this.airline);
		}catch (Exception e) {
			
		}
	}
	
	@Override
	public List<String> get() {
		return this.flightLists;
	}

}
