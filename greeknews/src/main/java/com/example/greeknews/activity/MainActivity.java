package com.example.greeknews.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.greeknews.R;
import com.example.greeknews.base.BaseActivity;
import com.example.greeknews.bean.zhihu.SearchBean;
import com.example.greeknews.fragment.AboutFragment;
import com.example.greeknews.fragment.CollectionFragment;
import com.example.greeknews.fragment.GoldFragment;
import com.example.greeknews.fragment.gank.GankFragment;
import com.example.greeknews.fragment.SettingFragment;
import com.example.greeknews.fragment.V2EXFragment;
import com.example.greeknews.fragment.wechat.WechatFragment;
import com.example.greeknews.fragment.zhihu.ZhihuDailyNewsFragment;
import com.example.greeknews.presenter.AbouP;
import com.example.greeknews.utils.ToastUtil;
import com.example.greeknews.view.AboutV;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<AboutV, AbouP> implements AboutV {


    //周超  1808D

    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.nv)
    NavigationView mNv;
    @BindView(R.id.dl)
    DrawerLayout mDl;
    @BindView(R.id.toobla)
    Toolbar mToobla;
    @BindView(R.id.search_view)
    MaterialSearchView mSearchView;

    private ArrayList<Fragment> mfraglist;
    private ArrayList<Integer> mintents;
    private int mListFragmentposition;
    private FragmentManager manager;

    private final int TYPE_ZHIHU = 0;
    private final int TYPE_WECHAT = 1;
    private final int TYPE_GANK = 2;
    private final int TYPE_GOLD = 3;
    private final int TYPE_V2EX= 4;
    private final int TYPE_COLLECT = 5;
    private final int TYPE_SETTINGS = 6;
    private final int TYPE_ABOUT = 7;
    private MenuItem mSearchItem;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected AbouP initPresenter() {
        return new AbouP();
    }

    @Override
    protected void initView() {
        super.initView();
        manager = getSupportFragmentManager();

        mToobla.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mToobla);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDl, mToobla, R.string.about, R.string.about);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        mDl.addDrawerListener(toggle);
        toggle.syncState();

        initFragments();
        initTitles();
        addzhihuDailyNewsFragment();


    }

    private void addzhihuDailyNewsFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container,mfraglist.get(0));
        transaction.commit();

        mToobla.setTitle(mintents.get(0));
    }

    private void initTitles() {
        mintents = new ArrayList<>();
        mintents.add(R.id.zhihu);
        mintents.add(R.id.wechat);
        mintents.add(R.id.gank);
        mintents.add(R.id.gold);
        mintents.add(R.id.V2EX);
        mintents.add(R.id.collect);
        mintents.add(R.id.settings);
        mintents.add(R.id.about);
    }

    private void initFragments() {
        mfraglist = new ArrayList<>();
        mfraglist.add(new ZhihuDailyNewsFragment());
        mfraglist.add(new WechatFragment());
        mfraglist.add(new GoldFragment());
        mfraglist.add(new GankFragment());
        mfraglist.add(new V2EXFragment());
        mfraglist.add(new CollectionFragment());
        mfraglist.add(new SettingFragment());
        mfraglist.add(new AboutFragment());
    }

    @Override
    protected void initListener() {
        super.initListener();
        mNv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId != R.id.info_title && itemId != R.id.potions_title) {
                    item.setChecked(true);
                    switch (itemId) {
                        case R.id.zhihu:
                            switchFragment(TYPE_ZHIHU);
                            mToobla.setTitle(R.string.zhihu);
                            break;
                        case R.id.wechat:
                            switchFragment(TYPE_WECHAT);
                            mToobla.setTitle(R.string.wechat);
                            break;
                        case R.id.V2EX:
                            mSearchView.setVisibility(View.GONE);
                            switchFragment(TYPE_V2EX);
                            mToobla.setTitle(R.string.gank);
                            break;
                        case R.id.gold:
                            switchFragment(TYPE_GOLD);
                            mToobla.setTitle(R.string.gold);
                            break;
                        case R.id.gank:
                            switchFragment(TYPE_GANK);
                            mToobla.setTitle(R.string.V2EX);
                            break;
                        case R.id.collect:
                            switchFragment(TYPE_COLLECT);
                            mToobla.setTitle(R.string.collect);
                            break;
                        case R.id.settings:
                            switchFragment(TYPE_SETTINGS);
                            mToobla.setTitle(R.string.settings);
                            break;
                        case R.id.about:
                            switchFragment(TYPE_ABOUT);
                            mToobla.setTitle(R.string.about);
                            break;
                    }
                    mDl.closeDrawer(Gravity.LEFT);
                }else{
                    item.setChecked(false);
                }
                return false;
            }
        });


        mSearchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //按下搜索或者提交的时候回调,

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //搜索框内容发生改变的回调,
                //ToastUtil.showShort(newText);
                SearchBean searchBean = new SearchBean();
                searchBean.setTitle(newText);
                EventBus.getDefault().postSticky(searchBean);
                return false;
            }
        });

        mSearchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //搜索框展示
                //ToastUtil.showShort("展示");
            }

            @Override
            public void onSearchViewClosed() {
                //搜索框隐藏
                //ToastUtil.showShort("关闭");
            }
        });

    }

    private void switchFragment(int type) {
        //显示一个Fragment，隐藏一个Fragment
        //显示
        Fragment fragment=mfraglist.get(type);
        //需要隐藏
        Fragment fragment1 = mfraglist.get(mListFragmentposition);
        FragmentTransaction transaction = manager.beginTransaction();
        if (!fragment.isAdded()){
            transaction.add(R.id.fragment_container,fragment);
        }

        transaction.hide(fragment1);
        transaction.show(fragment);
        transaction.commit();

        mListFragmentposition = type;

        //显示或者隐藏搜索框
        if (type == TYPE_WECHAT || type == TYPE_GANK){
            mSearchItem.setVisible(true);
        }else {
            mSearchItem.setVisible(false);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);

        mSearchItem = menu.findItem(R.id.action_search);
        //隐藏搜索框
        mSearchItem.setVisible(false);
        mSearchView.setMenuItem(mSearchItem);

        return true;
    }

    /**
     * 回退键点击回调
     */
    @Override
    public void onBackPressed() {
        if (mSearchView.isSearchOpen()) {
            mSearchView.closeSearch();
        } else {
            super.onBackPressed();
        }
    }
}
