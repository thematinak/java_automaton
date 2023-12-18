package org.example.anoita.materials.particles;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.Model;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.ables.Freezeble;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.abst.Particle;
import org.example.anoita.materials.liquids.Water;

public class Snow extends Particle implements Flammable {
    @Override
    protected Paint getColor() {
        return Color.LIGHTBLUE;
    }

    @Override
    public Material setFire() {
        return new Water();
    }

    @Override
    public void interact(Model model, int row, int col) {
        for (var move: ALL_NEIGHBOR) {
            int nRow = row + move.getRow();
            int nCol= col + move.getCol();
            if(isInBound(0,nRow, Model.SIZE.getFirst()) && isInBound(0, nCol, Model.SIZE.getSecond())) {
                var mat = model.getFromBord(nRow, nCol);
                if (mat instanceof Freezeble) {
                    mat.interact(model, nRow, nCol);
                    model.putToBord(nRow, nCol, ((Freezeble) mat).setFreeze());
                }
            }
        }
    }
}