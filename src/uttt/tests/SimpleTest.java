package uttt.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uttt.UTTTFactory;
import uttt.game.SimulatorInterface;

public class SimpleTest {

	SimulatorInterface simulator;

	@Before
	public void setUp() throws Exception {
		simulator = UTTTFactory.createSimulator();

	}

	@Test
	public void simpleSetPieceTest() {
		assertNotNull(simulator);
	}

}

// I Used ChatGPT to generate some examples for testing,just to avoid copy
// pasting then changing values for similair tests and not to modify something
// the wrong way by accident.So I would write some tests,then tell ChatGPT to
// provide a similar test but with other values of my specification.
/*
 * 
 * Prompt : @Test
 * public void setSymbolValid() {
 * MarkInterface mark = UTTTFactory.createMark(null, 0);
 * mark.setSymbol(Symbol.CIRCLE);
 * assertEquals(Symbol.CIRCLE, mark.getSymbol());
 * }
 * 
 * 
 * Similar to this,write me some more tests and some false assertion tests
 * 
 * Answer:
 * 
 * Certainly! Here are some additional test cases for the setSymbol function
 * using MarkInterface and UTTTFactory.createMark:
 * 
 * @Test
 * public void setSymbolValid() {
 * MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
 * mark.setSymbol(Symbol.CIRCLE);
 * assertEquals(Symbol.CIRCLE, mark.getSymbol());
 * }
 * 
 * @Test
 * public void setSymbolInvalid_NullSymbol() {
 * MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
 * try {
 * mark.setSymbol(null);
 * fail("Expected IllegalArgumentException to be thrown");
 * } catch (IllegalArgumentException e) {
 * // Exception expected, test passed
 * }
 * assertEquals(Symbol.CROSS, mark.getSymbol()); // Ensure symbol remains
 * unchanged
 * }
 * 
 * 
 * @Test
 * public void setSymbolFalseAssertion() {
 * MarkInterface mark = UTTTFactory.createMark(Symbol.CROSS, 0);
 * mark.setSymbol(Symbol.CIRCLE);
 * assertNotEquals(Symbol.CROSS, mark.getSymbol());
 * }
 * 
 * 
 * The additional test cases include different scenarios to cover both valid and
 * invalid symbol inputs, as well as false assertions. These test cases help
 * ensure that the setSymbol function behaves correctly and handles different
 * scenarios as expected.
 * 
 * 
 */
