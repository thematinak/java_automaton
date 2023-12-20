package org.example.anoita.controler;

import javafx.scene.canvas.GraphicsContext;
import org.example.anoita.model.Model;
import org.example.anoita.model.Player;

public class DrawBord {

    public static final int SIZE = 5;
    private final Controller c;

    public DrawBord(Controller controller) {
        this.c = controller;
    }

    public void draw(Model model){
        GraphicsContext ctx = c.canvas.getGraphicsContext2D();
        for (int row = 0; row < Model.SIZE.getFirst(); row++) {
            for (int col = 0; col < Model.SIZE.getSecond(); col++) {
                model.getFromBord(row, col).render(ctx, row, col, SIZE);
            }
        }
        Player p = model.getPlayer();
        if(p != null) {
            p.render(ctx);
        }
    }

    public int getRow(int y) {
        int idx = y / SIZE;
        return Integer.max(0, Integer.min(Model.SIZE.getFirst(), idx));
    }

    public int getCol(int x) {
        int idx = x / SIZE;
        return Integer.max(0, Integer.min(Model.SIZE.getSecond(), idx));
    }
}
