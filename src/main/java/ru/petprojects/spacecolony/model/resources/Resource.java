package ru.petprojects.spacecolony.model.resources;

import lombok.Data;

@Data
public abstract class Resource {

    Integer weight;
    Integer energy;

}
