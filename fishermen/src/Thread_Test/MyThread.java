package Thread_Test;

/**
 * @Author: Azhu
 * @Date: 2019/3/19 12:33
 * @Version 1.0
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread run");
    }
}
