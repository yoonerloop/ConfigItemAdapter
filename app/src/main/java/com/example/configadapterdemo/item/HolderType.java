package com.example.configadapterdemo.item;

/**
 * date：2017/12/28 on 15:09
 * description:
 */

public enum HolderType {
    HeaderItem(0),ImageItem(1),TextItem(2),imageList(3),FooterItem(4);

    private int i;
    HolderType(int i) {
       this.i = i;
    }

    public int getValue(){
        return i;
    }
}
