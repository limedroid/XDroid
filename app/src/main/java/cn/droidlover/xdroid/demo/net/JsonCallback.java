package cn.droidlover.xdroid.demo.net;

import android.text.TextUtils;
import android.util.Log;

import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.net.UnknownHostException;
import java.util.concurrent.ThreadPoolExecutor;

import cn.droidlover.xdroid.demo.App;
import cn.droidlover.xdroid.demo.kit.AppKit;
import cn.droidlover.xdroidbase.cache.DiskCache;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by wanglei on 2016/12/11.
 */

public abstract class JsonCallback<T> extends Callback<T> {

    private long expireTime = -1L;        //缓存时间
    private Class<T> entityClass;

    public JsonCallback() {
        this(-1L);
    }

    public JsonCallback(long expireTime) {
        this.expireTime = expireTime;
        entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        if (e != null) {
            if (e instanceof UnknownHostException
                    && expireTime > -1) {
                //无网络连接
                String cacheKey = getCacheKey(call.request());
                String cacheContent = DiskCache.getInstance(App.getContext()).get(cacheKey);

                if (!TextUtils.isEmpty(cacheContent)) {
                    try {
                        if (entityClass == String.class) {
                            onResponse((T) cacheContent, id);
                            return;
                        }
                        T model = GsonProvider.getInstance().getGson().fromJson(cacheContent, entityClass);
                        onResponse(model, id);
                        return;

                    } catch (Exception exception) {
                    }
                }
            }
        }
        onFail(call, e, id);
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();

        //Cache
        if (expireTime > -1 && !TextUtils.isEmpty(string)) {
            String cacheKey = getCacheKey(response.request());
            DiskCache.getInstance(App.getContext()).put(cacheKey, string, expireTime);
        }

        if (entityClass == String.class) {
            return (T) string;
        }
        return GsonProvider.getInstance().getGson().fromJson(string, entityClass);
    }

    public abstract void onFail(Call call, Exception e, int id);

    /**
     * 获取缓存的key
     *
     * @param request
     * @return
     */
    private String getCacheKey(Request request) {
        String url = request.url().toString();
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            MediaType mediaType = requestBody.contentType();
            if (mediaType != null) {
                if (AppKit.isText(mediaType)) {
                    String bodyStr = AppKit.bodyToString(request);
                    return new StringBuilder(url).append(bodyStr).toString();
                }
            }
        }
        return url;
    }
}
