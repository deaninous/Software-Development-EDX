package squarelotron;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SquarelotronTest {


	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testSquarelotron() {
		
		 Squarelotron mySquare = new Squarelotron(7);
		 assertEquals(mySquare.squarelotron[0][4], 5);

		 
	}

	@Test
	public void testUpsideDownFlip() {
		//making sure this cheap copy actually works
		 Squarelotron mySquare = new Squarelotron(4);
		/*Squarelotron myTest;
		 myTest = mySquare.upsideDownFlip(5);
		assertEquals(myTest.squarelotron[0][4], mySquare.squarelotron[0][4]);
		assertEquals(mySquare.squarelotron[3][0], 13);
		assertEquals(mySquare.squarelotron[0][3], 4);*/
		mySquare.flip(3, 0, 0, 3);
		assertEquals(mySquare.squarelotron[3][0], 4);
		assertEquals(mySquare.squarelotron[0][3], 13);


	}

	@Test
	public void testMainDiagonalFlip() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotate() {
		fail("Not yet implemented");
	}

}
