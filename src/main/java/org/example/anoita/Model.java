package org.example.anoita;

import kotlin.Pair;
import org.example.anoita.materials.abst.Move;
import org.example.anoita.materials.liquids.Air;
import org.example.anoita.materials.abst.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Model {
    int stepId = 0;

    public final static Pair<Integer, Integer> SIZE = new Pair<>(120, 80);
    public Material[][] bord;
    private List<Move> materialIdxs;

    public Model() {
        bord = new Material[SIZE.getFirst()][SIZE.getSecond()];
        materialIdxs = new ArrayList<>();
        for (int i = 0; i < bord.length; i++) {
            for (int j = 0; j < bord[i].length; j++) {
                bord[i][j] = new Air();
                materialIdxs.add(new Move(i, j));
            }
        }
    }

    public void makeMove() {
        Collections.shuffle(materialIdxs);
        for(var move: materialIdxs) {
            getFromBord(move.getRow(), move.getCol()).makeMove(this, move.getRow(), move.getCol(), stepId);
        }
        stepId++;

        for (int row = Model.SIZE.getFirst() - 1; row >= 0; row--) {
            for (int col = 0; col < Model.SIZE.getSecond(); col++) {
                getFromBord(row, col).interact(this, row, col);
            }
        }
    }

    public void swap(int row1, int col1, int row2, int col2) {
        var tmp = bord[row1][col1];
        bord[row1][col1] = bord[row2][col2];
        bord[row2][col2] = tmp;
    }

    public void putToBord(int row, int col, Material material) {
        bord[row][col] = material;
    }

    public Material getFromBord(int row, int col) {
        return bord[row][col];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.stream(bord).map(arr -> Arrays.toString(arr) + '\n').toArray());
    }
}
