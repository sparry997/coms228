package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.CircleOfLife;
import edu.iastate.cs228.hw1.Jungle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException; 

public class CircleOfLifeTest {
	
	@Test
	public void updateJungleTest3x3() throws FileNotFoundException {
		String file = new String("TestCases/public1-3x3.txt");
		
		String solutions = new String("TestCases/public1-3x3solution.txt");
		
		Jungle testJungle = new Jungle(file);
		
		Jungle testJungle2 = new Jungle(3);
		
		Jungle solutionJungle = new Jungle(solutions);
		
		CircleOfLife.updateJungle(testJungle, testJungle2);
		
		int matchCount = 0;
		int expectedCount = 9;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (testJungle2.grid[i][j].who() == solutionJungle.grid[i][j].who() && testJungle2.grid[i][j].myAge() == solutionJungle.grid[i][j].myAge()) {
					matchCount++;
				}
			}
		}
		
		assertTrue("Match", matchCount == expectedCount);
		assertFalse("Not a match", matchCount != expectedCount);
			
		}
	
	@Test
	public void updateJungleTest6x6() throws FileNotFoundException {
		String file = new String("TestCases/public2-6x6.txt");
		
		String solutions = new String("TestCases/public2-6x6solutions.txt");
		
		Jungle testJungle = new Jungle(file);
		
		Jungle testJungle2 = new Jungle(6);
		
		Jungle solutionJungle = new Jungle(solutions);
		
		CircleOfLife.updateJungle(testJungle, testJungle2);
		
		int matchCount = 0;
		int expectedCount = 36;
		
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (testJungle2.grid[i][j].who() == solutionJungle.grid[i][j].who() && testJungle2.grid[i][j].myAge() == solutionJungle.grid[i][j].myAge()) {
					matchCount++;
				}
			}
		}
		
		assertTrue("Match", matchCount == expectedCount);
		assertFalse("Not a match", matchCount != expectedCount);
			
		}
	
	@Test
	public void updateJungleTest10x10() throws FileNotFoundException {
		String file = new String("TestCases/public3-10x10.txt");
		
		String solutions = new String("TestCases/public3-10x10solution.txt");
		
		Jungle testJungle = new Jungle(file);
		
		Jungle testJungle2 = new Jungle(10);
		
		Jungle solutionJungle = new Jungle(solutions);
		
		CircleOfLife.updateJungle(testJungle, testJungle2);
		
		int matchCount = 0;
		int expectedCount = 100;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (testJungle2.grid[i][j].who() == solutionJungle.grid[i][j].who() && testJungle2.grid[i][j].myAge() == solutionJungle.grid[i][j].myAge()) {
					matchCount++;
				}
			}
		}
		
		assertTrue("Match", matchCount == expectedCount);
		assertFalse("Not a match", matchCount != expectedCount);
			
		}
	}
	


