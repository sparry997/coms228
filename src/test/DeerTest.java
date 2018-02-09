package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.CircleOfLife;
import edu.iastate.cs228.hw1.Deer;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Random;

public class DeerTest {
	
	@Test
	public void deerConstructorTest() {
		
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {
		int row = generator.nextInt(2);
		int col = generator.nextInt(2);
		int age = generator.nextInt(6);
		
		Jungle testJungle = new Jungle(3);
		
		Deer testDeer = new Deer(testJungle, row, col, age);
		
		assertTrue("Age match", testDeer.myAge() == age);
		assertFalse("Age != Given Age", testDeer.myAge() != age);
		
		assertTrue("State match", testDeer.who() == State.DEER);
		assertFalse("State not a match", testDeer.who() != State.DEER);
		}
	}
	
	@Test
	public void deerStateTest() {
		Jungle testJungle = new Jungle(3);
		Deer testDeer = new Deer(testJungle, 0, 0, 0);
		
		assertTrue("State match", testDeer.who() == State.DEER);
		assertFalse("State not a match", testDeer.who() != State.DEER);
				
	}
	
	@Test
	public void deerAgeTest() {
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {

		int age = generator.nextInt(6);
		
		Jungle testJungle = new Jungle(3);
		
		Deer testDeer = new Deer(testJungle, 0, 0, age);
		
		assertTrue("Age match", testDeer.myAge() == age);
		assertFalse("Age != Given Age", testDeer.myAge() != age);
		
		}
	}
	
	@Test
	public void deerLivingTest1() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/deerTest1.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Deer is dead", finalJungle.grid[0][0].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.EMPTY);
	}
	
	@Test
	public void deerLivingTest2() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/deerTest2.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Deer starved", finalJungle.grid[0][0].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.EMPTY);
		
	}
	
	@Test
	public void deerLivingTest3() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/deerTest3.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Deer is now Puma", finalJungle.grid[1][1].who() == State.PUMA);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.PUMA);
	}
	
	@Test
	public void deerLivingTest4() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/deerTest4.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Deer is now Puma", finalJungle.grid[1][1].who() == State.JAGUAR);
		assertFalse("Error", finalJungle.grid[1][1].who() != State.JAGUAR);
	}
	
	@Test
	public void deerLivingTest5() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/deerTest5.txt");
		Jungle finalJungle = new Jungle(3);
		
		int deerAge = testJungle.grid[2][2].myAge();
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Deer has aged", finalJungle.grid[2][2].who() == State.DEER && finalJungle.grid[2][2].myAge() == deerAge + 1);
		assertFalse("Error", finalJungle.grid[2][2].who() != State.DEER && finalJungle.grid[2][2].myAge() != deerAge + 1);
	}
	
	@Test
	public void censusTest() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/deerTest5.txt");
		

		
		Deer testDeer = new Deer(testJungle, 0, 0, 2);
		int testArray[] = testDeer.censusCount();
		
		assertTrue("Correct number of Deer", testArray[0] == 1);
		assertFalse("Incorrect number of Deer", testArray[0] != 1);				
		
	}
		

}
