package ConsumerProducer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestCP
 * @Author zhangxinkun
 * @Date 2020/1/5  4:40 PM
 * @Version 1.0
 */
public class TestCP {


    public static void main(String[] args){
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        List<Integer> list = new CopyOnWriteArrayList();
        Thread consumer = new Thread(new Consumer(list,lock,condition));
        Thread producer = new Thread(new Producer(list,lock,condition));
        consumer.start();
        producer.start();
        try {
            Thread.sleep(10);
        }catch (InterruptedException ie){

        }
        consumer.stop();
        producer.stop();
        return ;
    }
}
