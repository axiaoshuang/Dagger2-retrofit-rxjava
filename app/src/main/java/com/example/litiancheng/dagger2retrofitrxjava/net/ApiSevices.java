package com.example.litiancheng.dagger2retrofitrxjava.net;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by litiancheng on 16/9/21.
 */

public interface ApiSevices {
    @GET("/article/list/suggest")
    Observable<Response<String>> getContent(@Query("page") int page);

}
