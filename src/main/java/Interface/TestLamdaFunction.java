package Interface;

import Impl.Dog;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @InterfaceName TestLamdaFunction
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/4  3:19 PM
 * @Version 1.0
 */
@FunctionalInterface
public interface TestLamdaFunction<T> {
    T INC(Function function);
}
