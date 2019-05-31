package ThreadPool;

import java.util.ArrayList;
import java.util.List;


public class ThreadPoolTest {


    public static void main(String[] args) {
        //获取线程池
        IThreadPool t = ThreadPoolImpl.getThreadPool(20);

        List<Task> taskList = new ArrayList<Task>();
        for (int i = 0; i < 100; i++) {
            taskList.add(new Task());
        }
        //执行任务
        t.execute(taskList);
        System.out.println(t);
        //销毁线程
        t.destroy();
        System.out.println(t);
    }

    static class Task implements Runnable {

        private volatile int i = 1;
        public synchronized boolean judge()
        {
            if(i>5)
                return true;
            return  false;
        };
        @Override
        public  void run() {
            System.out.println("当前处理的线程:" + Thread.currentThread().getName() + " 执行任务" + (i++) + " 完成");
        }
    }

}