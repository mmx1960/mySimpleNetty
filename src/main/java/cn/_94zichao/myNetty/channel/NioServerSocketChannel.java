package cn._94zichao.myNetty.channel;

import java.io.IOException;
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


}
