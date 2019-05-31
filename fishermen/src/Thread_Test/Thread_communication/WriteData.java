package Thread_Test.Thread_communication;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:34
 * @Version 1.0
 * @Description:
 */
public class WriteData {
    public void writeMethod(PipedOutputStream out) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                out.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
