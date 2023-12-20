package org.example.anoita.materials.abst;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.example.anoita.model.Model;

import java.util.List;

import static org.example.anoita.materials.abst.Move.*;

public abstract class Material {

    protected static final List<Move> ALL_NEIGHBOR = List.of(UP, UP_LEFT, UP_RIGHT, LEFT, RIGHT, DOWN, DOWN_LEFT, DOWN_RIGHT);

    public int stepId = -1;

    public void render(GraphicsContext context2d, int row, int col, int size) {
        context2d.setFill(getColor());
        context2d.fillRect(col * size, row * size, size, size);
    }

    protected abstract int getDensity();

    protected abstract Paint getColor();

    protected abstract List<Move> getPossibleMoves();

    public void interact(Model model, int row, int col) {

    }

    public void makeMove(Model model, int row, int col, int stepId) {
        if (stepId == this.stepId) {
            return;
        }
        this.stepId = stepId;

        for (var move : getPossibleMoves()) {
            int nRow = row + move.getRow();
            int nCol= col + move.getCol();
            if(model.isInBound(nRow, nCol)) {
                if (canMove(row, col, move, model)) {
                    model.swap(row, col, nRow, nCol);
                    break;
                }
            }
        }
    }

    protected boolean canMove(int row, int col, Move m, Model model) {
        int nRow = row + m.getRow();
        int nCol= col + m.getCol();
        var other = model.getFromBord(nRow, nCol);
        if (m.getRow() < 0) {
            return canSwapUp(other);
        }
        if (m.getRow() > 0) {
            return canSwapDown(other);
        }
        // toSide
        if (m.getCol() < 0) {
            return canSwapLeft(other);
        } else {
            return canSwapRight(other);
        }

    }

    protected boolean canSwapLeft(Material other) {
        return other.getDensity() < getDensity();
    }

    protected boolean canSwapRight(Material other) {
        return other.getDensity() < getDensity();
    }

    protected boolean canSwapDown(Material other) {
        return other.getDensity() < getDensity();
    }

    protected boolean canSwapUp(Material other) {
        return other.getDensity() > getDensity();
    }

}
