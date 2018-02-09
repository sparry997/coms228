package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.Jungle;
import edu.iastate.cs228.hw1.State;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

public class JungleTest {
	
	@Test
	public void jungleFromFileTest() throws FileNotFoundException {
		
		Jungle testJungle = new Jungle("TestCases/jungleTest1.txt");
		
		assertTrue("Jungle Created", testJungle.getWidth() == 3);
		assertFalse("Jungle not created", testJungle.getWidth() != 3);
		
		assertTrue("Jungle Created", testJungle.grid[2][2].who() == State.EMPTY);
		assertFalse("Jungle not created", testJungle.grid[1][0].who() != State.PUMA);
	}
	
	@Test
	public void jungleFromWidth() {
		Jungle testJungle = new Jungle(3);
		
		assertTrue("Jungle Created", testJungle.getWidth() == 3);
	}
	
	@Test
	public void jungleGetWidth() {
		Jungle testJungle = new Jungle(3);
		
		assertTrue("Jungle is width 3", testJungle.getWidth() == 3);
		assertFalse("Jungle is not width 3", testJungle.getWidth() != 3);
	}
	
	@Test
	public void jungleRandomInit() {
		Jungle testJungle = new Jungle(6);
		testJungle.randomInit();
		
		assertTrue("Jungle is created", testJungle.grid[3][2] != null);
		assertFalse("Jungle is not created", testJungle.grid[3][2] == null);
	}
	
	@Test
	public void jungleToString() throws FileNotFoundException {
		Jungle testJungle = new Jungle("TestCases/jungleTest1.txt");
		
		String test = new String(testJungle.toString());
		
		assertTrue("To string works", test.length() == testJungle.toString().length());
		
	}
	
	@Test
	public void jungleToOutputFile() throws FileNotFoundException {
		Jungle testJungle = new Jungle("TestCases/jungleTest1.txt");
		
		testJungle.write("testOutput.txt");
		
		Jungle testJungle2 = new Jungle("testOutput.txt");
		
		assertTrue("Jungle created", testJungle2.grid[0][0].who() == State.JAGUAR);
	}
	
	
	
	
	

}
