package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


/***
 * 模拟航班查询
 * @author	刘力
 * @date	2018年10月14日下午3:22:08
 * @version 1.0
 */
public class FlightQuerExample {

	//航空公司列表
	private static List<String> flightCompany = Arrays.asList("CSA","CEA","HNA");
	
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List<String> results = new ArrayList<String>();
		System.out.println("===========result==============");
		results = search("BJ","SH");
		results.forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("共耗时："+(end-start)+"毫秒");
	}

	/**
	 * 航班查询（多个线程并行查询）
	 * @param origin
	 * @param dest
	 * @return
	 */
	public static List<String> search(String origin,String dest){
		final List<String> result = new ArrayList<String>();
		
		//构造查询航班信息的线程列表
		List<FlightQueryTask> flightQueryTasks = flightCompany.stream().map(f->createFlightQueryTask(f, origin, dest)).collect(Collectors.toList());
	
		//启动线程
		flightQueryTasks.forEach(Thread::start);
		
		//分别调用每个线程的join方法，阻塞当前线程
		flightQueryTasks.forEach(t->{
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		//汇总所有线程查询结果
		//flightQueryTasks.stream().map(f->f.get()).forEach(result::addAll);
		for(int i =0 ;i <flightQueryTasks.size();i++) {
			List<String> flightList = flightQueryTasks.get(i).get();
			result.addAll(flightList);
		}
		
		return result;
	}
	
	/**
	 * 生成航班查询任务
	 * @param flight
	 * @param origin
	 * @param dest
	 * @return
	 */
	public static FlightQueryTask createFlightQueryTask(String flight,String origin,String dest) {
		return new FlightQueryTask(flight, origin, dest);
	}
}
