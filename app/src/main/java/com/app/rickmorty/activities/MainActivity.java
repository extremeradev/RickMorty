package com.app.rickmorty.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.app.rickmorty.fragments.CharacterDetailsFragment;
import com.app.rickmorty.adapter.CharacterAdapter;
import com.app.rickmorty.databinding.FragmentCharacterDetailsBinding;
import com.app.rickmorty.databinding.FragmentCharacterListBinding;
import com.app.rickmorty.viewmodels.CharacterViewModel;
import com.app.rickmorty.R;
import com.app.rickmorty.model.CharacterModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentCharacterListBinding fragmentCharacterListBinding;
    private FragmentCharacterDetailsBinding fragmentCharacterDetailsBinding;
    private CharacterViewModel viewModel;
    private List<CharacterModel> charactersList = new ArrayList<>();
    private CharacterAdapter characterAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doInitialization();


    }

    public void doInitialization(){
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        setContentView(R.layout.fragment_character_list);
        fragmentCharacterListBinding = DataBindingUtil.setContentView(this, R.layout.fragment_character_list);
        if (fragmentCharacterListBinding != null){
            fragmentCharacterListBinding.characterRecyclerView.setLayoutManager(mLayoutManager);
            fragmentCharacterListBinding.characterRecyclerView.setHasFixedSize(true);
            characterAdapter = new CharacterAdapter(charactersList, new CharacterAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(CharacterModel c) {
                    openDesc(c);
                }
            });
            fragmentCharacterListBinding.characterRecyclerView.setAdapter(characterAdapter);
            getCharacters();
        }

    }

    public void getCharacters(){
        viewModel.getCharactersRickMorty().observe(this, characters -> {
            if ( characters != null){
                if(characters.getResults() != null){
                    charactersList.addAll(characters.getResults());
                    characterAdapter.notifyDataSetChanged();
                }
            }

        });

    }
    public void openDesc(CharacterModel c){
        fragmentCharacterDetailsBinding = DataBindingUtil.setContentView(this, R.layout.fragment_character_details);
        if(fragmentCharacterListBinding != null){
            fragmentCharacterDetailsBinding.setCharacter(c);
            fragmentCharacterDetailsBinding.executePendingBindings();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frameLayout, new CharacterDetailsFragment(this))
                    .addToBackStack("")
                    .setReorderingAllowed(true)
                    .commit();
        }

    }
}