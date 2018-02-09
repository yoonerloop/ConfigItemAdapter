package com.example.configadapterdemo.layoutItem;

import com.example.configadapterdemo.adapter.R;
import com.example.configadapterdemo.base.BaseItem;

/**
 * date：2018/1/8 on 15:34
 * description: 正在加载中
 */
public class LoadingItem extends BaseItem {

    @Override
    public int getItemType() {
        return StatusType.LOADING_TYPE.getValue();
    }

    @Override
    public int inflateViewId() {
        return R.layout.loading_layout;
    }
}
