package Thread_Test.Thread_communication.TreadLocal;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:56
 * @Version 1.0
 * @Description:
 */
public class Test1 {
    public static ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        if (t1.get() == null) {
            System.out.println("为ThreadLocal类对象放入值:aaa");
            t1.set("aaaֵ");
        }
        System.out.println(t1.get());//aaa
        System.out.println(t1.get());//aaa
    }

}
