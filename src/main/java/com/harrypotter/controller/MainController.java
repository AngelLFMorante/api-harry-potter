package com.harrypotter.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.harrypotter.errors.ActorNotFoundException;
import com.harrypotter.errors.ApiError;
import com.harrypotter.models.Actor;
import com.harrypotter.services.ActorServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ActorServices actorServices;

    @ApiOperation(value = "All characters", notes = "All the characters are obtained with all their corresponding information.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "OK", response = Actor.class),
            @ApiResponse(code=404, message = "Not Found", response = ApiError.class),
            @ApiResponse(code=500, message = "Internal Server Error", response = ApiError.class),
    })
    @GetMapping("/all")
    public ResponseEntity<List<Actor>> allCharacters(){
        List<Actor> actors = actorServices.findAll();
        if(actors.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actors);
    }

    @ApiOperation(value = "Obtain a character by id", notes = "All the information of a character is obtained by means of its identifier.")
    @ApiResponses(value = {
            @ApiResponse(code=200, message = "OK", response = Actor.class),
            @ApiResponse(code=404, message = "Not Found", response = ActorNotFoundException.class),
            @ApiResponse(code=500, message = "Internal Server Error", response = ApiError.class),
    })
    @GetMapping("/character/{id}")
    public Actor getOneCharacter(@PathVariable Long id){
        return actorServices.findById(id).orElseThrow(() -> new ActorNotFoundException(id));
    }

    //Exceptions
    @ExceptionHandler(ActorNotFoundException.class)
    public ResponseEntity<ApiError> handleActorNotFound(ActorNotFoundException ex){
        ApiError apiError = new ApiError();
        apiError.setState(HttpStatus.NOT_FOUND);
        apiError.setDateNow(LocalDateTime.now());
        apiError.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ApiError> handleBadRequestJsonMapping(JsonMappingException ex){
        ApiError apiError = new ApiError();
        apiError.setState(HttpStatus.BAD_REQUEST);
        apiError.setDateNow(LocalDateTime.now());
        apiError.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }


}
