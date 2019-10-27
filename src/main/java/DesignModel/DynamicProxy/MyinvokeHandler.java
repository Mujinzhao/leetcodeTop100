package DesignModel.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName MyinvokeHandler
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/10/17  11:39 AM
 * @Version 1.0
 */
public class MyinvokeHandler implements InvocationHandler {
    private Object target;

    public MyinvokeHandler(Object object){
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable{
        System.out.println("pre handler");

        Object object = method.invoke(target,args);

        System.out.println("last handler");

        return object;
    }

}
