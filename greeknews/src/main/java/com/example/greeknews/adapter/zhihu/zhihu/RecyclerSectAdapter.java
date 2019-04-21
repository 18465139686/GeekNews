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
import com.example.greeknews.bean.zhihu.SectionBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class RecyclerSectAdapter extends RecyclerView.Adapter {
    private ArrayList<SectionBean.DataBean> hotlist;
    private Context context;

    public RecyclerSectAdapter(ArrayList<SectionBean.DataBean> hotlist, Context context) {
        this.hotlist = hotlist;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.section_item,parent,false);

        return new RecyclerSectAdapter.HotView(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerSectAdapter.HotView newshold= (RecyclerSectAdapter.HotView) holder;
        SectionBean.DataBean recentBean = hotlist.get(position);
        newshold.name.setText(recentBean.getDescription());
        newshold.title.setText(recentBean.getName());
        Glide.with(context).load(recentBean.getThumbnail()).into(newshold.image);
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    public void setData(SectionBean data) {
        hotlist.clear();
        if (data.getData()!=null&&data.getData().size()>0){
            hotlist.addAll(data.getData());
        }
        notifyDataSetChanged();
    }

    class HotView extends RecyclerView.ViewHolder {
        @BindView(R.id.section_image)
        ImageView image;
        @BindView(R.id.section_name)
        TextView name;
        @BindView(R.id.section_title)
        TextView title;


        public HotView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
