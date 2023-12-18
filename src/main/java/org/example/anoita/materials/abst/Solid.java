package org.example.anoita.materials.abst;

import java.util.List;

public abstract class Solid extends Material {

    final static List<Move> EMPTY = List.of();

    @Override
    protected List<Move> getPossibleMoves() {
        return EMPTY;
    }

    @Override
    protected int getDensity() {
        return Integer.MAX_VALUE;
    }
}
