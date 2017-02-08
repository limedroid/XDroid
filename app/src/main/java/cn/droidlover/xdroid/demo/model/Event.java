package cn.droidlover.xdroid.demo.model;

import cn.droidlover.xdroid.event.IBus;

/**
 * Created by wanglei on 2012/2/8.
 */

public class Event {

    /**
     * 测试EventBus用到的实体
     */
    public static class TestEvent implements IBus.IEvent {

        public String name;

        public TestEvent(String name) {
            this.name = name;
        }

        @Override
        public int getTag() {
            return 10;
        }
    }

}
