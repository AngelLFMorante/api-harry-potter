package com.harrypotter.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ActorNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ActorNotFoundException(Long id){
        super("No character with the id has been found: " .concat(id.toString()));
    }
}
