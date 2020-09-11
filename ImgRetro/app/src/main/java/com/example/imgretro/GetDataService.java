package com.example.imgretro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("/v2/list")
    Call<List<RetroPhoto>> getAllPhotos();

}
