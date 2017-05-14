package com.mianli.uband.api;

import com.mianli.uband.entity.BaseEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by jingpeng on 2017/5/14.
 */

public interface ApiService {

    @GET("jsSdkAuth")
    Observable<BaseEntity> jsSdkAuth();
}
