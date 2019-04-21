package com.example.greeknews.fragment.wechat;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.greeknews.R;
import com.example.greeknews.adapter.zhihu.wechat.RecyclerWechatAdapter;
import com.example.greeknews.base.BaseFragment;
import com.example.greeknews.bean.wechat.WechatBean;
import com.example.greeknews.bean.zhihu.SearchBean;
import com.example.greeknews.presenter.wechat.WeChatP;
import com.example.greeknews.view.WechatV;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class WechatFragment extends BaseFragment<WechatV,WeChatP> implements WechatV{

    @BindView(R.id.wechat_rlv)
    RecyclerView mrlv;

    private ArrayList<WechatBean.NewslistBean> lsit=new ArrayList<>();
    private RecyclerWechatAdapter adapter;
    private HashMap<String, Object> mMap;

    @Override
    protected WeChatP initPresenter() {
        return new WeChatP();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_wechat;
    }

    @Override
    protected void initView() {
        mEventBus.register(this);
        mMap = new HashMap<>();
        mMap.put("key","52b7ec3471ac3bec6846577e79f20e4c");
        mMap.put("num","20");
        mMap.put("page","1");

        mrlv.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RecyclerWechatAdapter(lsit,getContext());
        mrlv.setAdapter(adapter);

    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void Data(SearchBean bean){
        String s = bean.getTitle();

        if (s != null) {
            lsit.clear();
            HashMap<String,Object> map = new HashMap<>();
            map.put("key","52b7ec3471ac3bec6846577e79f20e4c");
            map.put("num","20");
            map.put("page","1");
            map.put("word",s);

            mPresenter.getwechat(map);
        }
    }

    @Override
    protected void initData() {
        mPresenter.getwechat(mMap);
    }

    @Override
    public void onSuccess(WechatBean wechatBean) {
        adapter.setData(wechatBean);
    }

    @Override
    public void onFail(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mEventBus.unregister(this);
    }
}
