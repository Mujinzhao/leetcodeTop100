package ThreadLocalTest;

/**
 * @ClassName Bank
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/23  3:08 PM
 * @Version 1.0
 */
public class Bank {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 10;
        }
    };

    public void OutThreadLocal(){
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + ":   " + threadLocal.get());
    }

    public void setThreadLocal(){
        threadLocal.set(threadLocal.get() + 10);
    }
}
