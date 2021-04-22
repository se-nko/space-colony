package ru.petprojects.spacecolony.model.resources;

import lombok.Data;

@Data
public class Uranium extends Resource {

    public Uranium() {
        super.weight = 5;
        super.energy = 30;
    }

}
