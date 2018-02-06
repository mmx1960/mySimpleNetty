package cn._94zichao.myNetty.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @author Lenovo
 */
public abstract class AbstractNioChannel  implements Channel{
    private final SelectableChannel ch;
    protected final int readInterestOp;
    volatile SelectionKey selectionKey;


    public AbstractNioChannel(SelectableChannel ch, int readInterestOp) {
        this.ch = ch;
        this.readInterestOp = readInterestOp;
    }

    protected SelectableChannel ch() {
        return ch;
    }

    protected abstract void doBind(SocketAddress localAddress) throws Exception;

   @Override
    public void bind(InetSocketAddress inetSocketAddress) {
        try {
            doBind(inetSocketAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void register(){
        try {
            register(Selector.open());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void register(Selector selector) throws ClosedChannelException {
        ch().register(selector,0,null);
    }
}
