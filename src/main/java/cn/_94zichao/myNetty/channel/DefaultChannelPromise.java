package cn._94zichao.myNetty.channel;

import cn._94zichao.myNetty.util.concurrent.MyFuture;
import cn._94zichao.myNetty.util.concurrent.MyFutureListener;
import cn._94zichao.myNetty.util.concurrent.MyPromise;

public class DefaultChannelPromise implements ChannelPromise {
    private final Channel channel;


    /**
     * Creates a new instance.
     *
     * @param channel
     *        the {@link Channel} associated with this future
     */
    public DefaultChannelPromise(Channel channel) {
        this.channel = channel;
    }

    @Override
    public Channel channel() {
        return null;
    }

    @Override
    public boolean trySuccess() {
        return false;
    }

    @Override
    public MyPromise<Void> addListener(MyFutureListener<? extends MyFuture<? super Void>> listener) {
        return null;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public MyFuture sync() {
        return null;
    }
}
