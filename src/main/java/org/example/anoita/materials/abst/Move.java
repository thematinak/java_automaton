package org.example.anoita.materials.abst;

public final class Move {

    public static final Move UP = new Move(-1, 0);
    public static final Move UP_LEFT = new Move(-1, -1);
    public static final Move UP_RIGHT = new Move(-1, 1);
    public static final Move DOWN = new Move(1, 0);
    public static final Move LEFT = new Move(0, -1);
    public static final Move RIGHT = new Move(0, 1);
    public static final Move DOWN_LEFT = new Move(1, -1);
    public static final Move DOWN_RIGHT = new Move(1, 1);

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
