package com.mine.test.interfaces;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2019-01-23.
 */

public interface ApiService {
    @GET("users/{user}/repos")
    Call<List<Response>> listRepos(@Path("user") String user);
}
