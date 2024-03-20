package com.app.rickmorty.network;

import com.app.rickmorty.model.CharacterModel;
import com.app.rickmorty.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("character")
    Call<ResponseModel> getCharacters();

    @GET("character")
    Call<ResponseModel> getNextPage(
            @Query("page") int num
    );


}
