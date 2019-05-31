package Thread_Test.Thread_communication;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Author: Azhu
 * @Date: 2019/3/24 10:31
 * @Version 1.0
 * @Description:
 */
public class ReadData {
    public void readMethod(PipedInputStream input) {
        try {
            System.out.println("read  :");
            byte[] byteArray = new byte[20];
            int readLength = input.read(byteArray);
            while (readLength != -1) {
                String newData = new String(byteArray, 0, readLength);
                System.out.print(newData);
                readLength = input.read(byteArray);
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
