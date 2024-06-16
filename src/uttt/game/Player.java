package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;

public class Player implements PlayerInterface {
    private Symbol symbol;
    private Move move;

    public Player(Symbol sym) {
        this.symbol = sym;

    }

    @Override
    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public Move getPlayerMove(SimulatorInterface game, UserInterface ui) throws IllegalArgumentException {

        if (ui == null || (game.getIndexNextBoard() != -1 && game.isMovePossible(game.getIndexNextBoard()))) {
            throw new IllegalArgumentException("getPlayerMove exception");
        }

        move = ui.getUserMove();

        return move;
    }

}
