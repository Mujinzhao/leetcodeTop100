package Ttl;

/**
 * @ClassName TtlTest
 * @Author zhangxinkun
 * @Date 2020/2/15  9:49 AM
 * @Version 1.0
 */

import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 验证：InheritableThreadLocal在线程池中只能传过去一次。
 */
@Data
public class InheritableTest {
    String name;

    public static void main(String[] args) {
        ThreadLocal<InheritableTest> threadLocal1 = new InheritableThreadLocal();
        ThreadLocal<InheritableTest> threadLocal2 = new InheritableThreadLocal();
        InheritableTest params1 = new InheritableTest();
        InheritableTest params2 = new InheritableTest();
        params1.setName("thread1小猫");
        threadLocal1.set(params1);
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            System.out.println(threadLocal1.get().getName());
            System.out.println(threadLocal2.get());
        });
//        params1.setName("小狗");
//        for(int i=0;i<2;i++){
//            executorService.execute(() -> {
//                System.out.println(threadLocal1.get().getName());
//            });
//        }
        params1.setName("thread2小猫");
        params2.setName("小桔");
        threadLocal1.set(params2);
        executorService.execute(() -> {
            System.out.println(threadLocal1.get().getName());
            //这个时候线程池中拿不到threadlocal2 是个null
            System.out.println(threadLocal2.get());
        });
        executorService.shutdown();
    }
}
