package com.example.configadapterdemo.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * date：2017/12/28 on 14:16
 * description: ViewHolder 的数据设置
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> views;
    private View mItemView;

    public BaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
        mItemView = itemView;
    }

    /**
     * 获取ItemView
     *
     * @return
     */
    public View getItemView() {
        return mItemView;
    }

    public View getView(int resId) {
        return retrieveView(resId);
    }

    public TextView getTextView(int resId) {
        return retrieveView(resId);
    }

    public ImageView getImageView(int resId) {
        return retrieveView(resId);
    }

    private <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public void setText(int resId, CharSequence text) {
        getTextView(resId).setText(text);
    }

    public void setImageUrl(int resId, String url) {
        ImageView imageView = getImageView(resId);
        if (imageView == null) {
            throw new ExceptionInInitializerError("ImageView id is not exist");
        }
        Picasso.with(mItemView.getContext()).load(url).into(imageView);
    }
}
