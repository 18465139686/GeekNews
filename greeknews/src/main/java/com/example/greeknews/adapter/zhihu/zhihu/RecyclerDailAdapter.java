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
import com.example.greeknews.bean.zhihu.DailArtioBean;
import com.example.greeknews.bean.zhihu.DailNewsBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class RecyclerDailAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<DailNewsBean.StoriesBean> mlist;
    private ArrayList<DailNewsBean.TopStoriesBean> mbanner;
    private static final int TYPE_BANNER = 0;
    private static final int TYPE_TIME = 1;
    private static final int TYPE_NEWS = 2;
    public String mData = "今日新闻";
    private List<DailArtioBean.StoriesBean> articleList;


    public RecyclerDailAdapter(Context context, ArrayList<DailNewsBean.StoriesBean> mlist, ArrayList<DailNewsBean.TopStoriesBean> mbanner) {
        this.context = context;
        this.mlist = mlist;
        this.mbanner = mbanner;
    }

    @Override
    public int getItemViewType(int position) {
        if (mbanner.size() > 0) {
            if (position == 0) {
                return TYPE_BANNER;
            } else if (position == 1) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        } else {
            if (position == 0) {
                return TYPE_TIME;
            } else {
                return TYPE_NEWS;
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if (viewType == TYPE_BANNER) {
            View inflate = inflater.inflate(R.layout.banner_item, null);
            return new BannerView(inflate);
        } else if (viewType == TYPE_TIME) {
            View inflate = inflater.inflate(R.layout.time_item, null);
            return new TimeView(inflate);
        } else {
            View inflate = inflater.inflate(R.layout.news_item,parent,false);
            return new NewsView(inflate);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_BANNER) {
            final BannerView bannerView = (BannerView) holder;
            bannerView.mBanner.setImages(mbanner).setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    DailNewsBean.TopStoriesBean banners = (DailNewsBean.TopStoriesBean) path;
                    Glide.with(context).load(banners.getImage()).into(imageView);
                }
            }).start();

        } else if (itemViewType == TYPE_TIME) {
            TimeView timeHold = (TimeView) holder;
            timeHold.mname.setText(mData);

        } else {
            NewsView newshold= (NewsView) holder;
            int positions = position - 1;
            if (mbanner.size() > 0) {
                positions -= 1;
            }

            DailNewsBean.StoriesBean storiesBean = mlist.get(positions);
            newshold.title.setText(storiesBean.getTitle());
            Glide.with(context).load(storiesBean.getImages().get(0)).into(newshold.image);
        }
    }

    @Override
    public int getItemCount() {
        if (mbanner.size() > 0) {
            return mlist.size() + 1 + 1;
        } else {
            return mlist.size() + 1;
        }
    }

    public void setData(DailNewsBean data) {
       mData=data.getDate();

       mbanner.clear();
       if (data.getTop_stories()!=null&&data.getTop_stories().size()>0){
           mbanner.addAll(data.getTop_stories());
       }

       mlist.clear();
       if (data.getStories()!=null&&data.getStories().size()>0){
           mlist.addAll(data.getStories());
       }
       notifyDataSetChanged();

    }

    public void addData(DailNewsBean dailNews) {
        List<DailNewsBean.StoriesBean> stories = dailNews.getStories();
        List<DailNewsBean.TopStoriesBean> top_stories = dailNews.getTop_stories();
        mbanner.clear();
        mlist.clear();
        mbanner.addAll(top_stories);
        mlist.addAll(stories);
        notifyDataSetChanged();
    }

    public void setArticleList(ArrayList<DailNewsBean.StoriesBean> articleList) {
        this.mlist = articleList;
    }


    class BannerView extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner mBanner;

        public BannerView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class TimeView extends RecyclerView.ViewHolder {
        @BindView(R.id.daily_name)
        TextView mname;

        public TimeView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class NewsView extends RecyclerView.ViewHolder {
        @BindView(R.id.daily_image)
        ImageView image;
        @BindView(R.id.daily_title)
        TextView title;

        public NewsView(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
