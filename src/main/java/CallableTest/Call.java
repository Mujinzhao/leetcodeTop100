package CallableTest;

import java.util.concurrent.Callable;

/**
 * @ClassName Call
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/8/14  11:15 AM
 * @Version 1.0
 */
public class Call<V> implements Callable<V> {
    @Override
    public V call() throws Exception{
        V result = null;
        for(int i=0 ;i<10; i++){
            System.out.println(i + "  ");
        }
        return result;
    }
}
