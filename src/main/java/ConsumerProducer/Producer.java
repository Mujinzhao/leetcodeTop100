package ConsumerProducer;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Producer
 * @Author zhangxinkun
 * @Date 2020/1/5  4:40 PM
 * @Version 1.0
 */
public class Producer implements Runnable {
    private final List<Integer> list;

    Lock lock;
    Condition condition;

    public Producer(List<Integer> list,ReentrantLock lock,Condition condition) {
        this.list = list;
        this.lock = lock;
        this.condition = condition;
    }

    //原生的方法实现
//    @Override
//    public void run(){
//        while(true){
//            synchronized (list){
//                if(list.size() >= 10){
//                    try {
//                        System.out.println("Producer is block");
//                        System.out.println("list size is :" + list.size());
//                        list.wait();
//                    }catch (InterruptedException inex){
//
//                    }
//                }else{
//                    System.out.println("Producer product 999");
//                    list.add(999);
//                    System.out.println("list size is :" + list.size());
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
                if(list.size() >= 10){
                    try {
                        System.out.println("Producer is block");
                        System.out.println("list size is :" + list.size());
                        condition.await();
                    }catch (InterruptedException ex){

                    }
                }else{
                    System.out.println("Producer product 999");
                    list.add(999);
                    System.out.println("list size is :" + list.size());
                    condition.signalAll();
                }
            }finally {
                lock.unlock();
            }
        }
    }
}
