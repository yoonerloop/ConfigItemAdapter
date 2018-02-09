package com.example.configadapterdemo.layoutItem;

/**
 * date：2018/1/8 on 15:24
 * description: 加载的四种状体，加载空布局，加载中就，加载成功，加载失败
 */

public enum StatusType {
    EMPTY_TYPE(0x0001), LOADING_TYPE(0x0002), SUCCESSS_TYPE(0x0003), ERROR_TYPE(0x0004),LOADINGMORE_TYPE(0x0006);;

    private int i;

    StatusType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }
    }
