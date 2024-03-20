package com.app.rickmorty.network;

import com.app.rickmorty.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("character")
    Call<ResponseModel> getCharacters();


}
