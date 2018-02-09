package com.example.configadapterdemo;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.configadapterdemo.adapter.R;
import com.example.configadapterdemo.base.Item;
import com.example.configadapterdemo.base.SimpleAdapter;

import java.util.List;

/**
 * date：2018/1/9 on 10:24
 * description: fragment基类，子类只需要实现抽象方法即可，在方法里面做处理
 */
public abstract class BaseFragment<T> extends Fragment {

    public RecyclerView mRecyclerView;
    public SimpleAdapter mAdapter;
    public SwipeRefreshLayout mRefreshlayout;

    //是否正在滚动
    private boolean isSlidingToLast = false;
    //是否正再加载
    private LinearLayoutManager mLinearLayoutManager;
    private View mView;
    public Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_base, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = mView.findViewById(R.id.recycleview);
        mRefreshlayout = mView.findViewById(R.id.refreshlayout);

        mRecyclerView.setLayoutManager(setLayoutManger());
        mAdapter = new SimpleAdapter();
        mAdapter.showLoadingView();
        mRecyclerView.setAdapter(mAdapter);

        /**
         * 下拉刷新
         */
        mRefreshlayout.setColorSchemeResources(R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark);
        mRefreshlayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onPullRefresh();
                mRefreshlayout.setRefreshing(false);
            }
        });
        /**
         * 上拉加载
         */
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                //如果为null，第一次运行，确定布局类型
                int mLastVisiblePosition = -1;
                if (layoutManager instanceof LinearLayoutManager) {
                    mLastVisiblePosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
                } else if (layoutManager instanceof GridLayoutManager) {
                    mLastVisiblePosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
                } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                    int[] lastPositions = new int[staggeredGridLayoutManager.getSpanCount()];
                    staggeredGridLayoutManager.findLastVisibleItemPositions(lastPositions);
                    mLastVisiblePosition = findMax(lastPositions);
                } else {
                    throw new RuntimeException("LayoutManager should be LinearLayoutManager,GridLayoutManager,StaggeredGridLayoutManager");
                }

                RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
                int itemCount = manager.getItemCount();

                if (newState == RecyclerView.SCROLL_STATE_SETTLING && mLastVisiblePosition == itemCount - 1
                        && isSlidingToLast && canShowLoadMore()) {
                    showLoadMore();
                    onLoadingMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                //手指正向上滚动
                if (dy > 0) {
                    isSlidingToLast = true;
                } else {
                    isSlidingToLast = false;
                }
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    private RecyclerView.LayoutManager setLayoutManger() {
        mLinearLayoutManager = new LinearLayoutManager(mContext);
        return mLinearLayoutManager;
    }

    /**
     * 获取组数最大值
     *
     * @param lastPositions
     * @return
     */

    private int findMax(int[] lastPositions) {
        int max = lastPositions[0];
        for (int value : lastPositions) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * 判断是否可以显示LoadMore
     *
     * @return
     */
    private boolean canShowLoadMore() {
        if (mAdapter.isShowEmpty() || mAdapter.isShowLoadMore() || mAdapter.isShowError() || mAdapter.isShowLoading()) {
            return false;
        }
        return true;
    }

    /**
     * 展示加载更多
     */
    private void showLoadMore() {
        mAdapter.showLoadingMoreView();
    }

    /**
     * 设置进度条颜色背景
     */
    protected void setColorSchemeResources(@ColorRes int colorRes){
        mRefreshlayout.setColorSchemeResources(colorRes);
    }

    /**
     * 展示加载更多
     */
    private void hiddenLoadMore() {
        mAdapter.hideLoadMoreView();
    }


    /**
     * 下拉刷新
     */
    protected abstract void onPullRefresh();

    /**
     * 下拉加载
     */
    protected abstract void onLoadingMore();


    /**
     * 加载数据，有的可能是空布局，静态布局
     */
    protected abstract void initData();

    /**
     * 生成实体数据
     * @param list
     * @return
     */
    protected abstract  List<Item> getItem(List<T> list);
}
