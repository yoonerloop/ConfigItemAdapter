package com.example.configadapterdemo.item;

import com.example.configadapterdemo.R;
import com.example.configadapterdemo.base.BaseItem;
import com.example.configadapterdemo.base.BaseViewHolder;
import com.example.configadapterdemo.DataBean;

/**
 * date：2017/12/28 on 14:49
 * description:
 */

public class ImageListItem extends BaseItem<DataBean.ResultBean.ContentBean> {
    public ImageListItem(DataBean.ResultBean.ContentBean data) {
        super(data);
    }

    @Override
    public int getItemType() {
        return HolderType.imageList.getValue();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.setImageUrl(R.id.image_content31, data.getUrl().get(0));
        holder.setImageUrl(R.id.image_content32, data.getUrl().get(0));
        holder.setImageUrl(R.id.image_content33, data.getUrl().get(0));
    }

    @Override
    public int inflateViewId() {
        return R.layout.item_list_content3;
    }
}
