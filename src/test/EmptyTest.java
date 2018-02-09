package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.CircleOfLife;
import edu.iastate.cs228.hw1.Empty;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Random;

public class EmptyTest {
	
	@Test
	public void emptyConstructorTest() {
		
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {
		int row = generator.nextInt(2);
		int col = generator.nextInt(2);
		
		Jungle testJungle = new Jungle(3);
		
		Empty testEmpty = new Empty(testJungle, row, col);

		assertTrue("State match", testEmpty.who() == State.EMPTY);
		assertFalse("State not a match", testEmpty.who() != State.EMPTY);
		}
	}
	
	@Test
	public void emptyStateTest() {
		Jungle testJungle = new Jungle(3);
		Empty testEmpty = new Empty(testJungle, 0, 0);
		
		assertTrue("State match", testEmpty.who() == State.EMPTY);
		assertFalse("State not a match", testEmpty.who() != State.EMPTY);
				
	}
	
	
	
	@Test
	public void emptyLivingTest1() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/emptyTest1.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Empty is deer", finalJungle.grid[1][1].who() == State.DEER);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.DEER);
	}
	
	@Test
	public void emptyLivingTest2() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/emptyTest2.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Empty is puma", finalJungle.grid[1][1].who() == State.PUMA);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.PUMA);
		
	}
	
	@Test
	public void emptyLivingTest3() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/emptyTest3.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Empty is Jag", finalJungle.grid[1][1].who() == State.JAGUAR);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.JAGUAR);
	}
	
	@Test
	public void emptyLivingTest4() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/emptyTest4.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Empty is grass", finalJungle.grid[1][1].who() == State.GRASS);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.GRASS);
	}
	
	@Test
	public void emptyLivingTest5() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/emptyTest5.txt");
		Jungle finalJungle = new Jungle(3);	
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Empty is empty", finalJungle.grid[1][1].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.EMPTY);
	}
	
	@Test
	public void censusTest() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/emptyTest5.txt");
		

		
		Empty testEmpty = new Empty(testJungle, 0, 0);
		int testArray[] = testEmpty.censusCount();
		
		assertTrue("Correct number of Empty", testArray[1] == 9);
		assertFalse("Incorrect number of Empty", testArray[1] != 9);				
		
	}
		

}
