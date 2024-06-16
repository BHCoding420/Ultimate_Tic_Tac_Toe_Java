package uttt.game;

import uttt.utils.Move;
import uttt.utils.Symbol;
import uttt.UTTTFactory;

public class Simulator implements SimulatorInterface {
    private BoardInterface[] boards;
    private Symbol currentPlayerSymbol;
    private int indexNextBoard;

    public Simulator() {
        boards = new Board[9];
        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }
        indexNextBoard = -1;
        currentPlayerSymbol = Symbol.CROSS;

    }

    @Override
    public void run(PlayerInterface playerOne, PlayerInterface playerTwo, UserInterface ui)
            throws IllegalArgumentException {

        // Move current_move;
        // Symbol current_symbol;
        // int i = 0;

        // Move[] possible_moves = { playerOne.getPlayerMove(this, ui),
        // playerTwo.getPlayerMove(this, ui) };
        // Symbol[] possible_symbols = { playerOne.getSymbol(), playerTwo.getSymbol() };
        // setCurrentPlayerSymbol(playerOne.getSymbol());

        if (playerOne == null || playerTwo == null || ui == null) {
            throw new IllegalArgumentException("null in run");
        }

        Boolean playerOneturn = false;
        Move currMove;
        Boolean set_res = true;

        while (!isGameOver()) {

            playerOneturn = !playerOneturn;
            System.out.println("X turn ? " + playerOneturn);

            if (playerOneturn == true) {

                setCurrentPlayerSymbol(playerOne.getSymbol());
                ui.updateScreen(this);
                currMove = playerOne.getPlayerMove(this, ui);
                // while boards[currMove.getBoardIndex()].getMarks()[currMove.getMarkIndex()] !=

                // playerOneturn = false;
                set_res = setMarkAt(currentPlayerSymbol, currMove.getBoardIndex(), currMove.getMarkIndex());
                System.out.println("set_res : " + set_res);
                while (!set_res) {
                    currMove = playerOne.getPlayerMove(this, ui);
                    set_res = setMarkAt(currentPlayerSymbol, currMove.getBoardIndex(), currMove.getMarkIndex());
                    System.out.println("set_res : " + set_res);
                }

            } else {
                setCurrentPlayerSymbol(playerTwo.getSymbol());
                ui.updateScreen(this);
                currMove = playerTwo.getPlayerMove(this, ui);

                // playerOneturn = true;
                set_res = setMarkAt(currentPlayerSymbol, currMove.getBoardIndex(), currMove.getMarkIndex());
                System.out.println("set ? " + set_res);
                while (!set_res) {
                    currMove = playerTwo.getPlayerMove(this, ui);
                    // setCurrentPlayerSymbol(playerTwo.getSymbol());
                    // playerOneturn = true;
                    set_res = setMarkAt(currentPlayerSymbol, currMove.getBoardIndex(), currMove.getMarkIndex());
                    System.out.println("set ? " + set_res);
                }

            }

            // System.out.println(curr_move);
            /*
             * for (int i = 0; i < 9; i++) {
             * System.out.println("Move possible on board" + i + " : " + isMovePossible(i));
             * }
             */
            // System.out.println(isMovePossible(1));

            // i++;
            // ui.updateScreen(this);
            ui.updateScreen(this);

        }
        // System.out.println("Game over");
        ui.showGameOverScreen(this.getWinner());
    }

    @Override
    public BoardInterface[] getBoards() {
        return boards;
    }

    @Override
    public void setBoards(BoardInterface[] boards) throws IllegalArgumentException {
        if (boards == null) {
            throw new IllegalArgumentException("nuyll boards");
        }
        this.boards = boards;
    }

    @Override
    public Symbol getCurrentPlayerSymbol() {
        return currentPlayerSymbol;
    }

    @Override
    public void setCurrentPlayerSymbol(Symbol symbol) throws IllegalArgumentException {
        if (symbol == null) {
            throw new IllegalArgumentException("setCurrentPlayerSymbol null");
        }
        this.currentPlayerSymbol = symbol;
    }

    @Override
    public boolean setMarkAt(Symbol symbol, int boardIndex, int markIndex) throws IllegalArgumentException {
        if (symbol == null || boardIndex < 0 || boardIndex > 8 || markIndex < 0 || markIndex > 8
                || symbol != getCurrentPlayerSymbol()) {
            throw new IllegalArgumentException("illegal set mark at");
        }
        Boolean setMarkSimres;
        System.out.println("is move possible on board index = " + boardIndex + "and mark index = " + markIndex + " : "
                + isMovePossible(boardIndex, markIndex));
        if (!isMovePossible(boardIndex, markIndex)) {
            return false;
        }
        if (this.boards[markIndex].isClosed() == true) {
            setIndexNextBoard(-1);
            setMarkSimres = this.boards[boardIndex].setMarkAt(symbol, markIndex);

            return setMarkSimres;
        }

        else {
            setMarkSimres = this.boards[boardIndex].setMarkAt(symbol, markIndex);
            Boolean now_win = this.boards[markIndex].isClosed();
            if (now_win == true && setMarkSimres == true) {
                setIndexNextBoard(-1);
            } else if (setMarkSimres == true && !now_win) {

                setIndexNextBoard(markIndex);

            }
            return setMarkSimres;

        }
        // return this.boards[boardIndex].setMarkAt(symbol, markIndex);

    }

    @Override
    public int getIndexNextBoard() {
        return indexNextBoard;
    }

    @Override
    public void setIndexNextBoard(int index) throws IllegalArgumentException {
        if (index < -1 || index > 8) {
            throw new IllegalArgumentException("illegal set index next board");
        }
        this.indexNextBoard = index;
    }

    @Override
    public boolean isGameOver() {
        // winner by horizonatl rows
        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[1].getWinner()
                && boards[1].getWinner() == boards[2].getWinner())
            return true;
        if (boards[3].getWinner() != Symbol.EMPTY && boards[3].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[5].getWinner())
            return true;
        if (boards[6].getWinner() != Symbol.EMPTY && boards[6].getWinner() == boards[7].getWinner()
                && boards[7].getWinner() == boards[8].getWinner())
            return true;

        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[3].getWinner()
                && boards[3].getWinner() == boards[6].getWinner())
            return true;
        if (boards[1].getWinner() != Symbol.EMPTY && boards[1].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[7].getWinner())
            return true;
        if (boards[2].getWinner() != Symbol.EMPTY && boards[2].getWinner() == boards[5].getWinner()
                && boards[5].getWinner() == boards[8].getWinner())
            return true;

        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[8].getWinner())
            return true;
        if (boards[2].getWinner() != Symbol.EMPTY && boards[2].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[6].getWinner())
            return true;

        for (BoardInterface board : boards) {
            if (!board.isClosed())
                return false; // At least one board has a valid move, game is not over
        }

        return true;
    }

    @Override
    public boolean isMovePossible(int boardIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex > 8) {
            throw new IllegalArgumentException("out of bounds no move possible shu bek ya hmar");
        }

        Boolean board_to_check_closed = boards[boardIndex].isClosed();

        /*
         * if (board_to_check_closed == false) {
         * return false;
         * }
         */
        if (getIndexNextBoard() == -1) {
            // return true;

            return !board_to_check_closed;

        }

        if (boardIndex != indexNextBoard) {
            return false;
        }
        return (!board_to_check_closed) && (boards[boardIndex].isClosed());
    }

    @Override
    public boolean isMovePossible(int boardIndex, int markIndex) throws IllegalArgumentException {
        if (boardIndex < 0 || boardIndex > 8 || markIndex < 0 || markIndex > 8) {
            throw new IllegalArgumentException("out of bounds no move possible shu bek ya hmar");
        }

        if (getIndexNextBoard() == -1) {
            return true;
        }
        if (boardIndex != indexNextBoard) {
            return false;
        }
        return boards[boardIndex].isMovePossible(markIndex);

    }

    @Override
    public Symbol getWinner() {
        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[1].getWinner()
                && boards[1].getWinner() == boards[2].getWinner())
            return boards[0].getWinner();
        if (boards[3].getWinner() != Symbol.EMPTY && boards[3].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[5].getWinner())
            return boards[3].getWinner();
        if (boards[6].getWinner() != Symbol.EMPTY && boards[6].getWinner() == boards[7].getWinner()
                && boards[7].getWinner() == boards[8].getWinner())
            return boards[6].getWinner();

        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[3].getWinner()
                && boards[3].getWinner() == boards[6].getWinner())
            return boards[0].getWinner();
        if (boards[1].getWinner() != Symbol.EMPTY && boards[1].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[7].getWinner())
            return boards[1].getWinner();
        if (boards[2].getWinner() != Symbol.EMPTY && boards[2].getWinner() == boards[5].getWinner()
                && boards[5].getWinner() == boards[8].getWinner())
            return boards[2].getWinner();

        if (boards[0].getWinner() != Symbol.EMPTY && boards[0].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[8].getWinner())
            return boards[0].getWinner();
        if (boards[2].getWinner() != Symbol.EMPTY && boards[2].getWinner() == boards[4].getWinner()
                && boards[4].getWinner() == boards[6].getWinner())
            return boards[2].getWinner();

        return Symbol.EMPTY;
    }

}

/*
 * 
 * 
 * 
 * ChatGPT : for the getWinner() method,I wrote first the horizontal wins,and
 * then made chatGpt write the rest of the cases,to save time and make sure I
 * don't accidentally write false values that would take me long to notice
 */
