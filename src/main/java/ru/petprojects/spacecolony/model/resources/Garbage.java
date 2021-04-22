package ru.petprojects.spacecolony.model.resources;

import lombok.Data;

@Data
public class Garbage extends Resource {

    public Garbage() {
        super.weight = 10;
        super.energy = 0;
    }

}
