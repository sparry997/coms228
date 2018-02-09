package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.CircleOfLife;
import edu.iastate.cs228.hw1.Grass;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Random;

public class GrassTest {
	
	@Test
	public void grassConstructorTest() {
		
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {
		int row = generator.nextInt(2);
		int col = generator.nextInt(2);
		
		Jungle testJungle = new Jungle(3);
		
		Grass testGrass = new Grass(testJungle, row, col);
		
		assertTrue("State match", testGrass.who() == State.GRASS);
		assertFalse("State not a match", testGrass.who() != State.GRASS);
		}
	}
	
	@Test
	public void grassStateTest() {
		Jungle testJungle = new Jungle(3);
		Grass testGrass = new Grass(testJungle, 0, 0);
		
		assertTrue("State match", testGrass.who() == State.GRASS);
		assertFalse("State not a match", testGrass.who() != State.GRASS);
				
	}
	
	
	@Test
	public void grassLivingTest1() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/grassTest1.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Grass is dead", finalJungle.grid[0][0].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.EMPTY);
	}
	
	@Test
	public void grassLivingTest2() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/grassTest2.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Grass is Deer", finalJungle.grid[1][1].who() == State.DEER);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.DEER);
		
	}
	
	@Test
	public void grassLivingTest3() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/grassTest3.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Grass is Grass", finalJungle.grid[1][1].who() == State.GRASS);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.GRASS);
	}
	
	
	@Test
	public void censusTest() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/grassTest3.txt");
		

		
		Grass testGrass = new Grass(testJungle, 0, 0);
		int testArray[] = testGrass.censusCount();
		
		assertTrue("Correct number of Grass", testArray[2] == 2);
		assertFalse("Incorrect number of Grass", testArray[2] != 2);				
		
	}
		

}
