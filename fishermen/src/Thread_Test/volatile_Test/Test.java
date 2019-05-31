package Thread_Test.volatile_Test;

/**
 * @Author: Azhu
 * @Date: 2019/3/22 15:55
 * @Version 1.0
 * @Description:
 */
public class Test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {

        final Test test = new Test();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }

        Thread.sleep(2000);
        System.out.println(test.inc);
    }
}