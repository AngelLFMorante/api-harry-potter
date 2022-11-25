package com.harrypotter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @GetMapping("/all")
    public List<Character> allCharacters(){
        return null;
    }

}
