package com.example.configadapterdemo.item;

import com.example.configadapterdemo.R;
import com.example.configadapterdemo.base.BaseItem;
import com.example.configadapterdemo.base.BaseViewHolder;
import com.example.configadapterdemo.DataBean;

/**
 * date：2017/12/28 on 14:49
 * description:
 */

public class ImageItem extends BaseItem<DataBean.ResultBean.ContentBean> {
    public ImageItem(DataBean.ResultBean.ContentBean data) {
        super(data);
    }

    @Override
    public int getItemType() {
        return HolderType.ImageItem.getValue();
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setImageUrl(R.id.image_content1,data.getImage());
        holder.setText(R.id.text_content1,data.getDes());
    }

    @Override
    public int inflateViewId() {
        return R.layout.item_list_content1;
    }
}
