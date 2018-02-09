package com.example.configadapterdemo;


import com.example.configadapterdemo.base.Item;
import com.example.configadapterdemo.item.FooterItem;
import com.example.configadapterdemo.item.HeaderItem;
import com.example.configadapterdemo.item.HolderType;
import com.example.configadapterdemo.item.ImageItem;
import com.example.configadapterdemo.item.ImageListItem;
import com.example.configadapterdemo.item.TextItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 子类fragment布局，实现了：
 * 1、各种布局适配
 * 2、下拉刷新
 * 3、上拉加载
 */
public class MyFragment extends BaseFragment<DataBean.ResultBean.ContentBean> {

    private List<Item> mItems;

    /**
     * 下拉刷新逻辑处理
     */
    @Override
    protected void onPullRefresh() {
        mAdapter.remove(0);
        if (mAdapter.getItemCount()==0){
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.showEmptyView();
        }
        mRefreshlayout.setRefreshing(false);
    }

    /**
     * 上拉加载逻辑处理
     */
    @Override
    protected void onLoadingMore() {
        mAdapter.showLoadingMoreView();
        mRefreshlayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mAdapter.hideLoadMoreView();
                for (int i = 0; i < 3; i++) {
                    mAdapter.add(new FooterItem());
                }
            }
        }, 2000);
    }

    /**
     * 初始化数据，访问网络，网络请求
     */
    @Override
    protected void initData() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.222.46.40:8080")
                .build();

        RequestAPI api = retrofit.create(RequestAPI.class);
        api.get().enqueue(new Callback<DataBean>() {

            @Override
            public void onResponse(Call<DataBean> call, Response<DataBean> response) {
                mAdapter.hideErrorView();
                mAdapter.hideEmptyView();
                mAdapter.showLoadingView();
                DataBean body = response.body();
                List<DataBean.ResultBean.ContentBean> content = body.getResult().getContent();
                mItems = getItem(content);
                mAdapter.setData(mItems);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.hideloadingView();
            }

            @Override
            public void onFailure(Call<DataBean> call, Throwable t) {
                mAdapter.showErrorView();
            }
        });

    }

    /**
     * 对网络请求的数据进行处理，返回Adapter所有要传递参数的集合，集合内容是每个显示的item
     * @param list
     * @return
     */
    @Override
    protected List<Item> getItem(List<DataBean.ResultBean.ContentBean> list) {
        List<Item> items = new ArrayList<>();
        items.add(new HeaderItem());
        for (int i = 0; i < list.size(); i++) {
            String type = list.get(i).getType();
            if (type.equals(HolderType.ImageItem.getValue() + "")) {
                items.add(new ImageItem(list.get(i)));
            } else if (type.equals(HolderType.TextItem.getValue() + "")) {
                items.add(new TextItem(list.get(i)));
            } else if (type.equals(HolderType.imageList.getValue() + "")) {
                items.add(new ImageListItem(list.get(i)));
            } else {
                mAdapter.showEmptyView();
            }
        }
        items.add(new FooterItem());
        return items;
    }
}
