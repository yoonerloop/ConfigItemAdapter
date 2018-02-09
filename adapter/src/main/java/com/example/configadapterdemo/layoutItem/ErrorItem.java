package com.example.configadapterdemo.layoutItem;


import com.example.configadapterdemo.adapter.R;
import com.example.configadapterdemo.base.BaseItem;

/**
 * date：2018/1/8 on 15:34
 * description: 加载、解析数据错误布局
 */

public class ErrorItem extends BaseItem {

    @Override
    public int getItemType() {
        return StatusType.ERROR_TYPE.getValue();
    }

    @Override
    public int inflateViewId() {
        return R.layout.error_layout;
    }
}
