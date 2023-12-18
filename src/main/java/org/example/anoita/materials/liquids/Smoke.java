package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.Model;
import org.example.anoita.materials.abst.Liquid;

public class Smoke extends Liquid {
    int life = 35;

    @Override
    public void interact(Model model, int row, int col) {
        life -= 1;
        if (life < 0) {
            model.putToBord(row, col, new Air());
        }
    }

    @Override
    protected int getDensity() {
        return 90;
    }

    @Override
    protected Paint getColor() {
        return Color.LIGHTGRAY;
    }

    @Override
    public String toString() {
        return "S" + stepId;
    }
}
