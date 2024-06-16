package uttt.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.SimulatorInterface;
import uttt.utils.Symbol;

public class SimulatorInterfaceTest {

    // getBoards
    @Test
    public void testGetBoards() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Get the boards
        BoardInterface[] boards = simulator.getBoards();

        // Assert that the returned boards are not null
        assertNotNull(boards);

        // Assert that the number of boards is correct
        // assertEquals(9, boards.length);
    }

    @Test
    public void testGetBoardsFilled() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        BoardInterface board = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            board.setMarkAt(Symbol.CROSS, i);
        }

        BoardInterface[] boards = new BoardInterface[9];
        for (int i = 0; i < 9; i++) {
            boards[i] = board;
        }

        simulator.setBoards(boards);

        BoardInterface[] retrievedBoards = simulator.getBoards();

        // assertEquals(boards, retrievedBoards);
        for (int i = 0; i < 9; i++) {
            assertEquals(boards[i], retrievedBoards[i]);
        }

    }

    @Test
    public void testGetBoardsFilledNotEqual() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        BoardInterface board1 = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0)
                board1.setMarkAt(Symbol.CROSS, i);
            else
                board1.setMarkAt(Symbol.CIRCLE, i);
        }
        BoardInterface board2 = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 1)
                board2.setMarkAt(Symbol.CROSS, i);
            else
                board2.setMarkAt(Symbol.CIRCLE, i);
        }

        BoardInterface[] boards = new BoardInterface[9];
        for (int i = 0; i < 9; i++) {
            boards[i] = board1;
        }

        simulator.setBoards(boards);
        boards[0] = board2;

        BoardInterface[] retrievedBoards = simulator.getBoards();

        // assertEquals(boards, retrievedBoards);

        assertNotEquals(boards[0], retrievedBoards[0]);

    }

    // playerSymbok
    @Test
    public void testGetCurrentPlayerSymbolEqual() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol expectedSymbol = Symbol.CROSS;

        simulator.setCurrentPlayerSymbol(expectedSymbol);
        Symbol actualSymbol = simulator.getCurrentPlayerSymbol();

        assertEquals(expectedSymbol, actualSymbol);
    }

    // CurrentPlayerSYmbol
    @Test
    public void testGetCurrentPlayerSymbolNotEqual() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol expectedSymbol = Symbol.CIRCLE;

        simulator.setCurrentPlayerSymbol(Symbol.CROSS);
        Symbol actualSymbol = simulator.getCurrentPlayerSymbol();

        assertNotEquals(expectedSymbol, actualSymbol);
    }

    @Test
    public void testSetCurrentPlayerSymbol_NullSymbol() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = null;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setCurrentPlayerSymbol(symbol);
        });
    }

    /*
     * @Test
     * public void testSetMarkAtvalidSymbol() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * Symbol symbol = Symbol.CIRCLE;
     * int boardIndex = 0;
     * int markIndex = 1;
     * 
     * simulator.setCurrentPlayerSymbol(Symbol.CIRCLE);
     * Boolean res = simulator.setMarkAt(symbol, boardIndex, markIndex);
     * assertEquals(Symbol.CIRCLE, simulator.getCurrentPlayerSymbol());
     * assertTrue(res);
     * assertNotEquals(Symbol.CROSS, simulator.getCurrentPlayerSymbol());
     * 
     * }
     */
    @Test
    public void testSetMarkAtvalidSymbol() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CIRCLE;
        int boardIndex = 0;
        int markIndex = 1;

        simulator.setCurrentPlayerSymbol(Symbol.CIRCLE);
        Boolean res = simulator.setMarkAt(symbol, boardIndex, markIndex);
        BoardInterface[] current_boards = simulator.getBoards();

        assertEquals(Symbol.CIRCLE, current_boards[0].getMarks()[1].getSymbol());
        assertTrue(res);
        // assertNotEquals(Symbol.CROSS, current_boards[0].getMarks()[1]);

    }

    @Test
    public void testSetMarkNotCurrentPlayer() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CIRCLE;
        int boardIndex = 0;
        int markIndex = 1;

        simulator.setCurrentPlayerSymbol(Symbol.CROSS);

        assertThrows(IllegalArgumentException.class, () -> simulator.setMarkAt(symbol, boardIndex, markIndex));
    }

    @Test
    public void testSetMarkAtInvalidSymbolNULL() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        // Symbol symbol = Symbol.EMPTY;
        int boardIndex = 0;
        int markIndex = 1;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(null, boardIndex, markIndex);
        });
    }

    @Test
    public void testSetMarkAt_ValidCross() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = 2;
        int markIndex = 3;
        simulator.setCurrentPlayerSymbol(symbol);
        Boolean res = simulator.setMarkAt(symbol, boardIndex, markIndex);
        assertEquals(Symbol.CROSS, simulator.getCurrentPlayerSymbol());
        assertTrue(res);
        assertNotEquals(Symbol.CIRCLE, simulator.getCurrentPlayerSymbol());
    }

    @Test
    public void testSetMarkAt_Override() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = 2;
        int markIndex = 3;
        simulator.setCurrentPlayerSymbol(symbol);
        simulator.setMarkAt(symbol, boardIndex, markIndex);

        simulator.setCurrentPlayerSymbol(Symbol.CIRCLE);
        Boolean res = simulator.setMarkAt(Symbol.CIRCLE, boardIndex, markIndex);

        assertFalse(res);

    }

    @Test
    public void testSetMarkAt_InvalidBoardIndexNeg() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = -1;
        int markIndex = 1;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, boardIndex, markIndex);
        });
    }

    @Test
    public void testSetMarkAt_InvalidBoardIndexOutOfBounds() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = 10;
        int markIndex = 1;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, boardIndex, markIndex);
        });
    }

    @Test
    public void testSetMarkAt_InvalidMarkIndexNeg() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = 3;
        int markIndex = -2;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, boardIndex, markIndex);
        });
    }

    @Test
    public void testSetMarkAt_InvalidMarkIndexOutOfBounds() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        Symbol symbol = Symbol.CROSS;
        int boardIndex = 0;
        int markIndex = 9;

        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setMarkAt(symbol, boardIndex, markIndex);
        });
    }

    @Test
    public void testGetIndexNextBoard() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        int expectedIndex = 5;
        simulator.setIndexNextBoard(expectedIndex);

        int retrievedIndex = simulator.getIndexNextBoard();

        assertEquals(expectedIndex, retrievedIndex);
    }

    @Test
    public void testGetIndexNextBoard_NoRestriction() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // No restriction on the next board index
        int expectedIndex = -1;

        int retrievedIndex = simulator.getIndexNextBoard();

        assertEquals(expectedIndex, retrievedIndex);
    }

    @Test
    public void testGetIndexNextBoard_Custom() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }

        boards[4].setMarkAt(Symbol.CROSS, 0);
        boards[0].setMarkAt(Symbol.CIRCLE, 5);
        simulator.setBoards(boards);

        simulator.setIndexNextBoard(5);

        int retrieved = simulator.getIndexNextBoard();

        assertEquals(5, retrieved);

    }

    @Test
    public void testGetIndexNextBoard_Custom_FalseAssertion() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }

        boards[2].setMarkAt(Symbol.CROSS, 1);
        boards[1].setMarkAt(Symbol.CIRCLE, 7);
        simulator.setBoards(boards);

        simulator.setIndexNextBoard(7);

        int retrieved = simulator.getIndexNextBoard();

        assertNotEquals(3, retrieved);
    }

    @Test
    public void testSetIndexNextBoard_InvalidIndex() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Set an invalid index
        int invalidIndex = 10;

        // Assert that IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setIndexNextBoard(invalidIndex);
        });
    }

    @Test
    public void testSetIndexNextBoard_InvalidIndexNeg() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Set an invalid index
        int invalidIndex = -3;

        // Assert that IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> {
            simulator.setIndexNextBoard(invalidIndex);
        });
    }

    // GameOver
    @Test
    public void testIsGameOver_OnlyOneMove() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }

        boards[0].setMarkAt(Symbol.CIRCLE, 0);

        simulator.setBoards(boards);

        // Assert that the game is over
        assertFalse(simulator.isGameOver());
    }

    @Test
    public void testIsGameOver_PlayerWins() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }

        // Set a winning configuration on the boards
        boards[0].setMarkAt(Symbol.CROSS, 0);
        boards[0].setMarkAt(Symbol.CROSS, 1);
        boards[0].setMarkAt(Symbol.CROSS, 2);
        boards[3].setMarkAt(Symbol.CROSS, 3);
        boards[3].setMarkAt(Symbol.CROSS, 4);
        boards[3].setMarkAt(Symbol.CROSS, 5);
        boards[6].setMarkAt(Symbol.CROSS, 6);
        boards[6].setMarkAt(Symbol.CROSS, 7);
        boards[6].setMarkAt(Symbol.CROSS, 8);

        simulator.setBoards(boards);

        // Assert that the game is over
        assertTrue(simulator.isGameOver());
    }

    // isMovePossible
    /*
     * @Test
     * public void testIsMovePossible_ValidMove() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 0);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CIRCLE, 0, 1);
     * 
     * simulator.setIndexNextBoard(1);
     * simulator.setMarkAt(Symbol.CROSS, 1, 2);
     * 
     * boolean isMovePossible = simulator.isMovePossible(2);
     * boolean isMoveNotPossible = simulator.isMovePossible(5);
     * 
     * assertTrue(isMovePossible);
     * assertFalse(isMoveNotPossible);
     * }
     */

    public void testIsMovePossible_ValidMove() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }

        // Set a winning configuration on the boards
        boards[0].setMarkAt(Symbol.CROSS, 0);
        boards[0].setMarkAt(Symbol.CROSS, 1);
        boards[1].setMarkAt(Symbol.CROSS, 2);

        boolean isMovePossible = simulator.isMovePossible(2);
        boolean isMoveNotPossible = simulator.isMovePossible(5);

        assertTrue(isMovePossible);
        assertFalse(isMoveNotPossible);

    }

    /*
     * @Test
     * public void testIsMovePossible_InValidMove() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 0);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CIRCLE, 0, 1);
     * 
     * simulator.setIndexNextBoard(1);
     * simulator.setMarkAt(Symbol.CROSS, 1, 2);
     * 
     * boolean isMovePossible = simulator.isMovePossible(5);
     * 
     * assertFalse(isMovePossible);
     * }
     */

    @Test
    public void testIsMovePossible_NegativeIndex() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the index is negative
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(-1));
    }

    @Test
    public void testIsMovePossible_IndexOutOfRange() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the index is greater than
        // 8
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(9));
    }

    // is,MovePossible 3 args
    /*
     * @Test
     * public void testIsMovePossible3_ValidMove() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 0);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CIRCLE, 0, 1);
     * 
     * simulator.setIndexNextBoard(1);
     * simulator.setMarkAt(Symbol.CROSS, 1, 2);
     * 
     * // Assert that the move is possible on board index 2
     * assertTrue(simulator.isMovePossible(2, 0));
     * }
     */
    public void testIsMovePossible3_ValidInValidMove() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        BoardInterface board0 = UTTTFactory.createBoard();

        board0.setMarkAt(Symbol.CROSS, 0);
        board0.setMarkAt(Symbol.CIRCLE, 1);

        BoardInterface board1 = UTTTFactory.createBoard();

        board1.setMarkAt(Symbol.CROSS, 2);

        BoardInterface[] boards = new BoardInterface[9];
        boards[0] = board0;
        boards[1] = board1;

        for (int i = 2; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }
        simulator.setBoards(boards);

        // Assert that the move is possible on board index 2
        assertTrue(simulator.isMovePossible(2, 0));
        assertFalse(simulator.isMovePossible(5, 0));

    }

    /*
     * @Test
     * public void testIsMovePossible3_InValidMove() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 0);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CIRCLE, 0, 1);
     * 
     * simulator.setIndexNextBoard(1);
     * simulator.setMarkAt(Symbol.CROSS, 1, 2);
     * 
     * // Assert that the move is not possible on board index 5
     * assertFalse(simulator.isMovePossible(5, 0));
     * }
     */

    @Test
    public void testIsMovePossible3_NegativeIndex() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the board index is
        // negative
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(-1, 0));
    }

    @Test
    public void testIsMovePossible3_NegativeIndex2() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the board index is
        // negative
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(0, -1));
    }

    @Test
    public void testIsMovePossible3_IndexOutOfRange() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the board index is
        // greater than 8
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(9, 0));
    }

    @Test
    public void testIsMovePossible3_IndexOutOfRange2() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that IllegalArgumentException is thrown when the board index is
        // greater than 8
        assertThrows(IllegalArgumentException.class, () -> simulator.isMovePossible(7, 10));
    }

    // getWinner
    @Test
    public void testGetWinner_NoWinner() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Assert that the winner symbol is 'Empty' when there is no winner
        assertEquals(Symbol.EMPTY, simulator.getWinner());
    }

    /*
     * @Test
     * public void testGetWinner_PlayerXWins() {
     * SimulatorInterface simulator = UTTTFactory.createSimulator();
     * 
     * // Simulate a scenario where Player X wins the game
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 0);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 1);
     * 
     * simulator.setIndexNextBoard(0);
     * simulator.setMarkAt(Symbol.CROSS, 0, 2);
     * 
     * // Assert that the winner symbol is 'Cross' (Player X)
     * assertEquals(Symbol.CROSS, simulator.getWinner());
     * }
     */

    @Test
    public void testGetWinner_PlayerOWins() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();

        // Simulate a scenario where Player X wins the game
        BoardInterface[] boards = new BoardInterface[9];
        BoardInterface board0 = UTTTFactory.createBoard();

        board0.setMarkAt(Symbol.CIRCLE, 0);
        board0.setMarkAt(Symbol.CIRCLE, 1);
        board0.setMarkAt(Symbol.CIRCLE, 2);

        BoardInterface board1 = UTTTFactory.createBoard();

        board1.setMarkAt(Symbol.CIRCLE, 0);
        board1.setMarkAt(Symbol.CIRCLE, 4);
        board1.setMarkAt(Symbol.CIRCLE, 8);

        BoardInterface board2 = UTTTFactory.createBoard();

        board2.setMarkAt(Symbol.CIRCLE, 0);
        board2.setMarkAt(Symbol.CIRCLE, 3);
        board2.setMarkAt(Symbol.CIRCLE, 6);

        /*
         * simulator.setIndexNextBoard(0);
         * simulator.setMarkAt(Symbol.CIRCLE, 0, 0);
         * 
         * simulator.setIndexNextBoard(0);
         * simulator.setMarkAt(Symbol.CIRCLE, 0, 1);
         * 
         * simulator.setIndexNextBoard(0);
         * simulator.setMarkAt(Symbol.CIRCLE, 0, 2);
         */
        boards[0] = board0;
        boards[1] = board1;
        boards[2] = board2;

        for (int i = 3; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
        }
        simulator.setBoards(boards);

        // Assert that the winner symbol is 'CICRLE' (Player O)
        assertEquals(Symbol.CIRCLE, simulator.getWinner());

    }

    @Test
    public void testGetWinner_DrawWithNoPossibleMoves() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();

            boards[i].setMarkAt(Symbol.CROSS, 0);
            boards[i].setMarkAt(Symbol.CROSS, 1);
            boards[i].setMarkAt(Symbol.CIRCLE, 2);
            boards[i].setMarkAt(Symbol.CIRCLE, 3);
            boards[i].setMarkAt(Symbol.CROSS, 4);
            boards[i].setMarkAt(Symbol.CROSS, 5);
            boards[i].setMarkAt(Symbol.CROSS, 6);
            boards[i].setMarkAt(Symbol.CIRCLE, 7);
            boards[i].setMarkAt(Symbol.CIRCLE, 8);

        }
        simulator.setBoards(boards);

        // Assert that the winner symbol is 'Empty' indicating a draw
        assertEquals(Symbol.EMPTY, simulator.getWinner());
    }

    @Test
    public void testGetWinner_XWinsNoPossibleMoves() {
        SimulatorInterface simulator = UTTTFactory.createSimulator();
        BoardInterface[] boards = new BoardInterface[9];

        for (int i = 0; i < 9; i++) {
            boards[i] = UTTTFactory.createBoard();
            // Fill each board with alternating marks of 'Cross' and 'Circle'
            Symbol symbol = (i % 2 == 0) ? Symbol.CROSS : Symbol.CIRCLE;
            for (int j = 0; j < 9; j++) {
                // sus line

                boards[i].setMarkAt(symbol, j);
                symbol = (symbol == Symbol.CROSS) ? Symbol.CIRCLE : Symbol.CROSS;
            }

        }
        simulator.setBoards(boards);

        // Assert that the winner symbol is 'Empty' indicating a draw
        assertEquals(Symbol.CROSS, simulator.getWinner());
    }

}
