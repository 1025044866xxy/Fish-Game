package Thread_Test.Thread_communication;

import java.io.PipedOutputStream;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:33
 * @Version 1.0
 * @Description:
 */
public class ThreadWrite extends  Thread{
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        super();
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        write.writeMethod(out);
    }
}
