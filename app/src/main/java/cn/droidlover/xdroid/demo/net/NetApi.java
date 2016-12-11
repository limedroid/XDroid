package cn.droidlover.xdroid.demo.net;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;

import java.util.HashMap;

import cn.droidlover.xdroid.demo.model.GankResults;

/**
 * Created by wanglei on 2016/12/9.
 */

public class NetApi {

    public static void getGankData(String type, int pageSize, int pageNum, JsonCallback<GankResults> callback) {
        String url = UrlKit.getUrl(UrlKit.ACTION_DATA_RESULT);
        url = url.replace("{type}", type)
                .replace("{number}", "" + pageSize)
                .replace("{page}", "" + pageNum);

        invokeGet(url, null, callback);
    }


    private static void invokeGet(String url, HashMap params, Callback callback) {
        OkHttpUtils.get().url(url)
                .params(params == null ? new HashMap<String, String>() : params)
                .build()
                .execute(callback);
    }


}
