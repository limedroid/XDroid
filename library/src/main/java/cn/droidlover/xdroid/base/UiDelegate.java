package cn.droidlover.xdroid.base;

import android.view.View;

/**
 * Created by wanglei on 2016/12/1.
 */

public interface UiDelegate {

    void resume();
    void pause();
    void destory();

    void visible(boolean flag, View view);
    void gone(boolean flag, View view);
    void inVisible(View view);

    void toastShort(String msg);
    void toastLong(String msg);

}
