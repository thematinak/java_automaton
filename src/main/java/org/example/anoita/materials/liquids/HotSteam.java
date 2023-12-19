package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.model.Model;
import org.example.anoita.materials.abst.Liquid;

public class HotSteam extends Liquid {
    int life = 75;

    @Override
    protected int getDensity() {
        return 50;
    }

    @Override
    protected Paint getColor() {
        return Color.LIGHTBLUE;
    }

    @Override
    public void interact(Model model, int row, int col) {
        life -= 1;
        if (life < 0) {
            model.putToBord(row, col, new ColdSteam());
        }
    }
}
