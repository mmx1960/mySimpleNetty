package cn._94zichao.myNetty.channel;

import java.net.InetSocketAddress;


public interface Channel {
    void bind(InetSocketAddress inetSocketAddress);
    void register();
    void register(EventLoop eventLoop, ChannelPromise promise);
}
