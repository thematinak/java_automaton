package org.example.anoita.materials.ables;

import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.liquids.Water;

public interface Meltable {

    default Material setMelt() {
        return new Water();
    }
}
