package com.rickmorty.backend.favoritosmicroservice.repository;

import com.rickmorty.backend.favoritosmicroservice.entity.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavRepository extends JpaRepository<Favorito, Integer> {
    List<Favorito> findByUserId(int userId);
}
