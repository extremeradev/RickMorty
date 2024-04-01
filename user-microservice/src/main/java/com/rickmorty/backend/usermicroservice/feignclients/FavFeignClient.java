package com.rickmorty.backend.usermicroservice.feignclients;

import com.rickmorty.backend.usermicroservice.model.Favorito;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "favoritos-microservice", url = "http://localhost:8002/fav")
public interface FavFeignClient {

    @PostMapping()
    Favorito save(@RequestBody Favorito fav);

    @GetMapping("/byuser/{userId}")
    List<Favorito> getFavs(@PathVariable("userId") int userId);

}
