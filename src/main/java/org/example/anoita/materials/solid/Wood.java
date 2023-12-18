package org.example.anoita.materials.solid;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.abst.Solid;

public class Wood extends Solid implements Flammable {

    @Override
    protected Paint getColor() {
        return Color.BROWN;
    }

}
