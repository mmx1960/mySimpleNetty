package cn._94zichao.myNetty.channel;

import java.nio.channels.SelectableChannel;

public abstract class AbstractNioChannel  implements Channel{
    private final SelectableChannel ch;


    public AbstractNioChannel(SelectableChannel ch) {
        this.ch = ch;
    }
}
