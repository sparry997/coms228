package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.CircleOfLife;
import edu.iastate.cs228.hw1.Puma;
import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.Random;

public class PumaTest {
	
	@Test
	public void pumaConstructorTest() {
		
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {
		int row = generator.nextInt(2);
		int col = generator.nextInt(2);
		int age = generator.nextInt(6);
		
		Jungle testJungle = new Jungle(3);
		
		Puma testPuma = new Puma(testJungle, row, col, age);
		
		assertTrue("Age match", testPuma.myAge() == age);
		assertFalse("Age != Given Age", testPuma.myAge() != age);
		
		assertTrue("State match", testPuma.who() == State.PUMA);
		assertFalse("State not a match", testPuma.who() != State.PUMA);
		}
	}
	
	@Test
	public void pumaStateTest() {
		Jungle testJungle = new Jungle(3);
		Puma testPuma = new Puma(testJungle, 0, 0, 0);
		
		assertTrue("State match", testPuma.who() == State.PUMA);
		assertFalse("State not a match", testPuma.who() != State.PUMA);
				
	}
	
	@Test
	public void pumaAgeTest() {
		Random generator = new Random();
		
		for (int i = 0; i < 10; i++) {

		int age = generator.nextInt(6);
		
		Jungle testJungle = new Jungle(3);
		
		Puma testPuma = new Puma(testJungle, 0, 0, age);
		
		assertTrue("Age match", testPuma.myAge() == age);
		assertFalse("Age != Given Age", testPuma.myAge() != age);
		
		}
	}
	
	@Test
	public void pumaLivingTest1() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/pumaTest1.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Puma is dead", finalJungle.grid[0][0].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.EMPTY);
	}
	
	@Test
	public void pumaLivingTest2() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/pumaTest2.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Puma is Jaguar", finalJungle.grid[0][0].who() == State.JAGUAR);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.JAGUAR);
		
	}
	
	@Test
	public void pumaLivingTest3() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle ("TestCases/pumaTest3.txt");
		Jungle finalJungle = new Jungle(3);
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Puma is dead", finalJungle.grid[0][0].who() == State.EMPTY);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.EMPTY);
	}
	
	
	@Test
	public void pumaLivingTest4() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/pumaTest4.txt");
		Jungle finalJungle = new Jungle(3);
		
		int pumaAge = testJungle.grid[0][0].myAge();
		
		CircleOfLife.updateJungle(testJungle, finalJungle);
		
		assertTrue("Puma has aged", finalJungle.grid[0][0].who() == State.PUMA && finalJungle.grid[0][0].myAge() == pumaAge + 1);
		assertFalse("Error", finalJungle.grid[0][0].who() != State.PUMA && finalJungle.grid[0][0].myAge() != pumaAge + 1);
	}
	
	@Test
	public void censusTest() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/pumaTest4.txt");
		

		
		Puma testPuma = new Puma(testJungle, 0, 0, 2);
		int testArray[] = testPuma.censusCount();
		
		assertTrue("Correct number of Puma", testArray[4] == 2);
		assertFalse("Incorrect number of Puma", testArray[4] != 2);				
		
	}
		

}
