package Thread_Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author: Azhu
 * @Date: 2019/3/19 12:34
 * @Version 1.0
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        //1.继承Thread类，重写run方法
        Thread myThread=new MyThread();
        myThread.start();

        //2.实现Runnable接口，重写run方法，实现Runnable接口的实现类的实例对象作为Thread构造函数的target
        Runnable runnable=new MyRunnable();
        //runnable.run();
        Thread thread1=new Thread(runnable);
        thread1.start();
        //3.通过Callable和FutureTask创建线程
        Callable<Object> oneCallable = new MyCallable<Object>();
        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
        Callable callable=new MyCallable();
        Thread thread2=new Thread(oneTask);
        thread2.start();

        Thread.sleep(1000);//这里需要抛出异常处理
        //Run.class.wait(10000);
        System.out.println("主线程运行结束！");
    }
}
