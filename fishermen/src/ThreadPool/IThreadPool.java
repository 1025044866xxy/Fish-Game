package ThreadPool;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/3/8 12:57
 * @Version 1.0
 */
public interface IThreadPool {
    //加入任务
    void execute(ThreadPoolTest.Task task);

    //加入任务
    void execute(ThreadPoolTest.Task[] tasks);

    //加入任务
    void execute(List<ThreadPoolTest.Task> tasks);

    //销毁线程
    void destroy();
}
