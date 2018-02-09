package com.example.configadapterdemo.base;

import android.view.ViewGroup;

/**
 * item中每个条目的必要方法
 */
public interface Item {

    /**
     * 获取viewType
     * @return
     */
    public  int getItemType();

    /**
     * 创建ViewHolder
     * @param parent
     * @param viewType
     * @return
     */
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    /**
     * 数据绑定
     * @param holder
     * @param position
     */
    public  void onBindViewHolder(BaseViewHolder holder, int position);

}
