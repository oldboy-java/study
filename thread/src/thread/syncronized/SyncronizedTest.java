package thread.syncronized;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * Created by Administrator on 2018-11-24.
 * 同步方法测试
 */
public class SyncronizedTest {

    public static void main(String[] args) {
           Thread t1 =  new Thread(()->{
                m();
            },"T1");


        Thread t2 =  new Thread(()->{
            m();
        },"T2");

        t1.start();
        t2.start();

        t1.interrupt();

    }

    public static synchronized void  m(){
        System.out.println("当前线程【"+Thread.currentThread().getName()+"】,"+System.currentTimeMillis());
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"---执行其他业务--------");
    }
}
