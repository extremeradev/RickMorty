package com.app.rickmorty.network;

import com.app.rickmorty.model.CharacterModel;
import com.app.rickmorty.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("character")
    Call<ResponseModel> getCharacters();

    @GET("character/{id}")
    Call<CharacterModel> getCharacterByID(@Path("id") int id);


}
