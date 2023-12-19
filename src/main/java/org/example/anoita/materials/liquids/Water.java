package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.model.Model;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.ables.Freezeble;
import org.example.anoita.materials.ables.Wetable;
import org.example.anoita.materials.abst.Liquid;
import org.example.anoita.materials.abst.Material;

public class Water extends Liquid implements Flammable, Freezeble {

    @Override
    protected int getDensity() {
        return 1000;
    }

    @Override
    protected Paint getColor() {
        return Color.BLUE;
    }

    @Override
    public String toString() {
        return "W" + stepId;
    }

    @Override
    public void interact(Model model, int row, int col) {
        for (var move: ALL_NEIGHBOR) {
            int nRow = row + move.getRow();
            int nCol= col + move.getCol();
            if(isInBound(0,nRow, Model.SIZE.getFirst()) && isInBound(0, nCol, Model.SIZE.getSecond())) {
                var mat = model.getFromBord(nRow, nCol);
                if (mat instanceof Wetable) {
                    mat.interact(model, nRow, nCol);
                    model.putToBord(nRow, nCol, ((Wetable) mat).setWet());
                }
            }
        }
    }

    @Override
    public Material setFire() {
        return new HotSteam();
    }
}
