package com.example.configadapterdemo.base;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * date：2017/12/28 on 14:29
 * description:  主要实现了创建ViewHolder，绑定数据，设置类型
 */

public class BaseAdapter<C extends BaseItem> extends RecyclerView.Adapter<BaseViewHolder> {

    public static final String TAG = "BaseAdapter";
    protected List<C> mData;

    public BaseAdapter() {
        mData = new ArrayList<>();
    }

    public void setData(List<C> data) {
        addAll(data);
        notifyDataSetChanged();
    }

    public List<C> getData() {
        return mData;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        for (int i = 0; i < getItemCount(); i++) {
            if (viewType == mData.get(i).getItemType()) {
                return mData.get(i).onCreateViewHolder(parent, viewType);
            }
        }
        throw new RuntimeException("onCreateViewHolder viewType is wrong");
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        mData.get(position).onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getItemType();
    }

    /**
     * 数据一个集合添加
     *
     * @param list
     */
    public void addAll(List<C> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Log.e(TAG, "addAll data size:" + list.size());
        mData.addAll(list);
        notifyItemRangeChanged(mData.size() - list.size(), mData.size());
    }

    public void addAll(int index, List<C> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        mData.addAll(index, list);
        notifyItemRangeChanged(index, index + list.size());
    }

    /**
     * 添加单个数据
     */
    public void add(C data) {
        mData.add(data);
        int index = mData.indexOf(data);
        notifyItemInserted(index);
    }

    public void add(int index, C data) {
        mData.add(index, data);
        notifyItemInserted(index);
    }

    /**
     * 移除单个数据
     */
    public void remove(C data) {
        int position = mData.indexOf(data);
        remove(position);
    }

    public void remove(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,mData.size()-position);
    }

    /**
     * 移除某个区间数集
     */
    public void remove(int start, int count) {
        if ((start + count) > mData.size()) {
            return;
        }
        mData.subList(start, start + count).clear();
        notifyItemRangeRemoved(start, count);
    }

    public void clear(){
        mData.clear();
        notifyDataSetChanged();
    }
}
