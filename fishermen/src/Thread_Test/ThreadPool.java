package Thread_Test;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Azhu
 * @Date: 2019/3/19 15:11
 * @Version 1.0
 */

/**
 * 线程实现方式4：通过线程池创建线程
 */
public class ThreadPool {

    private static int POOL_NUM=11;

    public static void main(String[] args){
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        for(int i=0;i<POOL_NUM;i++)
        {
            Runnable thread=new MyRunnable();
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}
