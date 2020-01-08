package LeetCodeTop100;

/**
 * @ClassName 交替打印foobar1115
 * @Author zhangxinkun
 * @Date 2020/1/5  9:44 AM
 * @Version 1.0
 */

import java.util.concurrent.Semaphore;

/**
 * 我们提供一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 *
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 * 解析：用信号量进行控制。
 */
public class 交替打印foobar1115 {
    private int n;
    Semaphore se1;
    Semaphore se2;
    public 交替打印foobar1115(int n) {
        this.n = n;
        se1 = new Semaphore(1);
        se2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            se1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            se2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            se2.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            se1.release();
        }
    }
}
