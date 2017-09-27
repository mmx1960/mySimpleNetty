package cn._94zichao.myNetty.channel;

import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectableChannel;

public abstract class AbstractNioChannel  implements Channel{
    private final SelectableChannel ch;


    public AbstractNioChannel(SelectableChannel ch) {
        this.ch = ch;
    }

    protected SelectableChannel ch() {
        return ch;
    }

    protected abstract void doBind(SocketAddress localAddress) throws Exception;

    public void bind(InetSocketAddress inetSocketAddress) {
        try {
            doBind(inetSocketAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
