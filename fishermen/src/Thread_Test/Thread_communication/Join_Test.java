package Thread_Test.Thread_communication;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:51
 * @Version 1.0
 * @Description:
 */
public class Join_Test {
    public static void main(String[] args) throws InterruptedException {

        MyThread threadTest = new MyThread();
        threadTest.start();

        //Thread.sleep(?);//因为不知道子线程要花的时间这里不知道填多少时间
        threadTest.join();//直接加一个join方法
        System.out.println("我想当threadTest对象执行完毕后我再执行");
    }
    static public class MyThread extends Thread {

        @Override
        public void run() {
            System.out.println("我想先执行");
        }

    }
}
