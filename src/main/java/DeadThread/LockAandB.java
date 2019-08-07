package DeadThread;

/**
 * @ClassName LockA
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/30  3:12 PM
 * @Version 1.0
 */
public class LockAandB {
    public static final Object objectA = new Object();
    public static final Object objectB = new Object();

    public void LockA(){
        synchronized (objectA){
            try {
                System.out.println("线程1得到A对象的锁");
                Thread.sleep(2000);
            }catch (InterruptedException ex){

            }
            synchronized (objectB){
                System.out.println("线程1得到B对象的锁");
            }
        }

    }

    public void LockB(){
        synchronized (objectB){
            try {
                System.out.println("线程2得到B对象的锁");
                Thread.sleep(2000);
            }catch (InterruptedException ex){

            }
            synchronized (objectA){
                System.out.println("线程2得到A对象的锁");
            }
        }

    }
}
