package com.example.greeknews.bean.zhihu;

import java.util.List;

/**
 * Created by Lenovo on 2019/4/17.
 */

public class DailArtioBean {


    /**
     * date : 20190402
     * stories : [{"images":["https://pic2.zhimg.com/v2-13e357ce88226b24b9c6783b5f370d19.jpg"],"type":0,"id":9709768,"ga_prefix":"040222","title":"小事 · 姥姥眼睛里的光，越来越暗淡了"},{"title":"香港电影诞生考","ga_prefix":"040221","images":["https://pic2.zhimg.com/v2-7440b4fa3bc12c0e98cddde3f6cfd461.jpg"],"multipic":true,"type":0,"id":9709706},{"images":["https://pic2.zhimg.com/v2-e9069efa57e95df8c819524c6022429d.jpg"],"type":0,"id":9709700,"ga_prefix":"040219","title":"为什么我们日常见到的大多数爬行或哺乳动物，普遍进化成了四条腿？"},{"images":["https://pic4.zhimg.com/v2-28b2c2d32cce9d3b99a2de8335d158e7.jpg"],"type":0,"id":9709676,"ga_prefix":"040209","title":"看到玩具会想买，不买就一直哭闹，该如何与孩子沟通？"},{"title":"逐梦童模镇：妈妈，我们明天几点拍照？","ga_prefix":"040208","images":["https://pic4.zhimg.com/v2-e3350a8a7255cc82a979adadd91e62cb.jpg"],"multipic":true,"type":0,"id":9709684},{"title":"限制我们对智能产品想象力的，不是屏幕、相机，而是电池","ga_prefix":"040207","images":["https://pic2.zhimg.com/v2-d4952f87d0465550ea8a987c7e8b2849.jpg"],"multipic":true,"type":0,"id":9709679},{"images":["https://pic2.zhimg.com/v2-8916e3f5087f8c61e9cdb3bcefd10e01.jpg"],"type":0,"id":9709617,"ga_prefix":"040206","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["https://pic2.zhimg.com/v2-13e357ce88226b24b9c6783b5f370d19.jpg"]
         * type : 0
         * id : 9709768
         * ga_prefix : 040222
         * title : 小事 · 姥姥眼睛里的光，越来越暗淡了
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
