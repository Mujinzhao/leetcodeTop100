import CallableTest.Call;
import DeadThread.LockAandB;
import DeadThread.TestReentranLock;
import DeadThread.TestSyncLock;
import Impl.BabyHaShiQi;
import Impl.Cat;
import Impl.Dog;
import Impl.HaShiQi;
import Interface.*;
import LeetCodeBaseDate.ListNode;
import Pagkage.Normal;
import Pagkage.SonNormal;
import Redis.BloomFilterTest;
import ThreadLocalTest.Bank;
import ThreadLocalTest.RunableBank;
import Unitls.SortTool;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.Synchronized;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName Main
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/6/28  11:06 AM
 * @Version 1.0
 */

public class Main{
        public static void main(String args[]){
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
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<10;i++){
                        System.out.println(i + "  ");
                    }
                }
            };
            Call call = new Call();
            FutureTask futureTask01 = new FutureTask(call);
            FutureTask futureTask02 = new FutureTask(call);
            Thread thread01 = new Thread(runnable);
            Thread thread02 = new Thread(runnable);
            thread01.start();
            try {
                thread01.join();
            }catch (InterruptedException ex){

            }

            thread02.start();

        }
}