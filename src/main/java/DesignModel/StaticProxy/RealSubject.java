package DesignModel.StaticProxy;

/**
 * @ClassName RealSubject
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/16  7:21 PM
 * @Version 1.0
 */
public class RealSubject implements StaticProxy {

    @Override
    public void process(){
        System.out.println("do real things");
    }
}
