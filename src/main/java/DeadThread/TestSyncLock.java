package DeadThread;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestSyncLock
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/31  11:13 AM
 * @Version 1.0
 */
public class TestSyncLock {

    public static final Object object = new Object();

    public void getSync(){
        System.out.println(Thread.currentThread().getName() + "  into synchronized");

        synchronized (object){
            System.out.println(Thread.currentThread().getName() + "  get object lock");
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            }catch (InterruptedException ex){

            }
            System.out.println(Thread.currentThread().getName() + "  release lock");
        }
        System.out.println(Thread.currentThread().getName() + " over lock");
    }
}
