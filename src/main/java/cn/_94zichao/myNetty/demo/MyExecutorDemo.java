package cn._94zichao.myNetty.demo;

import cn._94zichao.myNetty.util.concurrent.*;

import java.util.concurrent.Executor;

public class MyExecutorDemo {
    public static void main(String[] args) {

        MyFuture future = asyncHello().addListener((MyFutureListener<MyPromise<Void>>) future1 -> System.out.println("监听到完成"));
        if (future.isDone()){
            System.out.println("异步执行完成");
        }else{
            try {
                future.sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static MyFuture asyncHello(){
        Executor executor = MyNettyExecutor.newExecutor();
        final DefaultPromise promise = new DefaultPromise();
        executor.execute(() -> {
            System.out.println("Hello Async");
            try {
                //模拟一些操作
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            promise.trySuccess();
        });
        return promise;
    }
}
