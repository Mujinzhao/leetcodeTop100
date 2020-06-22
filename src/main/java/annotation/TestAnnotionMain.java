package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @ClassName TestAnnotionMain
 * @Author zhangxinkun
 * @Date 2020/1/17  11:03 PM
 * @Version 1.0
 */
public class TestAnnotionMain {
    public static void main(String[] args){
        TestAnnotionMain main = new TestAnnotionMain();
        Class clz = main.getClass();
        Method[] method = clz.getMethods();
        for(Method temp:method){
            Annotation[] annotations = temp.getAnnotations();
            for(Annotation aTemp:annotations){
                if(aTemp instanceof TestAnnotation){
                    String name = ((TestAnnotation) aTemp).name();
                    try {
                        System.out.println(name);
                        temp.invoke(main,"你好");
                    }catch (Exception ex){

                    }
                }
            }
        }
    }

    @TestAnnotation(name = "hello")
    public void PrintName(String name){
        System.out.println(name);
    }

    public void normal(){
        System.out.println("normalName");
    }
}
