package cn._94zichao.myNetty.bootstrap;

import cn._94zichao.myNetty.channel.Channel;
import cn._94zichao.myNetty.channel.ChannelFactory;
import cn._94zichao.myNetty.channel.ReflectChannelFactory;

import java.net.InetSocketAddress;

public abstract class AbstractBootstrap<B extends AbstractBootstrap<B,C>,C extends Channel> {

    private ChannelFactory<C> channelFactory;

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
        channel.bind(new InetSocketAddress(port));

    }

    public void validate(){

    }



}
