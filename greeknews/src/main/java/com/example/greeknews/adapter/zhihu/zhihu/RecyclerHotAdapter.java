package com.example.greeknews.adapter.zhihu.zhihu;

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
import com.example.greeknews.bean.zhihu.HotBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class RecyclerHotAdapter extends RecyclerView.Adapter {

    private ArrayList<HotBean.RecentBean> hotlist;
    private Context context;

    public RecyclerHotAdapter(ArrayList<HotBean.RecentBean> hotlist, Context context) {
        this.hotlist = hotlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.news_item,parent,false);

        return new HotView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     HotView newshold= (HotView) holder;
        HotBean.RecentBean recentBean = hotlist.get(position);
        newshold.title.setText(recentBean.getTitle());
        Glide.with(context).load(recentBean.getThumbnail()).into(newshold.image);
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    public void setData(HotBean data) {
        hotlist.clear();
        if (data.getRecent()!=null&&data.getRecent().size()>0){
            hotlist.addAll(data.getRecent());
        }
        notifyDataSetChanged();
    }

    class HotView extends RecyclerView.ViewHolder {
        @BindView(R.id.daily_image)
        ImageView image;
        @BindView(R.id.daily_title)
        TextView title;

        public HotView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
