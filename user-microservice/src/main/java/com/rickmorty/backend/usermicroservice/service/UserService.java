package com.rickmorty.backend.usermicroservice.service;

import com.rickmorty.backend.usermicroservice.entity.User;
import com.rickmorty.backend.usermicroservice.feignclients.FavFeignClient;
import com.rickmorty.backend.usermicroservice.model.Favorito;
import com.rickmorty.backend.usermicroservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FavFeignClient favFeignClient;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user) {
        User userNew = userRepository.save(user);
        return userNew;
    }

    public List<Favorito> getFavs(int userId) {
        List<Favorito> favs = restTemplate.getForObject("http://localhost:8002/fav/byuser/" + userId, List.class);
        return favs;
    }

    public Favorito saveFav(int userId, Favorito fav) {
        fav.setUserId(userId);
        Favorito favNew = favFeignClient.save(fav);
        return favNew;
    }

    public Map<String, Object> getUserAndFavs(int userId) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            result.put("Mensaje", "no existe el usuario");
            return result;
        } else {
            result.put("USER", user);

            List<Favorito> favs = favFeignClient.getFavs(userId);
            if (favs ==  null) {
                result.put("Favoritos", "ese user no tiene favoritos");
            } else {
                result.put("Favoritos", favs);
            }
            return result;
        }

    }

}
