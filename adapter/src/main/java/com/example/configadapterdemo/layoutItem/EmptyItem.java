package com.example.configadapterdemo.layoutItem;


import com.example.configadapterdemo.adapter.R;
import com.example.configadapterdemo.base.BaseItem;

/**
 * date：2018/1/8 on 15:33
 * description: 空布局
 */

public class EmptyItem extends BaseItem {

    @Override
    public int getItemType() {
        return StatusType.EMPTY_TYPE.getValue();
    }

    @Override
    public int inflateViewId() {
        return R.layout.empty_layout;
    }
}
