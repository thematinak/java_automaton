package org.example.anoita.materials.abst;

import org.example.anoita.util.MyRandom;

import java.util.Arrays;
import java.util.List;

public abstract class Particle extends Material {

    protected final static List<Move> movesL = Arrays.asList(DOWN, DOWN_LEFT, DOWN_RIGHT);
    protected final static List<Move> movesR = Arrays.asList(DOWN, DOWN_RIGHT, DOWN_LEFT);

    @Override
    protected List<Move> getPossibleMoves() {
        if (MyRandom.getRandom().nextBoolean()) {
            return movesL;
        } else {
            return movesR;
        }
    }

    @Override
    protected int getDensity() {
        return 10000;
    }
}
