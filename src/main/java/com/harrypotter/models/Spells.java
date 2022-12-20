package com.harrypotter.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "SPELLS")
public class Spells implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "Spell ID", dataType = "int", example = "38", position = 1 )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ApiModelProperty(value = "Spell's name", dataType = "String", example = "Avada Kedavra", position = 2 )
    private String name;
    @ApiModelProperty(value = "Spell's description", dataType = "String", example = "Also known as The Killing Curse, the most evil spell in the Wizarding World;", position = 3 )
    private String description;
    @ApiModelProperty(value = "The damage produced by the spell", dataType = "int", example = "99", position = 4 )
    private int damage;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "actor_spell",
            joinColumns = {@JoinColumn(name = "spell_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();
}
