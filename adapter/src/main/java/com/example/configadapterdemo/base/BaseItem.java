package com.example.configadapterdemo.base;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * date：2017/12/28 on 14:17
 * description: Item的基类
 */

public abstract class BaseItem<T> implements Item {
    public T data;

    public BaseItem(T data) {
        this.data = data;
    }
    public BaseItem() {
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(inflateViewId(), parent, false);
        return new BaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    /**
     * 创建viewholder的View
     */
    public abstract int inflateViewId();
}
