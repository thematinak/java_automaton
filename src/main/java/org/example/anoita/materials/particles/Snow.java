package org.example.anoita.materials.particles;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.FreezeMaker;
import org.example.anoita.model.Model;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.ables.Freezeble;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.abst.Particle;
import org.example.anoita.materials.liquids.Water;

public class Snow extends Particle implements Flammable, FreezeMaker {
    @Override
    protected Paint getColor() {
        return Color.LIGHTBLUE;
    }

    @Override
    public Material setFire() {
        return new Water();
    }

}
