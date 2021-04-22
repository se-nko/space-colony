package ru.petprojects.spacecolony.model.resources;

import lombok.Data;

@Data
public class Helium extends Resource {

    public Helium() {
        super.weight = 2;
        super.energy = 10;
    }

}
