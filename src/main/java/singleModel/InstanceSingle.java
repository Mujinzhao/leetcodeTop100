package singleModel;

/**
 * @ClassName InstanceSingle
 * @Author zhangxinkun
 * @Date 2020/3/18  2:48 PM
 * @Version 1.0
 */

import lombok.Synchronized;

public class InstanceSingle {
    private InstanceSingle(){

    }

    private static boolean falg = false;
    /**
     * 反之反射的例子，其实int a是不需要使用的，这里示范而已
     * @param a
     */
    private InstanceSingle(int a){
        if(falg == false){
            synchronized (InstanceSingle.class){
                if(falg == false){
                    falg = true;
                }
            }
        }else{
            throw new RuntimeException();
        }
    }

    private static InstanceSingle instance = new InstanceSingle();

    /**
     * 饿汉模式（利用类加载，线程安全，但是不能防止反射攻击）
     */
    public static InstanceSingle getInstance(){
        return instance;
    }

    /**
     * 懒汉（线程安全，不能防止反射攻击）
     * @return
     */
    public static InstanceSingle lazyInstance(){
        if(instance == null){
            synchronized (InstanceSingle.class){
                if(instance == null){
                    instance = new InstanceSingle();
                    return instance;
                }
            }
        }
        return instance;
    }

    /**
     * 静态内部类（线程安全，不能防止反射）
     */
    private static class Holder {
        private static final InstanceSingle instance = new InstanceSingle();
    }

    public static InstanceSingle getStaticInstacne(){
        return Holder.instance;
    }
}
