package com.example.greeknews.activity;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseActivity;
import com.example.greeknews.presenter.zhihu.TimeP;
import com.example.greeknews.view.zhihu.TimeV;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class TimeActivity extends BaseActivity<TimeV, TimeP> implements TimeV {

    @BindView(R.id.mcv)
    MaterialCalendarView mMcv;
    @BindView(R.id.tv_ok)
    TextView mTvOk;

    private String mCurrentDate;
    private String mFormat;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_time;
    }

    @Override
    protected TimeP initPresenter() {
        return new TimeP();
    }

    @Override
    protected void initView() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        mCurrentDate = sdf.format(date);

        mMcv.setOnDateChangedListener(new OnDateSelectedListener() {

            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                Date dateDate = date.getDate();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
                mFormat = sdf.format(dateDate);
            }
        });

        mTvOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    if (!mFormat.isEmpty()){
                        if (Integer.parseInt(mFormat)>Integer.parseInt(mCurrentDate)){
                            Toast.makeText(TimeActivity.this, "以后的新闻看不了哦，先看看以前的吧", Toast.LENGTH_SHORT).show();
                        }else {
                            EventBus.getDefault().post(mFormat);
                            finish();
                        }
                    }else {
                        finish();
                    }
                }catch (Exception e){
                    mFormat = "";
                }
            }
        });
    }
}
