package Thread_Test.synchronizedDemo1;

/**
 * @Author: Azhu
 * @Date: 2019/3/20 13:43
 * @Version 1.0
 * @Description:
 */
public class Task {
    public void doLongTimeTask() {
        for (int i = 0; i < 100; i++) {
            System.out.println("nosynchronized threadName="
                    + Thread.currentThread().getName() + " i=" + (i + 1));
        }
        System.out.println("");
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                System.out.println("synchronized threadName="
                        + Thread.currentThread().getName() + " i=" + (i + 1));
            }
        }

    }
}
