package Thread_Test.synchronizedDemo1;

/**
 * @Author: Azhu
 * @Date: 2019/3/20 13:44
 * @Version 1.0
 * @Description:
 */
public class Run {
    public static void main(String[] args) {
        Task task = new Task();

        MyThread1 thread1 = new MyThread1(task);
        thread1.start();

        MyThread2 thread2 = new MyThread2(task);
        thread2.start();
    }
}
