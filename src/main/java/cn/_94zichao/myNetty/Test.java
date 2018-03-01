package cn._94zichao.myNetty;

import cn._94zichao.myNetty.bootstrap.ServerBootstrap;
import cn._94zichao.myNetty.channel.NioServerSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
//        ServerBootstrap sb = new ServerBootstrap();
//        sb.channel(NioServerSocketChannel.class).bind(9999);
//        int val = 2;
//        int val1 = 16;
//        int val2 = 12;
//
//        System.out.println("数字："+val+" 计算后："+(val & -val));
//        System.out.println("数字："+val1+" 计算后："+(val1 & -val1));
//        System.out.println("数字："+val2+" 计算后："+(val2 & -val2));
        try {

            ServerSocketChannel serverSocketChannel = SelectorProvider.provider().openServerSocketChannel();
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            Selector selector = SelectorProvider.provider().openSelector();
            serverSocketChannel.register(selector,0,null);
            while (selector.selectNow() != 0){
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys){

                    SocketChannel accept = serverSocketChannel.accept();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
