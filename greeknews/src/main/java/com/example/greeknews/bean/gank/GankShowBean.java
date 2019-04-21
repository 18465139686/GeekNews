package com.example.greeknews.bean.gank;

import java.io.Serializable;

/**
 * @author xts
 *         Created by asus on 2019/4/18.
 */

public class GankShowBean implements Serializable{
    public String title;
    public boolean isChecked;

    public GankShowBean(String title, boolean isChecked) {
        this.title = title;
        this.isChecked = isChecked;
    }
}
