package test;

import org.junit.Test;

import edu.iastate.cs228.hw1.Puma;
import edu.iastate.cs228.hw1.Jungle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

public class LivingTest {
	
	@Test
	public void livingStateTest() throws FileNotFoundException {
		Jungle testJungle = new Jungle ("TestCases/pumaTest4.txt");
		

		
		Puma testPuma = new Puma(testJungle, 0, 0, 2);
		int testArray[] = testPuma.censusCount();
		
		assertTrue("Correct number of Puma", testArray[4] == 2);
		assertFalse("Incorrect number of Puma", testArray[4] != 2);
		
	}
}
