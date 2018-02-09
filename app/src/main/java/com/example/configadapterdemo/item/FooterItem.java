package com.example.configadapterdemo.item;

import com.example.configadapterdemo.R;
import com.example.configadapterdemo.base.BaseItem;
import com.example.configadapterdemo.base.BaseViewHolder;
import com.example.configadapterdemo.DataBean;

/**
 * date：2017/12/28 on 14:49
 * description:
 */

public class FooterItem  extends BaseItem<DataBean.ResultBean.ContentBean>{

    @Override
    public int getItemType() {
        return HolderType.FooterItem.getValue();
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

    }

    @Override
    public int inflateViewId() {
        return R.layout.item_list_footer;
    }
}
