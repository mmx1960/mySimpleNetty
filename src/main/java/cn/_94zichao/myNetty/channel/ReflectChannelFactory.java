package cn._94zichao.myNetty.channel;

public class  ReflectChannelFactory<T extends Channel> implements ChannelFactory<T> {

    private final Class<? extends T> clazz;

    public ReflectChannelFactory(Class clazz) {
        this.clazz = clazz;
    }

    public T newChannel() {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("can not init");
        }
    }

}
