package cn.droidlover.xdroid.demo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroid.base.XActivity;
import cn.droidlover.xdroid.demo.R;
import cn.droidlover.xdroid.demo.model.Event;
import cn.droidlover.xdroid.event.BusFactory;
import cn.droidlover.xdroidbase.router.Router;


/**
 * Created by wanglei on 2016/12/9.
 */

public class AboutActivity extends XActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    public void initData(Bundle savedInstanceState) {
        initToolbar();

        BusFactory.getBus().post(new Event.TestEvent("EventBus测试"));
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_white_24dp);
        getSupportActionBar().setTitle("关于XDroid");
    }

    @Override
    public void setListener() {

    }

    @OnClick({
            R.id.tv_github
    })
    public void clickEvent(View view) {
        switch (view.getId()) {

            case R.id.tv_github:
                WebActivity.launch(context, "https://github.com/limedroid/XDroid", "XDroid");
                break;
        }
    }

    public static void launch(Activity activity) {
        Router.newIntent()
                .from(activity)
                .to(AboutActivity.class)
                .data(new Bundle())
                .launch();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }
}
