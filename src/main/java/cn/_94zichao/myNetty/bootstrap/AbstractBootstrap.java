package cn._94zichao.myNetty.bootstrap;

import cn._94zichao.myNetty.channel.Channel;
import cn._94zichao.myNetty.channel.ChannelFactory;
import cn._94zichao.myNetty.channel.EventLoop;
import cn._94zichao.myNetty.channel.ReflectChannelFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;

/**
 * @author Lenovo
 */
public abstract class AbstractBootstrap<B extends AbstractBootstrap<B,C>,C extends Channel> {

    private ChannelFactory<C> channelFactory;
    volatile EventLoop eventLoop;

    public AbstractBootstrap eventloop(EventLoop loop){
        this.eventLoop = loop;
        return this;
    }

    EventLoop loop(){
        return this.eventLoop;
    }
    public B channel(Class<cn._94zichao.myNetty.channel.NioServerSocketChannel> clazz){
        this.channelFactory = new ReflectChannelFactory<C>(clazz);
        return (B)this;
    }

    public B bind(Integer port){
        validate();
        doBind(port);
        return (B)this;
    }

    private  void doBind(Integer port){
        Channel channel = channelFactory.newChannel();

        loop().register(channel);

        channel.bind(new InetSocketAddress(port));

    }

    private void validate(){

    }



}
