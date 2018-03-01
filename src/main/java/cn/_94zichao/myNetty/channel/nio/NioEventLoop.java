package cn._94zichao.myNetty.channel.nio;

import cn._94zichao.myNetty.channel.*;
import cn._94zichao.myNetty.util.concurrent.MyNettyExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;

public class NioEventLoop implements EventLoop {

    private final Executor executor;

    public NioEventLoop() {
        this.executor = MyNettyExecutor.newExecutor();
    }

    @Override
    public void execute(Runnable command) {
        this.executor.execute(command);
    }

    @Override
    public ChannelFuture register(Channel channel) {
        ChannelPromise promise = new DefaultChannelPromise(channel);
        channel.register(this,promise);
        return promise;
    }
}
