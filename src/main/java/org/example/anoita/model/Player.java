package org.example.anoita.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.anoita.controler.DrawBord;

public class Player {

    public final static int SIZE = 5;
    Color fuchsia = Color.rgb(255,0,255);
    int posRow;
    int posCol;


    public void render(GraphicsContext context2d) {
        final int size = SIZE * DrawBord.SIZE;
        context2d.setFill(fuchsia);
        context2d.fillRect(posCol * DrawBord.SIZE, posRow * DrawBord.SIZE, size, size);
    }

    public void setPos(int row, int col) {
        posRow = row;
        posCol = col;
    }

    public int getPosRow() {
        return posRow;
    }

    public int getPosCol() {
        return posCol;
    }

    public boolean isInPlayer(int row, int col) {
        return (posRow <= row && row < posRow + SIZE)
                && ((posCol <= col && col < posCol + SIZE));
    }
}
