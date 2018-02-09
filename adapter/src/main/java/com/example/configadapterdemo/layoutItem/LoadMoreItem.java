package com.example.configadapterdemo.layoutItem;


import com.example.configadapterdemo.adapter.R;
import com.example.configadapterdemo.base.BaseItem;

/**
 * date：2018/1/8 on 15:39
 * description: 加载更多布局
 */
public class LoadMoreItem extends BaseItem {

    public LoadMoreItem(){
    }

    @Override
    public int getItemType() {
        return StatusType.LOADINGMORE_TYPE.getValue();
    }

    @Override
    public int inflateViewId() {
        return R.layout.item_list_load_more;
    }
}
