package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @InterfaceName TestAnnotation
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2020/1/17  11:00 PM
 * @Version 1.0
 */
@Target(value = {ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String name() default "xinkun";
}
