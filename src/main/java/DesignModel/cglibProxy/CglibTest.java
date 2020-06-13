package DesignModel.cglibProxy;

import DesignModel.DynamicProxy.TargetObject;

import java.util.Objects;

/**
 * @ClassName CglibTest
 * @Author zhangxinkun
 * @Date 2020/1/19  11:45 PM
 * @Version 1.0
 */
public class CglibTest{

    public static void main(String[] args){
        ProxyCglib proxyCGLIB = new ProxyCglib();
        TargetObject targetObject = new TargetObject();
        TargetObject proxy = (TargetObject) proxyCGLIB.createProxyObject(targetObject);
        proxy.hello("asdfsa");
    }
}
