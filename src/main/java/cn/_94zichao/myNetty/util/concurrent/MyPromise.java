package cn._94zichao.myNetty.util.concurrent;


public interface MyPromise<V> extends MyFuture<V>{

    boolean trySuccess();

    @Override
    MyPromise<V> addListener(MyFutureListener<? extends MyFuture<? super V>> listener);


}
