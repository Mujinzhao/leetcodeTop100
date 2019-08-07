package ThreadPoolTool;

/**
 * @InterfaceName RunnableQueue
 * @Description TODO
 * @Author zhangxinkun
 * @Date 2019/7/22  8:04 PM
 * @Version 1.0
 */
//任务队列
public interface RunnableQueue {
    //向线程池中提交任务
    void offer(Runnable runnable);

    //从队列中获取任务
    Runnable take();

    //获取任务队列中现在的任务数量
    int size();
}
