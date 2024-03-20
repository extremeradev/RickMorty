package com.app.rickmorty.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.app.rickmorty.model.CharacterModel;
import com.app.rickmorty.model.ResponseModel;
import com.app.rickmorty.network.ApiClient;
import com.app.rickmorty.network.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RickMortyRepository {
    private ApiService apiService;

    public RickMortyRepository(){
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<ResponseModel> getCharacters(){
        MutableLiveData<ResponseModel> data = new MutableLiveData<>();
        apiService.getCharacters().enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                data.setValue(null);
            }

        });
        return data;
    }

    public LiveData<ResponseModel> getNextPage(int num){
        MutableLiveData<ResponseModel> data = new MutableLiveData<>();
        apiService.getNextPage(num).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if(response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                data.setValue(null);
            }

        });
        return data;
    }
}
