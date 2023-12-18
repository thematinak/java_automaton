package org.example.anoita.materials.abst;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import org.example.anoita.Model;

import java.util.List;

public abstract class Material {

    protected static final Move UP = new Move(-1, 0);
    protected static final Move UP_LEFT = new Move(-1, -1);
    protected static final Move UP_RIGHT = new Move(-1, 1);
    protected static final Move DOWN = new Move(1, 0);
    protected static final Move LEFT = new Move(0, -1);
    protected static final Move RIGHT = new Move(0, 1);
    protected static final Move DOWN_LEFT = new Move(1, -1);
    protected static final Move DOWN_RIGHT = new Move(1, 1);
    protected static final List<Move> ALL_NEIGHBOR = List.of(UP, UP_LEFT, UP_RIGHT, LEFT, RIGHT, DOWN, DOWN_LEFT, DOWN_RIGHT);

    public int stepId = -1;
    private boolean canBeMoved = true;

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
            if(isInBound(0,nRow, Model.SIZE.getFirst()) && isInBound(0, nCol, Model.SIZE.getSecond())) {
                var mat = model.getFromBord(nRow, nCol);
                if (canMove(mat, move)) {
                    model.swap(row, col, nRow, nCol);
                    break;
                }
            }
        }
    }

    protected boolean canMove(Material other, Move m) {
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

    public static boolean isInBound(int min, int val, int max) {
        return min <= val && val < max;
    }

}
