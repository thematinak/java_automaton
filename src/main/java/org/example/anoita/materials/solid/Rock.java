package org.example.anoita.materials.solid;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.abst.Solid;

public class Rock extends Solid {
    @Override
    protected Paint getColor() {
        return Color.GREY;
    }
}
