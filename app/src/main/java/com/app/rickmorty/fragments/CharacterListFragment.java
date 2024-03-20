package com.app.rickmorty.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.rickmorty.R;
import com.app.rickmorty.activities.MainActivity;
import com.app.rickmorty.adapter.CharacterAdapter;
import com.app.rickmorty.databinding.FragmentCharacterDetailsBinding;
import com.app.rickmorty.databinding.FragmentCharacterListBinding;
import com.app.rickmorty.fragments.CharacterDetailsFragment;
import com.app.rickmorty.model.CharacterModel;
import com.app.rickmorty.viewmodels.CharacterViewModel;

import java.util.ArrayList;
import java.util.List;

public class CharacterListFragment extends Fragment {
    FragmentCharacterListBinding fragmentCharacterListBinding;
    private FragmentCharacterDetailsBinding fragmentCharacterDetailsBinding;
    private CharacterViewModel viewModel;
    private List<CharacterModel> charactersList = new ArrayList<>();
    private CharacterAdapter characterAdapter;
    MainActivity main;

    Context context;
    public CharacterListFragment(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_character_list, container, false);
        main = (MainActivity) context;
        main.doInitialization();
        return mView;
    }

}