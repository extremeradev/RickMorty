package com.app.rickmorty.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.rickmorty.model.CharacterModel;
import com.app.rickmorty.model.ResponseModel;
import com.app.rickmorty.repositories.RickMortyRepository;

public class CharacterViewModel extends ViewModel {
    private RickMortyRepository charactersRepository;

    public CharacterViewModel(){
        charactersRepository = new RickMortyRepository();
    }

    public LiveData<ResponseModel> getCharactersRickMorty(){
        return charactersRepository.getCharacters();
    }

    public LiveData<CharacterModel> getCharacterByID(int id){
        return charactersRepository.getCharacterByID(id);
    }

}
