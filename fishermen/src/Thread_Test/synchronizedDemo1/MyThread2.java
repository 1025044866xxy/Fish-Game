package Thread_Test.synchronizedDemo1;

/**
 * @Author: Azhu
 * @Date: 2019/3/20 13:44
 * @Version 1.0
 * @Description:
 */
public class MyThread2 extends Thread {

    private Task task;

    public MyThread2(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }
}
