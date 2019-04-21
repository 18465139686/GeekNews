package com.example.greeknews.widget;

/**
 * Created by Lenovo on 2019/4/19.
 */

public interface TouchCallBack {
    //数据交换
    void onItemMove(int fromPosition, int toPosition);

    //删除条目
    void onItemDelete(int position);
}
