package com.example.greeknews.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Lenovo on 2019/4/19.
 */

public class SimpleTouchHelperCallBack extends ItemTouchHelper.Callback{

    private TouchCallBack mcallBack;
    private boolean mSwipeEnable =true;

    public SimpleTouchHelperCallBack(TouchCallBack mcallBack) {
        this.mcallBack = mcallBack;
    }

    /**
     * 返回滑动的方向一般使用makeMovementFlags
     * (int,int) 或 makeFlag(int,int) 来构建我们的返回值
     * @param recyclerView
     * @param viewHolder
     * @return
     */
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //允许上下拖拽
        int drag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        //允许向左滑动,也可以向右
        int left = ItemTouchHelper.LEFT;

        return makeMovementFlags(drag,left);
    }

    /**
     * 拖动item时回调，可以回调Adapter的notifyItemMoved方法来交换两个ViewHolder的位置
     * 最后返回true，表示被拖动的ViewHolder已经移动到了目的位置
     * @param recyclerView
     * @param viewHolder
     * @param target
     * @return
     */
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
      mcallBack.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());
        return true;
    }

    /**
     * 当用户左右滑动item时达到删除条件就会调用,一般为一半,条目继续滑动删除,否则弹回
     * @param viewHolder
     * @param direction
     */
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        mcallBack.onItemDelete(viewHolder.getAdapterPosition());
    }

    /**
     * 支持长按拖动，默认是true
     * @return
     */
    @Override
    public boolean isLongPressDragEnabled() {
        return super.isLongPressDragEnabled();
    }

    /**
     * 支持滑动,即可以调用到onSwiped()方法,默认是true
     * @return
     */
    @Override
    public boolean isItemViewSwipeEnabled() {
        return mSwipeEnable;
    }

    /**
     * 设置是否支持滑动
     * @param enable
     */
    public void setSwipeEnable(boolean enable){
        mSwipeEnable = enable;
    }

}
