package cn._94zichao.myNetty.util.concurrent;



public interface MyFuture<V> {

    boolean isSuccess();

    boolean isDone();

    MyFuture<V> sync() throws InterruptedException;

    MyFuture<V> addListener(MyFutureListener<? extends MyFuture<? super V>> listener);


}
