package cn.droidlover.xdroid.router;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by wanglei on 2016/11/29.
 */
public class Router {

    private Intent intent;
    private Activity from;
    private Class<?> to;
    private Bundle data;
    private int requestCode = -1;
    private int enterAnim;
    private int exitAnim;

    private static RouterCallback callback;

    private Router() {
        intent = new Intent();
    }

    public Router newIntent() {
        return new Router();
    }

    public Router from(Activity from) {
        this.from = from;
        return this;
    }

    public Router to(Class<?> to) {
        this.to = to;
        return this;
    }

    public Router data(Bundle data) {
        this.data = data;
        return this;
    }

    public Router requestCode(int requestCode) {
        this.requestCode = requestCode;
        return this;
    }

    public Router anim(int enterAnim, int exitAnim) {
        this.enterAnim = enterAnim;
        this.exitAnim = exitAnim;
        return this;
    }

    public void launch() {
        try {
            if (intent != null && from != null && to != null) {

                if (callback != null) {
                    callback.onBefore(from, to);
                }

                intent.setClass(from, to);

                if (data != null) {
                    intent.putExtras(data);
                }

                if (requestCode < 0) {
                    from.startActivity(intent);
                } else {
                    from.startActivityForResult(intent, requestCode);
                }

                if (enterAnim > 0 && exitAnim > 0) {
                    from.overridePendingTransition(enterAnim, exitAnim);
                }

                if (callback != null) {
                    callback.OnNext(from, to);
                }
            }
        } catch (Throwable throwable) {
            if (callback != null) {
                callback.onError(from, to, throwable);
            }
        }

    }

    public static void pop(Activity activity) {
        activity.finish();
    }

    public static void setCallback(RouterCallback callback) {
        Router.callback = callback;
    }
}
