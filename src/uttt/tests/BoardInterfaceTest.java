package uttt.tests;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.BoardInterface;
import uttt.game.MarkInterface;
import uttt.utils.Symbol;

public class BoardInterfaceTest {
    @Test
    public void getMarksDiverseRichtig() {

        MarkInterface[] marks = new MarkInterface[9];
        BoardInterface board = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            int flopper = i % 3;
            if (flopper == 0) {
                marks[i] = UTTTFactory.createMark(Symbol.CROSS, i);
            } else if (flopper == 1) {
                marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
            } else if (flopper == 2) {
                marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
            }

        }

        board.setMarks(marks);

        // Verify if getMarks returns the same array of marks
        assertArrayEquals(marks, board.getMarks());
    }

    @Test
    public void getMarksDiverseRichtig2() {

        MarkInterface[] marks = new MarkInterface[9];

        BoardInterface board = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                marks[i] = UTTTFactory.createMark(Symbol.CROSS, i);
            } else {
                marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
            }
        }

        board.setMarks(marks);

        assertArrayEquals(marks, board.getMarks());
    }

    @Test
    public void getMarksDiverseFalse() {
        MarkInterface[] marks = new MarkInterface[9];
        BoardInterface board = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            int flopper = i % 3;
            if (flopper == 0) {
                marks[i] = UTTTFactory.createMark(Symbol.CROSS, i);
            } else if (flopper == 1) {
                marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
            } else if (flopper == 2) {
                marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
            }
        }

        board.setMarks(marks);

        // False assertion - expecting different array
        MarkInterface[] differentMarks = new MarkInterface[9];
        for (int i = 0; i < 9; i++) {
            differentMarks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
        }
        assertNotEquals(differentMarks, board.getMarks());
    }

    /*
     * @Test
     * 
     * public void getMarksDiverseFalsch() {
     * MarkInterface[] marks = new MarkInterface[9];
     * BoardInterface board = UTTTFactory.createBoard();
     * for (int i = 0; i < 9; i++) {
     * int flopper = i % 3;
     * if (flopper == 0) {
     * marks[i] = UTTTFactory.createMark(Symbol.CROSS, i);
     * } else if (flopper == 1) {
     * marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
     * } else if (flopper == 2) {
     * marks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
     * }
     * }
     * 
     * board.setMarks(marks);
     * 
     * MarkInterface[] differentMarks = new MarkInterface[9];
     * for (int i = 0; i < 9; i++) {
     * differentMarks[i] = UTTTFactory.createMark(Symbol.EMPTY, i);
     * }
     * assertArrayEquals(differentMarks, board.getMarks());
     * }
     */

    @Test
    public void getMarksDiverseFalsch2() {
        MarkInterface[] marks = new MarkInterface[9];
        BoardInterface board = UTTTFactory.createBoard();
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                marks[i] = UTTTFactory.createMark(Symbol.CROSS, i);
            } else {
                marks[i] = UTTTFactory.createMark(Symbol.CIRCLE, i);
            }
        }

        board.setMarks(marks);

        MarkInterface[] emptyMarks = new MarkInterface[9];
        assertNotEquals(emptyMarks, board.getMarks());
    }

    // setMarkAt

    @Test
    public void setMarkAtRichtig1() {
        // Create an instance of the BoardInterface
        BoardInterface board = UTTTFactory.createBoard();

        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 7);

        MarkInterface[] marks = board.getMarks();

        assertEquals(Symbol.CROSS, marks[1].getSymbol());
        assertEquals(Symbol.CIRCLE, marks[4].getSymbol());
        assertEquals(Symbol.CROSS, marks[7].getSymbol());
    }

    @Test
    public void setMarkAtRichtig2() {
        // Create an instance of the BoardInterface
        BoardInterface board = UTTTFactory.createBoard();

        // Set marks at valid positions
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);

        // Retrieve the marks
        MarkInterface[] marks = board.getMarks();

        // Assert the symbols of the retrieved marks at the corresponding positions
        assertEquals(Symbol.CIRCLE, marks[0].getSymbol());
        assertEquals(Symbol.CROSS, marks[3].getSymbol());
        assertEquals(Symbol.CIRCLE, marks[6].getSymbol());
    }

    @Test
    public void testSetMarkAtInvalidPositionLessThanZero() {
        // Create an instance of the BoardInterface
        BoardInterface board = UTTTFactory.createBoard();

        // Assert that setting a mark at an invalid position less than 0 throws an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> board.setMarkAt(Symbol.CROSS, -1));
    }

    @Test
    public void testSetMarkAtInvalidPositionGreaterThanEight() {
        // Create an instance of the BoardInterface
        BoardInterface board = UTTTFactory.createBoard();

        // Assert that setting a mark at an invalid position greater than 8 throws an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> board.setMarkAt(Symbol.CIRCLE, 9));
    }

    @Test
    public void testSetMarkAtInvalidSymbolNull() {
        // Create an instance of the BoardInterface
        BoardInterface board = UTTTFactory.createBoard();

        // Assert that setting a mark with a null symbol throws an
        // IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> board.setMarkAt(null, 0));
    }

    // isClosed
    @Test
    public void testIsClosedEmptyBoard() {
        // Create an empty board
        BoardInterface board = UTTTFactory.createBoard();

        // Assert that the board is not closed
        assertFalse(board.isClosed());
    }

    @Test
    public void testIsClosedPlayerWon1() {
        // Create a board with a winning configuration
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CROSS, 2);

        // Assert that the board is closed
        assertTrue(board.isClosed());
    }

    @Test
    public void testIsClosedPlayerWon2() {
        // Create a board with a winning configuration
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CIRCLE, 6);

        // Assert that the board is closed
        assertTrue(board.isClosed());
    }

    @Test
    public void testIsClosedPlayerWon3() {
        // Create a board with a winning configuration
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 6);

        // Assert that the board is closed
        assertTrue(board.isClosed());
    }

    @Test
    public void testIsClosedPlayerWon4() {
        // Create a board with a winning configuration
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CIRCLE, 8);

        // Assert that the board is closed
        assertTrue(board.isClosed());
    }

    @Test
    public void testIsClosedNoValidMove1() {
        // Create a board with no valid moves
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CROSS, 7);
        board.setMarkAt(Symbol.CIRCLE, 8);

        // Assert that the board is closed
        assertTrue(board.isClosed());
    }

    public void testIsClosedValidMovesAvailable1() {
        // Create a board with valid moves available
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);

        // Assert that the board is not closed
        assertFalse(board.isClosed());
    }

    @Test
    public void testIsClosedValidMovesAvailable2() {
        // Create a board with valid moves available
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.EMPTY, 2);
        board.setMarkAt(Symbol.CROSS, 3);
        board.setMarkAt(Symbol.EMPTY, 4);
        board.setMarkAt(Symbol.EMPTY, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CIRCLE, 7);
        board.setMarkAt(Symbol.EMPTY, 8);

        // Assert that the board is not closed
        assertTrue(board.isClosed());
    }

    // isMovePossible
    @Test
    public void testIsMovePossibleValidMove() {
        // Create a board with valid moves available
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.EMPTY, 2);

        // Assert that move at index 2 is possible
        assertTrue(board.isMovePossible(2));
    }

    @Test
    public void testIsMovePossibleInvalidMove() {
        // Create a board with positions filled with marks
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);

        // Assert that move at index 1 is not possible
        assertFalse(board.isMovePossible(1));
    }

    @Test
    public void testIsMovePossibleOutOfBounds() {
        // Create an empty board
        BoardInterface board = UTTTFactory.createBoard();

        // Assert that move at index -1 is not possible
        assertThrows(IllegalArgumentException.class, () -> board.isMovePossible(-1));

        // Assert that move at index 9 is not possible
        assertThrows(IllegalArgumentException.class, () -> board.isMovePossible(9));
    }

    // getWinner
    @Test
    public void testGetWinnerEmptyBoard() {
        BoardInterface board = UTTTFactory.createBoard();
        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinnerNoWinner() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CIRCLE, 5);
        board.setMarkAt(Symbol.CIRCLE, 6);
        board.setMarkAt(Symbol.CIRCLE, 7);
        board.setMarkAt(Symbol.EMPTY, 8);
        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinnerPlayerCross() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinnerPlayerCircleDiagonal() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CIRCLE, 0);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CIRCLE, 8);
        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

    @Test
    public void testGetWinnerPlayerCircleDiagonal2() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CROSS, 4);
        board.setMarkAt(Symbol.CROSS, 6);
        assertEquals(Symbol.CROSS, board.getWinner());
    }

    @Test
    public void testGetWinnerTie() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 1);
        board.setMarkAt(Symbol.CROSS, 2);
        board.setMarkAt(Symbol.CIRCLE, 3);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 5);
        board.setMarkAt(Symbol.CROSS, 6);
        board.setMarkAt(Symbol.CROSS, 7);
        board.setMarkAt(Symbol.CIRCLE, 8);
        assertEquals(Symbol.EMPTY, board.getWinner());
    }

    @Test
    public void testGetWinnerCircleRightColumn() {
        BoardInterface board = UTTTFactory.createBoard();
        board.setMarkAt(Symbol.CIRCLE, 2);
        board.setMarkAt(Symbol.CROSS, 0);
        board.setMarkAt(Symbol.CIRCLE, 4);
        board.setMarkAt(Symbol.CROSS, 1);
        board.setMarkAt(Symbol.CIRCLE, 6);
        assertEquals(Symbol.CIRCLE, board.getWinner());
    }

}