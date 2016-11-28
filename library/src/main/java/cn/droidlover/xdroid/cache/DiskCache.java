package cn.droidlover.xdroid.cache;

import android.content.Context;

import cn.droidlover.xdroid.kit.SingletonCtx;

/**
 * Created by wanglei on 2016/11/28.
 */

public class DiskCache extends SingletonCtx<DiskCache> implements ICache {

    @Override
    public void put(String key, Object value) {

    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    protected DiskCache newInstance(Context context) {
        return null;
    }
}
