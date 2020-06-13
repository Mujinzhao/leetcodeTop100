package Ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.Data;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName TtlTest
 * @Author zhangxinkun
 * @Date 2020/2/15  9:22 PM
 * @Version 1.0
 */
@Data
public class TtlTest {
    private String name;

    public static void main(String[] args){
        Executor executor = TtlExecutors.getTtlExecutor(Executors.newFixedThreadPool(1));
        TransmittableThreadLocal<TtlTest> ttlTestTransmittableThreadLocal1 = new TransmittableThreadLocal<>();
        TransmittableThreadLocal<TtlTest> ttlTestTransmittableThreadLocal2 = new TransmittableThreadLocal<>();
        TtlTest params1 = new TtlTest();
        TtlTest params2 = new TtlTest();
        params1.setName("小猫");
        ttlTestTransmittableThreadLocal1.set(params1);

        executor.execute(() -> {
            System.out.println("预热");
        });

        try {
            Thread.sleep(500);
        }catch (Exception e){

        }

//        executor.execute(() -> {
//            System.out.println("刚进入子线程时，打印值：" + ttlTestTransmittableThreadLocal1.get().getName());
//            TtlTest temp = new TtlTest();
//            temp.setName("新值");
//            ttlTestTransmittableThreadLocal1.set(temp);
//            System.out.println("子线程将threadlocal的值修改为：");
//            System.out.println(ttlTestTransmittableThreadLocal1.get().getName());
//        });
        /**
         * 这里也提现TransmittableThreadLocal的一点：
         * 当线程池内部改变threadlocal的值的时候，并不会影响外围的线程中的值
         */

//        try {
//            Thread.sleep(1000);
//        }catch (Exception e){
//
//        }

        System.out.println("执行完子线程返回主线程后： "+ttlTestTransmittableThreadLocal1.get().getName());

        /**
         * 这一步才是最关键的一点：上面在第一次进入线程的时候，并没有设置过threadlocal2的值，
         * 但是外围设置过threadlocal2后，再次进入线程池，发现可以完整的获取外围设置的值，并不会报空指针。
         */
        params2.setName("小狗");
        ttlTestTransmittableThreadLocal2.set(params2);
        executor.execute(() -> {
            System.out.println("再次进入子线程后的值：" + ttlTestTransmittableThreadLocal1.get().getName());
            System.out.println("打印之前子线程没有复制过的threadlocal参数的值：" + ttlTestTransmittableThreadLocal2.get().getName());
            TransmittableThreadLocal<TtlTest> ttlTestTransmittableThreadLocal3 = new TransmittableThreadLocal<>();
            ttlTestTransmittableThreadLocal3.set(new TtlTest());
            int a = 0;
        });

        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }

        int a = 0;
        executor.execute(() -> {
            System.out.println("预热");
        });
        a=1;
    }
}
