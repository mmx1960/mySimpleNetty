package cn._94zichao.myNetty.channel;

import java.util.concurrent.Executor;

public interface EventLoop extends Executor {

    public ChannelFuture register(Channel channel);

}
