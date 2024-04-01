package com.rickmorty.backend.favoritosmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FavoritosMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavoritosMicroserviceApplication.class, args);
	}

}
