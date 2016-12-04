package cn.droidlover.xdroid.event;

/**
 * Created by wanglei on 2016/11/28.
 */

public interface IBus {

    void register(Object object);
    void unregister(Object object);
    void post(IEvent event);
    void postSticky(IEvent event);


    interface IEvent {
        int getTag();
    }

}
