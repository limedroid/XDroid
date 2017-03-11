package cn.droidlover.xdroid.base;

import android.os.Bundle;

import butterknife.Unbinder;
import cn.droidlover.xdroid.event.BusFactory;
import cn.droidlover.xdroid.kit.KnifeKit;
import cn.droidlover.xdroidbase.base.LazyFragment;

/**
 * Created by wanglei on 2017/1/26.
 */

public abstract class XLazyFragment extends LazyFragment implements UiCallback {

    private UiDelegate uiDelegate;

    private Unbinder unbinder;

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this, getRealRootView());
        }
        if (useEventBus()) {
            BusFactory.getBus().register(this);
        }
        setListener();
        initData(savedInstanceState);
    }


    @Override
    protected void onDestoryLazy() {
        super.onDestoryLazy();
        if (useEventBus()) {
            BusFactory.getBus().unregister(this);
        }
        getUiDelegate().destory();
    }


    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public void setListener() {

    }

    protected UiDelegate getUiDelegate() {
        if (uiDelegate == null) {
            uiDelegate = UiDelegateBase.create(getContext());
        }
        return uiDelegate;
    }


}
