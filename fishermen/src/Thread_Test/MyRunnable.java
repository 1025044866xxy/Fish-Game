package Thread_Test;

/**
 * @Author: Azhu
 * @Date: 2019/3/19 12:36
 * @Version 1.0
 */
public class MyRunnable implements Runnable {
    private static volatile  int i=0;
    @Override
    public void run() {

        while(true)
        {
            System.out.println("当前处理的线程:"+Thread.currentThread().getName()+"MyRunnable run: "+i++);
        }

    }
}
