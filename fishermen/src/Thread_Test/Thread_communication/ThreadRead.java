package Thread_Test.Thread_communication;

import java.io.PipedInputStream;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:32
 * @Version 1.0
 * @Description:
 */
public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        super();
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        read.readMethod(input);
    }
}
