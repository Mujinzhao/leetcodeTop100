package DesignModel.DynamicProxy;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/17  11:38 AM
 * @Version 1.0
 */
public class TargetObject implements SubProxyInterface  ,SubProxyInterfaceNext {
    @Override
    public void say(String name,Integer age){
        System.out.println("real target object :" + name);
        System.out.println("real age = " + age);
    }

    @Override
    public void hello(String word){
        System.out.println("hello world");
    }

    @Override
    public Integer getAge(){
        return 27;
    }
}
