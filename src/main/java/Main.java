import CallableTest.Call;
import DeadThread.LockAandB;
import DeadThread.TestReentranLock;
import DeadThread.TestSyncLock;
import DesignModel.DynamicProxy.MyinvokeHandler;
import DesignModel.DynamicProxy.SubProxyInterface;
import DesignModel.DynamicProxy.TargetObject;
import Impl.BabyHaShiQi;
import Impl.Cat;
import Impl.Dog;
import Impl.HaShiQi;
import Interface.*;
import JacksonTest.CompanyInfo;
import LeetCodeBaseDate.ListNode;
import LeetCodeTop100.TopK215;
import Pagkage.Normal;
import Pagkage.SonNormal;
import Redis.BloomFilterTest;
import ThreadLocalTest.Bank;
import ThreadLocalTest.RunableBank;
import ThreadLocalTest.SellTickte;
import ThreadPoolTool.ThreadPool;
import Unitls.SortTool;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.sun.tools.hat.internal.util.Comparer;
import lombok.Synchronized;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * @ClassName Main
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/28  11:06 AM
 * @Version 1.0
 */

public class Main {
    private Pattern pattern = Pattern.compile("[0-9]*");

    public static void main(String args[]) {
//            List<Normal> list = new ArrayList<>();
//            while(true){
//                Normal normal = new Normal();
//                list.add(normal);
//                try {
//                    Thread.sleep(50);
//                }catch (InterruptedException ex){
//
//                }
//            }
//            Function<Anlimail,Dog> function = (x) -> {
//                return new Dog("function111");
//            };
//
//            TestLamdaFunction testLamdaFunction = () -> { return function.apply(new Dog("functionDog")); };
//
//            TestLamdaFunction implAbstract = new ImplAbstract();
//            System.out.println(implAbstract.INC().toString());
//
//            implAbstract = () -> {return function.apply(new Dog("functionDog")); };
//
//            System.out.println(implAbstract.INC().toString());
//
//            SonNormal sonNormal = new SonNormal();
//            sonNormal.SonMultiplyMethod("zhang","xinkun");
        /********************************   Sort   **********************/
//            int[] nums = {6,5,4,1,2,3,8,9,5,6,56};
//            SortTool.mergeSort(nums);
//            for (int temp:nums
//                 ) {
//                System.out.println(temp+" ");
//            }

        /********************************   Synchronzied   **********************/
//            MyThread myThread = new MyThread(1000);
//            Thread thread01 = new Thread(myThread);
//            Thread thread02 = new Thread(myThread);
//            thread01.start();
//            thread02.start();

        /********************************** ThreadLocal      *******************/
//            Bank bank = new Bank();
//            bank.OutThreadLocal();
//            System.out.println(Thread.currentThread().getName());
//            Thread thread = new Thread(){
//                @Override
//                public void run(){
//                    System.out.println(Thread.currentThread().getName());
//                }
//            };
//            thread.start();
//            RunableBank runableBank = new RunableBank(bank);
//            Thread thread = new Thread(runableBank);
//            Thread thread1 = new Thread(runableBank);
//            thread.start();
//            thread1.start();

        /************************************  布隆过滤器 ************************/
//            BloomFilterTest bloomFilterTest = new BloomFilterTest();
//            bloomFilterTest.intoBlooFilter();
//            bloomFilterTest.getFalseVote();
//
//            HashMap<Integer,String> hashMap = new HashMap<>();
//            Hashtable<Integer,String> hashtable = new Hashtable<>();
        /************************************* DeadThread ********************/
//            LockAandB lockAandB = new LockAandB();
//            Thread thread01 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    lockAandB.LockA();
//                }
//            });
//
//            Thread thread02 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    lockAandB.LockB();
//                }
//            });
//            thread01.start();
//            thread02.start();
//
        /***************************TEST  synchronized 是不是 从阻塞初  继续执行 **************/
//            TestReentranLock reentranLock = new TestReentranLock();
//            CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
//            Thread thread01 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        cyclicBarrier.await();
//                    }catch (BrokenBarrierException ex){
//
//                    }catch (InterruptedException e){
//
//                    }
//                    reentranLock.getReenLock();
//                }
//            });
//            Thread thread02 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        cyclicBarrier.await();
//                    }catch (BrokenBarrierException e){
//
//                    }catch (InterruptedException ex){
//
//                    }
//                    reentranLock.getReenLock();
//                }
//            });
//            thread01.start();
//            try {
//                Thread.sleep(1000);
//            }catch (InterruptedException ex){
//
//            }
//            thread02.start();

        /********************************  java集合的 fail - fast 现象 *****************************/

//            List<Integer> list = new CopyOnWriteArrayList<>();
//
//            list.add(1);
//            list.add(2);
//            list.add(3);
//            list.add(4);
//            list.add(5);
//            list.add(6);
//            list.add(7);
//            Thread thread01 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Iterator<Integer> iterator = list.iterator();
//                    while(iterator.hasNext()){
//                        int temp = iterator.next();
//                        System.out.println(temp + " ");
//                        try {
//                            TimeUnit.SECONDS.sleep(1);
//                        }catch (InterruptedException ex){
//
//                        }
//                    }
//                }
//            });
//
//            Thread thread02 = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    }catch (InterruptedException ex){
//
//                    }
//                    list.remove(3);
//                }
//            });
//
//            thread01.start();
//            thread02.start();

//            System.out.println("main thread over");

        /**************************************  测试接口中的默认函数 *********************************/
//            Anlimail anlimail = new DefaultInterfaceTest();
//            System.out.println(anlimail.testDefaultInterface());

        /****************************************测试Callable接口 ***********************************/
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    for (int i=0;i<10;i++){
//                        System.out.println(i + "  ");
//                    }
//                }
//            };
//            Call call = new Call();
//            FutureTask futureTask01 = new FutureTask(call);
//            FutureTask futureTask02 = new FutureTask(call);
//            Thread thread01 = new Thread(runnable);
//            Thread thread02 = new Thread(runnable);
//            thread01.start();
//            try {
//                thread01.join();
//            }catch (InterruptedException ex){
//
//            }

//        try {
//
//            SubProxyInterface  iHello2 = (SubProxyInterface) Proxy.newProxyInstance(TargetObject.class.getClassLoader(),
//                    new Class[]{SubProxyInterface.class},
//                    new MyinvokeHandler(new TargetObject()));
//
//            iHello2.say("hello");
//        }catch (Exception e){
//            System.out.println(e.toString());
//        }
//        SellTickte sellTickte = new SellTickte();
//        CountDownLatch latch = new CountDownLatch(1);
//
//        Thread thread0 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    latch.await();
//                }catch (InterruptedException ex){
//
//                }
//                sellTickte.sell();
//            }
//        };
//        Thread thread1 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    latch.await();
//                }catch (InterruptedException ex){
//
//                }
//                sellTickte.sell();
//            }
//        };
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    latch.await();
//                }catch (InterruptedException ex){
//
//                }
//                sellTickte.sell();
//            }
//        };
//        Thread thread3 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    latch.await();
//                }catch (InterruptedException ex){
//
//                }
//                sellTickte.sell();
//            }
//        };
//        thread0.start();
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        latch.countDown();
//        Object ob = new Object();
//        CountDownLatch countA = new CountDownLatch(1);
//        CountDownLatch countB = new CountDownLatch(1);
//
//        Thread thread0 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//                countA.countDown();
//            }
//        });
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    countA.await();
//                } catch (Exception ex) {
//
//                }
//                System.out.println("2");
//                countB.countDown();
//            }
//        });
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    countB.await();
//                } catch (Exception ex) {
//
//                }
//                System.out.println("3");
//            }
//        };
//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "asdf";
//            }
//        };
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
//        List<Future<String>> result = new ArrayList<>();
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//
//        thread2.start();
//        thread1.start();
//        thread0.start();

//        for(int i=1;i<100000;i++){
//            String sql = "INSERT INTO `xinkun`.`User` (`id`, `userid`, `bizid`, `name`, `tel`) VALUES (NULL, '1', '1', '测试部门', '18637359032');";
//        }

//        Object ob = new Object();
//        CountDownLatch countA = new CountDownLatch(1);
//        CountDownLatch countB = new CountDownLatch(1);
//
//        Thread thread0 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("1");
//                countA.countDown();
//            }
//        });
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    countA.await();
//                } catch (Exception ex) {
//
//                }
//                System.out.println("2");
//                countB.countDown();
//            }
//        });
//        Thread thread2 = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    countB.await();
//                } catch (Exception ex) {
//
//                }
//                System.out.println("3");
//            }
//        };
//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "asdf";
//            }
//        };
//        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));
//        List<Future<String>> result = new ArrayList<>();
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//        result.add(threadPool.submit(callable));
//
//        thread2.start();
//        thread1.start();
//        thread0.start();
//
//        for(int i=1;i<100000;i++){
//            String sql = "INSERT INTO `xinkun`.`User` (`id`, `userid`, `bizid`, `name`, `tel`) VALUES (NULL, '1', '1', '测试部门', '18637359032');";
//        }
        String temp = "2,5,5,25511135";
        String[] ip = temp.split(",");
        for(int i=0;i<ip.length;i++){
            System.out.println(ip[i]);
        }
    }
}