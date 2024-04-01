package com.rickmorty.backend.favoritosmicroservice.service;

import com.rickmorty.backend.favoritosmicroservice.entity.Favorito;
import com.rickmorty.backend.favoritosmicroservice.repository.FavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavService {

    @Autowired
    FavRepository favRepository;

    public List<Favorito> getAll() {
        return favRepository.findAll();
    }

    public Favorito getUserById(int id) {
        return favRepository.findById(id).orElse(null);
    }

    public Favorito save(Favorito fav) {
        Favorito favoritoNew = favRepository.save(fav);
        return favoritoNew;
    }

    public List<Favorito> byUserId(int userId) {
        return favRepository.findByUserId(userId);
    }

}
