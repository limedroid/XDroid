package cn.droidlover.xdroid.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by wanglei on 2016/11/27.
 */

public interface ILoader {

    void init(Context context);

    void loadImage(ImageView target, String url, Options option);

    void clearMemoryCache();

    void clearCache();


    class Options {

        public int loadingResId = RES_NONE;        //加载中的资源id
        public int loadErrorResId = RES_NONE;      //加载失败的资源id


        public static final int RES_NONE = -1;


        public Options(int loadingResId, int loadErrorResId) {
            this.loadingResId = loadingResId;
            this.loadErrorResId = loadErrorResId;
        }
    }

}
