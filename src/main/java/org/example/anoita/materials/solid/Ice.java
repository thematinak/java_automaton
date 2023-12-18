package org.example.anoita.materials.solid;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.abst.Solid;
import org.example.anoita.materials.liquids.Water;

public class Ice extends Solid implements Flammable {
    @Override
    protected Paint getColor() {
        return Color.LIGHTCYAN;
    }

    @Override
    public Material setFire() {
        return new Water();
    }
}
