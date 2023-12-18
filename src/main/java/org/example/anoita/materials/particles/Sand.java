package org.example.anoita.materials.particles;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.abst.Particle;

public class Sand extends Particle {

    @Override
    protected Paint getColor() {
        return Color.SANDYBROWN;
    }

    @Override
    public String toString() {
        return "S" + stepId;
    }
}
