package org.example.anoita.materials.ables;

import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.particles.Fire;

public interface Flammable {

    default Material setFire(){
        return new Fire();
    }
}
