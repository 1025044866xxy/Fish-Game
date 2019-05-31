package Thread_Test;

import java.util.concurrent.Callable;

/**
 * @Author: Azhu
 * @Date: 2019/3/19 12:48
 * @Version 1.0
 */
public class MyCallable<Object> implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        System.out.println("MyCallable run");
        return null;
    }
}
