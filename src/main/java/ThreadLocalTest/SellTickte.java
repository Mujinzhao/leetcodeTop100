package ThreadLocalTest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SellTickte
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/11/13  11:22 AM
 * @Version 1.0
 */
public class SellTickte{
    volatile int totle;

    ReentrantLock lock;

    public SellTickte() {
        this.totle = 100;
        lock = new ReentrantLock();
    }

    public void sell(){
        try {
//            lock.lock();
            for(int i=0;i<20;i++){
                totle--;
                System.out.println("Remind : " + Thread.currentThread().getName() + "  " + totle);
            }
        }finally {
//            lock.unlock();
        }
    }
}
