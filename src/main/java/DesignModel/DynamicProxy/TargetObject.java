package DesignModel.DynamicProxy;

/**
 * @ClassName TargetObject
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/17  11:38 AM
 * @Version 1.0
 */
public class TargetObject implements SubProxyInterface {
    @Override
    public void say(String name){
        System.out.println("real target object :" + name);
    }
}
