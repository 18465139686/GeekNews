package com.example.greeknews.adapter.zhihu.wechat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.greeknews.R;
import com.example.greeknews.bean.wechat.WechatBean;
import com.example.greeknews.bean.zhihu.HotBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class RecyclerWechatAdapter extends RecyclerView.Adapter {

    private ArrayList<WechatBean.NewslistBean> hotlist;
    private Context context;

    public RecyclerWechatAdapter(ArrayList<WechatBean.NewslistBean> hotlist, Context context) {
        this.hotlist = hotlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wechat_item,parent,false);

        return new HotView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     HotView newshold= (HotView) holder;
        WechatBean.NewslistBean recentBean = hotlist.get(position);
        newshold.title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getPicUrl()).into(newshold.image);
        newshold.name.setText(recentBean.getDescription());
        newshold.time.setText(recentBean.getCtime());
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    public void setData(WechatBean data) {
        hotlist.clear();
        if (data.getNewslist() != null && data.getNewslist().size() > 0) {
            hotlist.addAll(data.getNewslist());
        }
        notifyDataSetChanged();
    }



    class HotView extends RecyclerView.ViewHolder {
        @BindView(R.id.wechat_image)
        ImageView image;
        @BindView(R.id.wechat_title)
        TextView title;
        @BindView(R.id.wechat_name)
        TextView name;
        @BindView(R.id.wechat_time)
        TextView time;


        public HotView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
