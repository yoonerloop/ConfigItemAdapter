package com.example.configadapterdemo.base;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.example.configadapterdemo.layoutItem.EmptyItem;
import com.example.configadapterdemo.layoutItem.ErrorItem;
import com.example.configadapterdemo.layoutItem.LoadMoreItem;
import com.example.configadapterdemo.layoutItem.LoadingItem;


/**
 * date：2018/1/9 on 13:42
 * description: 封装了请求数据失败，请求数据为空，数据正在加载，加载更多状态
 */

public class SimpleAdapter extends BaseAdapter {

    public static final int ERROR_TYPE = 1;
    public static final int EMPTY_TYPE = 2;
    public static final int LOADING_TYPE = 3;
    public static final int LOAD_MORE_TYPE = 4;

    private EmptyItem mEmptyItem;
    private ErrorItem mErrorItem;
    private LoadingItem mLoadingItem;
    private LoadMoreItem mLoadMoreItem;

    //LoadMore 是否已显示
    private boolean mIsShowLoadMore = false;
    private boolean mIsShowError = false;
    private boolean mIsShowLoading = false;
    private boolean mIsShowEmpty = false;

    public SimpleAdapter() {
        mEmptyItem = new EmptyItem();
        mErrorItem = new ErrorItem();
        mLoadingItem = new LoadingItem();
        mLoadMoreItem = new LoadMoreItem();
    }

    /**
     * 显示正在加载时候的View
     */
    public void showLoadingView() {
        clear();
        mIsShowLoading = true;
        add(mLoadingItem);
    }

    /**
     * 显示正在加载错误时候的View
     */
    public void showErrorView() {
        clear();
        mIsShowError = true;
        add(mErrorItem);
    }


    /**
     * 显示正在数据为空的View
     */
    public void showEmptyView() {
        clear();
        mIsShowEmpty = true;
        add(mEmptyItem);
    }


    /**
     * 显示正在加载更多的View
     */
    public void showLoadingMoreView() {
        if (mData.contains(mLoadMoreItem)) {
            return;
        }
        checkIsContainSpecailItem();
        mIsShowLoadMore = true;
        add(mLoadMoreItem);
    }

    /**
     * 隐藏加载空白数据
     */
    public void hideEmptyView() {
        if (mData.contains(mEmptyItem)) {
            remove(mEmptyItem);
            mIsShowEmpty = false;
        }
    }

    /**
     * 隐藏加载错误
     */
    public void hideErrorView() {
        if (mData.contains(mErrorItem)) {
            remove(mErrorItem);
            mIsShowError = false;
        }
    }

    /**
     * 隐藏正在加载
     */
    public void hideloadingView() {
        if (mData.contains(mLoadingItem)) {
            remove(mLoadingItem);
            mIsShowLoading = false;
        }
    }

    /**
     * 隐藏加载更多
     */
    public void hideLoadMoreView() {
        if (mData.contains(mLoadMoreItem)) {
            remove(mLoadMoreItem);
            mIsShowLoadMore = false;
        }
    }

    /**
     * View 是否已经显示
     */
    public boolean isShowLoadMore() {
        return mIsShowLoadMore;
    }


    public boolean isShowEmpty() {
        return mIsShowEmpty;
    }

    public boolean isShowLoading() {
        return mIsShowLoading;
    }

    public boolean isShowError() {
        return mIsShowError;
    }

    public void clear() {
        mIsShowError = false;
        mIsShowLoading = false;
        mIsShowEmpty = false;
        mIsShowLoadMore = false;
        super.clear();
    }

    /**
     * 检查列表是否已经包含了这4种item
     */
    private void checkIsContainSpecailItem() {
        if (mData.contains(mEmptyItem)) {
            mData.remove(mEmptyItem);
        }
        if (mData.contains(mErrorItem)) {
            mData.remove(mErrorItem);
        }
        if (mData.contains(mLoadingItem)) {
            mData.remove(mLoadingItem);
        }
        if (mData.contains(mLoadMoreItem)) {
            mData.remove(mLoadMoreItem);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        //处理GridView 布局
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    int viewType = getItemViewType(position);
                    return (viewType == ERROR_TYPE || viewType == EMPTY_TYPE || viewType == LOADING_TYPE
                            || viewType == LOAD_MORE_TYPE) ? gridLayoutManager.getSpanCount() : 1;
                }
            });
        }

    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        // 处理StaggeredGridLayoutManager 显示这个Span
        int position = holder.getAdapterPosition();
        int viewType = getItemViewType(position);
        if (isStaggeredGridLayout(holder)) {
            if (viewType == ERROR_TYPE || viewType == EMPTY_TYPE || viewType == LOADING_TYPE
                    || viewType == LOAD_MORE_TYPE) {

                StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) holder.itemView.getLayoutParams();
                //设置显示整个span
                params.setFullSpan(true);
            }
        }
    }

    /**
     * 判断是否是瀑布流布局
     *
     * @param holder
     * @return
     */
    private boolean isStaggeredGridLayout(RecyclerView.ViewHolder holder) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            return true;
        }
        return false;
    }
}
