package DesignModel.StaticProxy;

import java.util.Objects;

/**
 * @ClassName StaticProxyImpl
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/16  7:15 PM
 * @Version 1.0
 */
public class StaticProxyImpl implements StaticProxy {

    private StaticProxy staticProxy;

    @Override
    public void process(){
        if(Objects.isNull(staticProxy)){
            staticProxy = new RealSubject();
        }
        staticProxy.process();
    }

    public void preProcess(){
        System.out.println("pre precess");
    }

    public void finalProcess(){
        System.out.println("final process");
    }
}
