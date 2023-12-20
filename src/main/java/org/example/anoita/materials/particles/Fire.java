package org.example.anoita.materials.particles;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.model.Model;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.ables.Wetable;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.abst.Particle;
import org.example.anoita.materials.liquids.Smoke;
import org.example.anoita.util.MyRandom;

public class Fire extends Particle implements Wetable {
    int life = 50;

    @Override
    public void interact(Model model, int row, int col) {
        life -= 1;
        if (life < 0) {
            model.putToBord(row, col, new Smoke());
        }
        for (var move: ALL_NEIGHBOR) {
            int nRow = row + move.getRow();
            int nCol= col + move.getCol();
            if(model.isInBound(nRow, nCol)) {
                var mat = model.getFromBord(nRow, nCol);
                if (mat instanceof Flammable) {
                    mat.interact(model, nRow, nCol);
                    model.putToBord(nRow, nCol, ((Flammable) mat).setFire());
                }
            }
        }
    }

    @Override
    public Material setWet() {
        return new Smoke();
    }

    @Override
    protected Paint getColor() {
        if (MyRandom.getRandom().nextInt(10) < 7) {
            return Color.RED;
        } else {
            return Color.YELLOW;
        }
    }

    @Override
    public String toString() {
        return "F" + stepId;
    }
}
