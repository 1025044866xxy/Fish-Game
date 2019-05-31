package Thread_Test;

/**
 * @Author: Azhu
 * @Date: 2019/3/20 12:44
 * @Version 1.0
 * @Description：多个线程之间共享变量线程不安全的情况（由于数据量太小要多运行几次才会出现错误情况）
 * 因为在大多数jvm中，count–的操作分为如下下三步：
 *取得原有count值
 * 计算i -1
 *对i进行赋值
 */

public class SharedVariableThread extends Thread{
    private int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
    }

    public static void main(String[] args) {
        SharedVariableThread mythread = new SharedVariableThread();
        // 下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
