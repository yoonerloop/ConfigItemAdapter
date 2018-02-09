package com.example.configadapterdemo.item;

import com.example.configadapterdemo.R;
import com.example.configadapterdemo.base.BaseItem;
import com.example.configadapterdemo.base.BaseViewHolder;
import com.example.configadapterdemo.DataBean;

/**
 * date：2017/12/28 on 14:49
 * description:
 */

public class TextItem extends BaseItem<DataBean.ResultBean.ContentBean> {
    public TextItem(DataBean.ResultBean.ContentBean data) {
        super(data);
    }

    @Override
    public int getItemType() {
        return HolderType.TextItem.getValue();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setText(R.id.text_content2,data.getText());
    }

    @Override
    public int inflateViewId() {
        return R.layout.item_list_content2;
    }
}
