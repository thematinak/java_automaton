package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.abst.Liquid;

public class Air extends Liquid {

    @Override
    protected int getDensity() {
        return 100;
    }

    @Override
    protected Paint getColor() {
        return Color.WHITESMOKE;
    }

    @Override
    public String toString() {
        return "A" + stepId;
    }
}
