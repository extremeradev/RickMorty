package com.app.rickmorty.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.app.rickmorty.R;
import com.app.rickmorty.databinding.ItemGridBinding;
import com.app.rickmorty.model.CharacterModel;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>{

    private List<CharacterModel> characters;
    private LayoutInflater layoutInflater;
    final CharacterAdapter.OnItemClickListener listener;
    public CharacterAdapter(List<CharacterModel> characters, CharacterAdapter.OnItemClickListener listener){
        this.characters = characters;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(CharacterModel c);
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(layoutInflater == null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        ItemGridBinding characterBinding = DataBindingUtil.inflate(
                layoutInflater, R.layout.item_grid, parent, false
        );
        return new CharacterViewHolder(characterBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.bindCharacter(characters.get(position));
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        private ItemGridBinding itemGridBinding;

        public CharacterViewHolder(ItemGridBinding itemGridBinding){
            super(itemGridBinding.getRoot());
            this.itemGridBinding = itemGridBinding;


        }

        public void bindCharacter(CharacterModel character){
            if(character != null){
                itemGridBinding.setCharacter(character);
                itemGridBinding.executePendingBindings();
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onItemClick(character);
                    }
                });
            }

        }
    }
}
