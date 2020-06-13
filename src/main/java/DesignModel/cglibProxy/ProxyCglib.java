package DesignModel.cglibProxy;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName ProxyCglib
 * @Author zhangxinkun
 * @Date 2020/1/19  11:13 PM
 * @Version 1.0
 */
public class ProxyCglib implements MethodInterceptor{

    private Object targetObject;

    public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();
        // 返回代理对象
        return proxyObj;
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable{
        System.out.println("pre invoke");
        Object object1 = method.invoke(this.targetObject,objects);
        System.out.println("last invoke");
        return object1;
    }
}
