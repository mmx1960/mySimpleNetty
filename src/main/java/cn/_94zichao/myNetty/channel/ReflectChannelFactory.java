package cn._94zichao.myNetty.channel;

public class ReflectChannelFactory implements ChannelFactory {

    public NioServerSocketChannel newChannel(Class clazz) {
        try {
            return (NioServerSocketChannel)clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("can not init");
        }
    }
}
