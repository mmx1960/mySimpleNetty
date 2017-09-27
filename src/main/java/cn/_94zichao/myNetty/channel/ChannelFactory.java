package cn._94zichao.myNetty.channel;

public interface ChannelFactory<T extends Channel>{

    T newChannel();
}
