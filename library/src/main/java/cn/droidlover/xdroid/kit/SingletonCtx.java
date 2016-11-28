package cn.droidlover.xdroid.kit;

import android.content.Context;

/**
 * Created by wanglei on 2016/11/28.
 */

public abstract class SingletonCtx<T> {
    private T instance;

    protected abstract T newInstance(Context context);

    public final T getInstance(Context context) {
        if (instance == null) {
            synchronized (SingletonCtx.class) {
                if (instance == null) {
                    instance = newInstance(context.getApplicationContext());
                }
            }
        }
        return instance;
    }
}
