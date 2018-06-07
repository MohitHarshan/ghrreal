package com.example.reubro.ghr.Retrofit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by reubro on 26/4/18.
 */

public interface Retrofitinterface {

public String BASE_URL="http://10.0.0.15/ghr/api/";


    @POST("login?")
    Call<Example> getdata(
            @Header("Authorization") String token,
            @Query("site_id") String site_id,
            @Query("password") String password);




}
