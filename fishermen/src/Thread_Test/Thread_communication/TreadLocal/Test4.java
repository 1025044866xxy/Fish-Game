package Thread_Test.Thread_communication.TreadLocal;

import java.util.Date;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 11:12
 * @Version 1.0
 * @Description:ThreadLocal类固然很好，但是子线程并不能取到父线程的ThreadLocal类的变量，InheritableThreadLocal类就是解决这个问题的。
 */
public class Test4 {

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("       在Main线程中取值=" + Tools.tl.get());
                Thread.sleep(100);
            }
            Thread.sleep(5000);
            ThreadA a = new ThreadA();
            a.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static public class Tools {
        public static InheritableThreadLocalExt tl = new InheritableThreadLocalExt();
    }
    static public class InheritableThreadLocalExt extends InheritableThreadLocal {
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    }

    static public class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    System.out.println("在ThreadA线程中取值=" + Tools.tl.get());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
