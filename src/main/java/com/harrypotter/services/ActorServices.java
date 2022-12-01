package com.harrypotter.services;

import com.harrypotter.models.Actor;
import com.harrypotter.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServices {

    @Autowired
    private IActorRepository iCharacterRepository;

    public List<Actor> findAll(){
        return  iCharacterRepository.findAll();
    }
}
