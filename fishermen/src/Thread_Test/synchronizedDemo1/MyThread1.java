package Thread_Test.synchronizedDemo1;

/**
 * @Author: Azhu
 * @Date: 2019/3/20 13:42
 * @Version 1.0
 * @Description:
 */
public class MyThread1 extends Thread{

    private Task task;

    public MyThread1(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
