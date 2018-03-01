package cn._94zichao.myNetty.util.concurrent;

import java.util.EventListener;

public interface MyFutureListener<F extends MyFuture<?>>  extends EventListener {


    void operationComplete(F future);
}
