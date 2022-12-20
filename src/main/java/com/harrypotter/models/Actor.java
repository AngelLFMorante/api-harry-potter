package com.harrypotter.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ACTORS")
public class Actor implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Character ID", dataType = "Long", example = "1", position = 1 )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Character's name", dataType = "String", example = "Harry Potter", position = 2 )
    private String name;
    @ApiModelProperty(value = "Character Specimen", dataType = "String", example = "Human", position = 3 )
    private String species;
    @ApiModelProperty(value = "Character gender", dataType = "String", example = "Male", position = 4 )
    private String gender;
    @ApiModelProperty(value = "Which house corresponds to the character", dataType = "String", example = "Griffindor", position = 5 )
    private String house;
    @ApiModelProperty(value = "Confirmation if the character is a wizard", dataType = "boolean", example = "1", position = 6 )
    private boolean wizard;
    @ApiModelProperty(value = "Confirmation if the character is a student", dataType = "boolean", example = "1", position = 7 )
    private boolean hogwartsStudent;
    @ApiModelProperty(value = "Confirmation if the character is staff", dataType = "boolean", example = "0", position = 8 )
    private boolean hogwartsStaff;
    @ApiModelProperty(value = "Confirmation if the character is alive", dataType = "boolean", example = "1", position = 9 )
    private boolean alive;
    @ApiModelProperty(value = "Character image", dataType = "String", example = "harryPotter.jpg", position = 10 )
    private String image;
    @ApiModelProperty(value = "Attack power", dataType = "int", example = "36", position = 11 )
    private int attack;
    @ApiModelProperty(value = "Defense power", dataType = "int", example = "38", position = 12 )
    private int defense;

    @ManyToMany(mappedBy = "actors", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Spells> spells  = new ArrayList<>();
}
