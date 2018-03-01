package cn._94zichao.myNetty.util.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class MyNettyExecutor implements Executor {
    private ThreadFactory factory;

    public MyNettyExecutor(ThreadFactory factory) {
        this.factory = factory;
    }

    public void execute(Runnable command) {
        factory.newThread(command).start();
    }

    public static Executor newExecutor(){
        return new MyNettyExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
    }
}
