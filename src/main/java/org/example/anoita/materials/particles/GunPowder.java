package org.example.anoita.materials.particles;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.abst.Particle;

public class GunPowder extends Particle implements Flammable {
    @Override
    protected Paint getColor() {
        return Color.DARKGRAY;
    }
}
