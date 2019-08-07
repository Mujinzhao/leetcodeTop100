package ThreadPoolTool;

/**
 * @InterfaceName ThreadPool
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/22  7:47 PM
 * @Version 1.0
 */
public interface ThreadPool {
    //执行任务
    void execute(Runnable runnable);

    //关闭线程池
    void shutdown();

    //获取线程池的初始化大小
    int getInitSize();

    //获取线程池 最大的大小
    int getMaxSize();

    //获取线程池核心线程数
    int getCoreSize();

    //获取线程是缓存 任务队列的大小
    int getQuequSize();

    //获取线程池中活跃的线程数量
    int getActiveCount();

    //查看线程池 是否已经被shutDown
    boolean isShutDown();
}
