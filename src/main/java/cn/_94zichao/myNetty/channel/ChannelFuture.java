package cn._94zichao.myNetty.channel;

import cn._94zichao.myNetty.channel.Channel;
import cn._94zichao.myNetty.util.concurrent.MyFuture;

public interface ChannelFuture extends MyFuture<Void> {

    Channel channel();

}
