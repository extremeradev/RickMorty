package com.app.rickmorty.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.app.rickmorty.adapter.CharacterAdapter;
import com.app.rickmorty.viewmodels.CharacterViewModel;
import com.app.rickmorty.R;
import com.app.rickmorty.databinding.ActivityMainBinding;
import com.app.rickmorty.model.CharacterModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private CharacterViewModel viewModel;
    private List<CharacterModel> charactersList = new ArrayList<>();
    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        doInitialization();


    }

    private void doInitialization(){
        activityMainBinding.characterRecyclerView.setHasFixedSize(true);
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        characterAdapter = new CharacterAdapter(charactersList);
        activityMainBinding.characterRecyclerView.setAdapter(characterAdapter);
        getCharacters();
    }

    private void getCharacters(){
        viewModel.getCharactersRickMorty().observe(this, characters -> {
            if ( characters != null){
                if(characters.getResults() != null){
                    charactersList.addAll(characters.getResults());
                    characterAdapter.notifyDataSetChanged();
                    for(CharacterModel c : charactersList){
                        System.out.println(c.getName());
                    }

                }
            }

        });


    }
}