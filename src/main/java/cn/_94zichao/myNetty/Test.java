package cn._94zichao.myNetty;

import cn._94zichao.myNetty.bootstrap.ServerBootstrap;
import cn._94zichao.myNetty.channel.NioServerSocketChannel;

public class Test {
    public static void main(String[] args) {
        ServerBootstrap sb = new ServerBootstrap();
        sb.channel(NioServerSocketChannel.class).bind(9999);

    }
}
