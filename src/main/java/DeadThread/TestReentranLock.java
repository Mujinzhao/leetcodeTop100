package DeadThread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName TestReentranLock
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/31  11:43 AM
 * @Version 1.0
 */
public class TestReentranLock {

    ReentrantLock lock = new ReentrantLock();

    public void getReenLock(){
        System.out.println(Thread.currentThread().getName() + "  into ReenLock");

        boolean Lock = false;
//        try {
            Lock = lock.tryLock();
//        }catch (InterruptedException ex){
//            System.out.println("interrupt Lock");
//        }
        if(Lock){
            try {
                System.out.println(Thread.currentThread().getName() + "  get Reentran lock");
                try {
                    TimeUnit.MILLISECONDS.sleep(3);
                } catch (InterruptedException ex) {

                }
                System.out.println(Thread.currentThread().getName() + "  release Reentran");
                System.out.println(Thread.currentThread().getName() + " over Reentran");
            }finally {
                lock.unlock();
            }
        }
    }
}
