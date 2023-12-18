package org.example.anoita.materials.ables;

import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.liquids.Water;

public interface Wetable {

    default Material setWet() {
        return new Water();
    }
}
