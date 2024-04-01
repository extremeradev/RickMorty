package com.rickmorty.backend.favoritosmicroservice.controller;

import com.rickmorty.backend.favoritosmicroservice.entity.Favorito;
import com.rickmorty.backend.favoritosmicroservice.service.FavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fav")
public class FavController {

    @Autowired
    FavService favService;

    @GetMapping
    public ResponseEntity<List<Favorito>> getAll() {
        List<Favorito> favs = favService.getAll();
        if (favs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favs);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Favorito> getById(@PathVariable("id") int id) {
        Favorito fav = favService.getUserById(id);
        if (fav == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(fav);
        }
    }

    @PostMapping
    public ResponseEntity<Favorito> save(@RequestBody Favorito fav) {
        Favorito favNew = favService.save(fav);
        return ResponseEntity.ok(favNew);

    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Favorito>> getByUserId(@PathVariable("userId") int userId) {
        List<Favorito> favs = favService.byUserId(userId);
        if (favs.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(favs);
        }
    }

}
