package ConsumerProducer;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Consumer
 * @Author zhangxinkun
 * @Date 2020/1/5  4:37 PM
 * @Version 1.0
 */
public class Consumer implements Runnable{

    private final List<Integer> list;

    Lock lock;

    Condition condition;

    public Consumer(List<Integer> list, ReentrantLock lock,Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    //原生的wait notify方法实现
//    @Override
//    public void run(){
//        while(true){
//            synchronized (list){
//                if(list.size() == 0){
//                    try {
//                        System.out.println("Consumer is block");
//                        list.wait();
//                    }catch (InterruptedException InEx){
//
//                    }
//                }else{
//                    System.out.println("Consumer remove one");
//                    list.remove(list.size()-1);
//                    System.out.println("list size is:" + list.size());
//                    list.notifyAll();
//                }
//            }
//        }
//    }

    @Override
    public void run(){
        while(true){
            lock.lock();
            try {
                if(list.size() == 0){
                    try {
                        System.out.println("Consumer is block");
                        condition.await();
                    }catch (InterruptedException ex){

                    }
                }else{
                    System.out.println("Consumer remove one");
                    list.remove(list.size()-1);
                    System.out.println("list size is:" + list.size());
                    condition.signalAll();
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
