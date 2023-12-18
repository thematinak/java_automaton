package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.abst.Liquid;

public class Oil extends Liquid implements Flammable {
    @Override
    protected int getDensity() {
        return 900;
    }

    @Override
    protected Paint getColor() {
        return Color.BLACK;
    }
}
