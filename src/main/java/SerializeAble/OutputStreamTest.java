package SerializeAble;

import com.alibaba.fastjson.JSON;

import java.io.*;

/**
 * @ClassName OutputStreamTest
 * @Author zhangxinkun
 * @Date 2019/12/3  9:02 AM
 * @Version 1.0
 */
public class OutputStreamTest {

    /**
     * 静态变量和transient修饰的变量不能被序列化。
     * @param args
     */
    public static void main(String[] args){
        SeriaTest seriaTest = new SeriaTest();
        seriaTest.setAge(27);
        seriaTest.setName("xinkun");
        seriaTest.setNo(1103);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("/Users/didi/SeriaTest.txt")));
            objectOutputStream.writeObject(seriaTest);
            objectOutputStream.close();
        }catch (IOException ioEX){
            System.out.println(ioEX.getStackTrace().toString());
        }

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/Users/didi/SeriaTest.txt")));
            SeriaTest second = (SeriaTest) objectInputStream.readObject();
            System.out.println(JSON.toJSON(second));
        }catch (Exception ioEX){
            System.out.println(ioEX.getStackTrace().toString());
        }

    }
}
