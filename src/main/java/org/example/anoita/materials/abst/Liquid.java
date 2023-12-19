package org.example.anoita.materials.abst;

import org.example.anoita.util.MyRandom;

import java.util.*;

public abstract class Liquid extends Material {

    protected final static List<Move> movesL = Arrays.asList(DOWN, LEFT, RIGHT);
    protected final static List<Move> movesR = Arrays.asList(DOWN, RIGHT, LEFT);

    @Override
    protected List<Move> getPossibleMoves() {
        if (MyRandom.getRandom().nextBoolean()) {
            return movesL;
        } else {
            return movesR;
        }
    }
}
