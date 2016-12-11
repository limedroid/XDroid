package cn.droidlover.xdroid.demo.ui;

import cn.droidlover.xdroid.base.SimpleRecAdapter;
import cn.droidlover.xdroid.demo.adapter.GanhuoAdapter;
import cn.droidlover.xdroid.demo.adapter.HomeAdapter;
import cn.droidlover.xdroid.demo.model.GankResults;
import cn.droidlover.xrecyclerview.RecyclerItemCallback;
import cn.droidlover.xrecyclerview.XRecyclerView;

/**
 * Created by wanglei on 2016/12/10.
 */

public class GanhuoFragment extends BasePagerFragment {

    GanhuoAdapter adapter;

    @Override
    public SimpleRecAdapter getAdapter() {
        if (adapter == null) {
            adapter = new GanhuoAdapter(context);
            adapter.setRecItemClick(new RecyclerItemCallback<GankResults.Item, GanhuoAdapter.ViewHolder>() {
                @Override
                public void onItemClick(int position, GankResults.Item model, int tag, GanhuoAdapter.ViewHolder holder) {
                    super.onItemClick(position, model, tag, holder);
                    switch (tag) {
                        case GanhuoAdapter.TAG_VIEW:
                            WebActivity.launch(context, model.getUrl(), model.getDesc());
                            break;
                    }
                }
            });
        }
        return adapter;
    }

    @Override
    public void setLayoutManager(XRecyclerView recyclerView) {
        recyclerView.verticalLayoutManager(context);
    }

    @Override
    public String getType() {
        return "Android";
    }

    public static GanhuoFragment newInstance() {
        return new GanhuoFragment();
    }

}
