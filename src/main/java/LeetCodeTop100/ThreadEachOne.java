package LeetCodeTop100;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class ThreadEachOne {
    private int n;

    private Semaphore semaphoreFoo;
    private Semaphore semaphoreBar;
    boolean first;

    public ThreadEachOne(int n) {
        this.n = n;
        semaphoreBar = new Semaphore(1);
        semaphoreFoo = new Semaphore(1);
        first = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(first == false){
                semaphoreBar.acquire();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                semaphoreFoo.release();
                first = true;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            if(first == true){
                semaphoreFoo.acquire();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                semaphoreBar.release();
                first = false;
            }
        }
    }
}
