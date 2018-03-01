package cn._94zichao.myNetty.util.concurrent;

import java.util.ArrayList;
import java.util.List;

public class DefaultPromise implements MyPromise<Void> {

    private volatile Object result = null;
    private List<MyFutureListener<? extends MyFuture<?>>> listeners;
    private short waiters;
    @Override
    public boolean trySuccess() {
        result = new Object();
        checkNotify();
        for (MyFutureListener f: listeners
             ) {
            f.operationComplete(this);
        }

        return true;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isDone() {
        return result != null;
    }

    @Override
    public MyFuture<Void> sync() throws InterruptedException {
        if (isDone()){
            return this;
        }
        synchronized (this){
            while (!isDone()) {
            waiters++;
                try {
                    wait();
                }finally {
                    waiters--;
                }
            }
        }

        return this;
    }

    @Override
    public MyPromise<Void> addListener(MyFutureListener<? extends MyFuture<? super Void>> listener) {
        synchronized (this) {
            if(listeners == null){
                listeners = new ArrayList<MyFutureListener<? extends MyFuture<?>>>();
                listeners.add(listener);
            }else {
                listeners.add(listener);
            }
        }
        if (isDone()){
            for (MyFutureListener f: listeners
                    ) {
                f.operationComplete(this);
            }
        }
        return this;
    }
    private synchronized void checkNotify(){
        if (waiters > 0){
            notifyAll();
        }
    }
}
