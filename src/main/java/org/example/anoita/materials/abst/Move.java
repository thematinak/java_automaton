package org.example.anoita.materials.abst;

public final class Move {
    private final int first;
    private final int second;

    public Move(int row, int col) {
        this.first = row;
        this.second = col;
    }

    public String toString() {
        return "" + '(' + this.first + ", " + this.second + ')';
    }

    public int getRow() {
        return first;
    }

    public int getCol() {
        return second;
    }
}
