package com.app.rickmorty.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.rickmorty.R;
import com.app.rickmorty.activities.MainActivity;


public class CharacterDetailsFragment extends Fragment {

    Context context;

    public CharacterDetailsFragment(Context context){
        this.context = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_character_details, container, false);
        Toolbar toolbar = mView.findViewById(R.id.toolbar);
        if(toolbar != null){
            toolbar.setNavigationIcon(R.drawable.baseline_arrow_back_24);

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity main = (MainActivity) context;
                    if(main != null){
                        FragmentManager fragmentManager = main.getSupportFragmentManager();
                        if(fragmentManager!=null){
                            fragmentManager.beginTransaction()
                                    .replace(R.id.frameLayout, new CharacterListFragment(context))
                                    .addToBackStack("")
                                    .setReorderingAllowed(true)
                                    .commit();
                        }

                    }

                }
            });
        }

        return mView;
    }

}