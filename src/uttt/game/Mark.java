package uttt.game;

import uttt.utils.Symbol;

public class Mark implements MarkInterface {

    private Symbol symbol;
    private int position;

    public Mark(Symbol s, int pos) {
        this.symbol = s;
        this.position = pos;
    }

    @Override
    public Symbol getSymbol() {
        return this.symbol;
    }

    @Override
    public int getPosition() {
        return this.position;
    }

    @Override
    public void setSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("NULL symbol for mark");
        }
        this.symbol = symbol;
    }

}
