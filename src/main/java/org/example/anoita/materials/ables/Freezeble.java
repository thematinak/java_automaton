package org.example.anoita.materials.ables;

import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.solid.Ice;

public interface Freezeble {

    default Material setFreeze() {
        return new Ice();
    }
}
