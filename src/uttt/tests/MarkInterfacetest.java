package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.MarkInterface;

import uttt.utils.Symbol;

public class MarkInterfacetest {

    // getSymbol
    @Test
    public void getCrossRichtig() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);

        assertEquals(Symbol.CROSS, mark.getSymbol());

    }

    @Test
    public void getCircleRichtig() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 0);
        assertEquals(Symbol.CIRCLE, mark.getSymbol());
    }

    @Test
    public void getEmptyRichtig() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 0);
        assertEquals(Symbol.EMPTY, mark.getSymbol());
    }

    @Test
    public void getCrossFalsch() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 0);
        assertNotEquals(Symbol.CROSS, mark.getSymbol());
    }

    @Test
    public void getCircleFalsch() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 0);
        assertNotEquals(Symbol.CIRCLE, mark.getSymbol());
    }

    @Test
    public void getEmptyFalsch() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        assertNotEquals(Symbol.EMPTY, mark.getSymbol());
    }

    // getPosition
    @Test
    public void getPosition0AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        assertEquals(0, mark.getPosition());

    }

    @Test
    public void getPosition1AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 1);
        assertEquals(1, mark.getPosition());
    }

    @Test
    public void getPosition2AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 2);
        assertEquals(2, mark.getPosition());
    }

    @Test
    public void getPosition3AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 3);
        assertEquals(3, mark.getPosition());
    }

    @Test
    public void getPosition4AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 4);
        assertEquals(4, mark.getPosition());
    }

    @Test
    public void getPosition5AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 5);
        assertEquals(5, mark.getPosition());
    }

    @Test
    public void getPosition6AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 6);
        assertEquals(6, mark.getPosition());
    }

    @Test
    public void getPosition7AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 7);
        assertEquals(7, mark.getPosition());
    }

    @Test
    public void getPosition8AndCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 8);
        assertEquals(8, mark.getPosition());

        // setPosition testing

    }

    @Test
    public void getPosition0AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 0);
        assertEquals(0, mark.getPosition());
    }

    @Test
    public void getPosition1AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 1);
        assertEquals(1, mark.getPosition());
    }

    @Test
    public void getPosition2AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 2);
        assertEquals(2, mark.getPosition());
    }

    @Test
    public void getPosition3AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 3);
        assertEquals(3, mark.getPosition());
    }

    @Test
    public void getPosition4AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 4);
        assertEquals(4, mark.getPosition());
    }

    @Test
    public void getPosition5AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 5);
        assertEquals(5, mark.getPosition());
    }

    @Test
    public void getPosition6AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 6);
        assertEquals(6, mark.getPosition());
    }

    @Test
    public void getPosition7AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 7);
        assertEquals(7, mark.getPosition());
    }

    @Test
    public void getPosition8AndCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 8);
        assertEquals(8, mark.getPosition());
    }

    @Test
    public void getPosition0AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 0);
        assertEquals(0, mark.getPosition());
    }

    @Test
    public void getPosition1AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 1);
        assertEquals(1, mark.getPosition());
    }

    @Test
    public void getPosition2AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 2);
        assertEquals(2, mark.getPosition());
    }

    @Test
    public void getPosition3AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 3);
        assertEquals(3, mark.getPosition());
    }

    @Test
    public void getPosition4AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 4);
        assertEquals(4, mark.getPosition());
    }

    @Test
    public void getPosition5AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 5);
        assertEquals(5, mark.getPosition());
    }

    @Test
    public void getPosition6AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 6);
        assertEquals(6, mark.getPosition());
    }

    @Test
    public void getPosition7AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 7);
        assertEquals(7, mark.getPosition());
    }

    @Test
    public void getPosition8AndEmpty() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.EMPTY, 8);
        assertEquals(8, mark.getPosition());
    }

    @Test
    public void getPosition2AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 2);
        assertNotEquals(3, mark.getPosition());
    }

    @Test
    public void getPosition3AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 3);
        assertNotEquals(5, mark.getPosition());
    }

    @Test
    public void getPosition4AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 4);
        assertNotEquals(6, mark.getPosition());
    }

    @Test
    public void getPosition5AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 5);
        assertNotEquals(4, mark.getPosition());
    }

    @Test
    public void getPosition6AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 6);
        assertNotEquals(2, mark.getPosition());
    }

    @Test
    public void getPosition7AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 7);
        assertNotEquals(8, mark.getPosition());
    }

    @Test
    public void getPosition8AndCrossFalse() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 8);
        assertNotEquals(1, mark.getPosition());
    }

    // setSymbol checks

    @Test
    public void setSymbolValidCross() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 0);
        mark.setSymbol(Symbol.CROSS);
        assertEquals(Symbol.CROSS, mark.getSymbol());
    }

    @Test
    public void setSymbolValidCircle() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        mark.setSymbol(Symbol.CIRCLE);
        assertEquals(Symbol.CIRCLE, mark.getSymbol());
    }

    @Test
    public void setSymbolValid_FalseAssertion() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CIRCLE, 0);
        mark.setSymbol(Symbol.CROSS);
        assertNotEquals(Symbol.CIRCLE, mark.getSymbol());
    }

    @Test
    public void setSymbolValid_SameSymbol() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        mark.setSymbol(Symbol.CROSS);
        assertEquals(Symbol.CROSS, mark.getSymbol());
    }

    @Test
    public void setSymbolValid_SameSymbol_FalseAssertion() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        mark.setSymbol(Symbol.CROSS);
        assertNotEquals(Symbol.CIRCLE, mark.getSymbol());
    }

    @Test
    public void setSymbolInvalid_NullSymbol() {
        MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
        assertThrows(IllegalArgumentException.class, () -> {
            mark.setSymbol(null);
        });

    }

}
