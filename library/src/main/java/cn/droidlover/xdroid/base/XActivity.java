package cn.droidlover.xdroid.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.Unbinder;
import cn.droidlover.xdroid.kit.KnifeKit;

/**
 * Created by wanglei on 2016/11/27.
 */

public abstract class XActivity extends AppCompatActivity {
    protected Activity context;
    protected UiCallback uiDelegate;
    private Unbinder unbinder;

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void setListener();

    protected abstract int getLayoutId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.context = this;

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this);
        }
        setListener();
        initData(savedInstanceState);
    }


    protected UiCallback getUiDelegate() {
        if (uiDelegate == null) {
            uiDelegate = UiDelegateBase.create(this);
        }
        return uiDelegate;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getUiDelegate().resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getUiDelegate().pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != Unbinder.EMPTY) {
            unbinder.unbind();
        }
        getUiDelegate().destory();
    }
}
