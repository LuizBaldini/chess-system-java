package chess;

import boardgame.Position;

public class ChessPosition {

    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition");
        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    //Transforma o que o humano digitou no que o Java entende.
    protected Position toPosition() {
        return new Position(8 - row, column - 'a');
    }

    //Pega o que o Java calculou e mostra bonitinho pro humano.
    protected static ChessPosition fromPosition(Position position) {
        return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
    }

    @Override
    public String toString() {
        return "" + column + row;
    }
}
