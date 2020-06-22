package DesignModel;

import DesignModel.DynamicProxy.MyinvokeHandler;
import DesignModel.DynamicProxy.SubProxyInterface;
import DesignModel.DynamicProxy.TargetObject;
import DesignModel.OverserModel.Watched;
import DesignModel.OverserModel.Watcher;

import java.lang.reflect.Proxy;

/**
 * @ClassName TestProxy
 * @Author zhangxinkun
 * @Date 2019/11/26  9:19 AM
 * @Version 1.0
 */
public class TestProxy {
    public static void main(String[] args){
//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        TargetObject targetObject = new TargetObject();
//        SubProxyInterface subProxyInterface = (SubProxyInterface)Proxy.newProxyInstance(TargetObject.class.getClassLoader(),TargetObject.class.getInterfaces(),new MyinvokeHandler(targetObject));
//        subProxyInterface.say("zhangxinkun",27);
//        ProxyUtils.generateClassFile(targetObject.getClass(),"XinkunProxyClass");

        Watched watched = new Watched("name","sessionID123");
        Watcher watcher = new Watcher();
        watched.addObserver(watcher);
        watched.printINFO();
    }
}
