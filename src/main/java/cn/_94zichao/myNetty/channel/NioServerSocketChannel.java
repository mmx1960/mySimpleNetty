package cn._94zichao.myNetty.channel;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class NioServerSocketChannel extends AbstractNioChannel {

    public NioServerSocketChannel() {

       super(newSocket());
    }

    private static ServerSocketChannel newSocket(){
        try {
            return SelectorProvider.provider().openServerSocketChannel();
        } catch (IOException e) {
            throw new IllegalArgumentException("can not open socket");
        }
    }

    @Override
    protected ServerSocketChannel ch(){
        return (ServerSocketChannel) super.ch();
    }

    @Override
    protected  void doBind(SocketAddress localAddress) throws Exception{
        ch().socket().bind(localAddress);
    }


}
