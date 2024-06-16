package uttt.game;

import uttt.UTTTFactory;
import uttt.utils.Symbol;

public class Board implements BoardInterface {

    private MarkInterface[] marks;

    public Board() {
        // Board board = new Board();
        marks = new Mark[9];
        for (int i = 0; i < 9; i++) {
            marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
        }
    }

    @Override
    public MarkInterface[] getMarks() {
        return marks;
    }

    @Override
    public void setMarks(MarkInterface[] marks) throws IllegalArgumentException {
        if (marks == null) {
            throw new IllegalArgumentException("marks are null");
        }
        for (int i = 0; i < 9; i++) {
            this.marks[i] = (Mark) marks[i];
        }
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int markIndex) throws IllegalArgumentException {
        if (marks == null || markIndex < 0 || markIndex > 8 || symbol == null) {
            throw new IllegalArgumentException("marks are null");
        }
        if (this.marks[markIndex].getSymbol() == Symbol.EMPTY) {
            this.marks[markIndex] = new Mark(symbol, markIndex);
            return true;
        }
        return false;

    }

    @Override
    public boolean isClosed() {
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[1].getSymbol()
                && marks[1].getSymbol() == marks[2].getSymbol())
            return true;
        if (marks[3].getSymbol() != Symbol.EMPTY && marks[3].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[5].getSymbol())
            return true;
        if (marks[6].getSymbol() != Symbol.EMPTY && marks[6].getSymbol() == marks[7].getSymbol()
                && marks[7].getSymbol() == marks[8].getSymbol())
            return true;

        // Vertical Wins
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[3].getSymbol()
                && marks[3].getSymbol() == marks[6].getSymbol())
            return true;
        if (marks[1].getSymbol() != Symbol.EMPTY && marks[1].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[7].getSymbol())
            return true;
        if (marks[2].getSymbol() != Symbol.EMPTY && marks[2].getSymbol() == marks[5].getSymbol()
                && marks[5].getSymbol() == marks[8].getSymbol())
            return true;

        // Diagonal Wins
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[8].getSymbol())
            return true;
        if (marks[2].getSymbol() != Symbol.EMPTY && marks[2].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[6].getSymbol())
            return true;

        for (int i = 0; i < 9; i++) {
            if (marks[i].getSymbol() == Symbol.EMPTY) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isMovePossible(int markIndex) throws IllegalArgumentException {

        if (markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("ma fik t7uto");
        }
        if (marks[markIndex].getSymbol() == Symbol.EMPTY) {
            return true;
        }
        return false;
    }

    @Override
    public Symbol getWinner() {
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[1].getSymbol()
                && marks[1].getSymbol() == marks[2].getSymbol())
            return marks[0].getSymbol();
        if (marks[3].getSymbol() != Symbol.EMPTY && marks[3].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[5].getSymbol())
            return marks[3].getSymbol();
        if (marks[6].getSymbol() != Symbol.EMPTY && marks[6].getSymbol() == marks[7].getSymbol()
                && marks[7].getSymbol() == marks[8].getSymbol())
            return marks[6].getSymbol();

        // Vertical Wins
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[3].getSymbol()
                && marks[3].getSymbol() == marks[6].getSymbol())
            return marks[0].getSymbol();
        if (marks[1].getSymbol() != Symbol.EMPTY && marks[1].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[7].getSymbol())
            return marks[1].getSymbol();
        if (marks[2].getSymbol() != Symbol.EMPTY && marks[2].getSymbol() == marks[5].getSymbol()
                && marks[5].getSymbol() == marks[8].getSymbol())
            return marks[2].getSymbol();

        // Diagonal Wins
        if (marks[0].getSymbol() != Symbol.EMPTY && marks[0].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[8].getSymbol())
            return marks[0].getSymbol();
        if (marks[2].getSymbol() != Symbol.EMPTY && marks[2].getSymbol() == marks[4].getSymbol()
                && marks[4].getSymbol() == marks[6].getSymbol())
            return marks[2].getSymbol();

        return Symbol.EMPTY;
    }

}
