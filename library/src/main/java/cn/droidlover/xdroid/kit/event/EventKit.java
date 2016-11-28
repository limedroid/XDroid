package cn.droidlover.xdroid.kit.event;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by wanglei on 2016/11/28.
 */

public class EventKit {

    public static void register(Object object) {
        if (!EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().register(object);
        }
    }

    public static void unregister(Object object) {
        if (EventBus.getDefault().isRegistered(object)) {
            EventBus.getDefault().unregister(object);
        }
    }

    public static void post(IEvent event) {
        EventBus.getDefault().post(event);
    }

    public static void postSticky(IEvent event) {
        EventBus.getDefault().postSticky(event);
    }


}
