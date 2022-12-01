package com.harrypotter.controller;

import com.harrypotter.models.Actor;
import com.harrypotter.services.ActorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ActorServices actorServices;

    @GetMapping("/all")
    public ResponseEntity<List<Actor>> allCharacters(){
        List<Actor> actors = actorServices.findAll();
        if(actors.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actors);
    }

}
