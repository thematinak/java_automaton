package org.example.anoita.materials.liquids;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import org.example.anoita.materials.ables.WetMaker;
import org.example.anoita.model.Model;
import org.example.anoita.materials.ables.Flammable;
import org.example.anoita.materials.ables.Freezeble;
import org.example.anoita.materials.ables.Wetable;
import org.example.anoita.materials.abst.Liquid;
import org.example.anoita.materials.abst.Material;

public class Water extends Liquid implements Flammable, Freezeble, WetMaker {

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
    public Material setFire() {
        return new HotSteam();
    }
}
