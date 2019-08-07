/**
 * @ClassName MyThread
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/1  10:25 AM
 * @Version 1.0
 */
public class MyThread implements Runnable {
    private Integer people = 1000;

    private final Object lock = new Object();

    public MyThread(int people) {
    }

    @Override
    public void run(){
        synchronized (people){
            while (people > 0){
                System.out.println("threadName:"+Thread.currentThread().getName() + "   :" + people--);
            }
        }
    }
}
