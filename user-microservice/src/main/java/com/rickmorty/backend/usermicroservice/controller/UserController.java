package com.rickmorty.backend.usermicroservice.controller;

import com.rickmorty.backend.usermicroservice.entity.User;
import com.rickmorty.backend.usermicroservice.model.Favorito;
import com.rickmorty.backend.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.getAll();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(users);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User userNew = userService.save(user);
        return ResponseEntity.ok(userNew);

    }

    @GetMapping("/favs/{userId}")
    public ResponseEntity<List<Favorito>> getFavs(@PathVariable("userId") int userId) {
        User user = userService.getUserById(userId);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            List<Favorito> favs = userService.getFavs(userId);
            return ResponseEntity.ok(favs);
        }
    }

    @PostMapping("/savefav/{userId}")
    public ResponseEntity<Favorito> saveFav(@PathVariable("userId") int userId, @RequestBody Favorito favorito) {
        if (userService.getUserById(userId) == null) {
            return ResponseEntity.notFound().build();
        } else{
            Favorito favNew = userService.saveFav(userId, favorito);
            return ResponseEntity.ok(favNew);
        }
    }

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String, Object>> getAllFavs(@PathVariable("userId") int userId) {
        Map<String, Object> result = userService.getUserAndFavs(userId);
        return ResponseEntity.ok(result);
    }

}
