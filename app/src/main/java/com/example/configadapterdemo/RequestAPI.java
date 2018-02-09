package com.example.configadapterdemo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * date：2017/12/28 on 17:53
 * description: retrofit网络请求参数
 */

public interface RequestAPI {

    @GET("/textcont.txt/")
    Call<DataBean> get();
}
