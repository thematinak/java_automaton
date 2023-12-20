package org.example.anoita.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import org.example.anoita.controler.DrawBord;

public class Player {

    Color fuchsia = Color.rgb(255,0,255);
    int posRow;
    int posCol;

    public void render(GraphicsContext context2d) {
        int size = 20;
        int half = size / 2;
        context2d.setFill(fuchsia);
        context2d.fillRect(posCol * DrawBord.SIZE - half, posRow * DrawBord.SIZE - half, size, size);
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
}
