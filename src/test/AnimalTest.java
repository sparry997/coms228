package test;
import org.junit.Test;

import edu.iastate.cs228.hw1.Animal;
import edu.iastate.cs228.hw1.Deer;
import edu.iastate.cs228.hw1.Jungle;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random; 

public class AnimalTest {
	
	@Test
	public void myAgeTest() {
		Random generater= new Random();
		
		Jungle testJungle = new Jungle(3);
		
		
		for (int i = 0; i < 10; i++) {
		int age = generater.nextInt(4);

		Animal testAnimal = new Deer(testJungle, 0, 0, age);
		
		assertTrue("Passed", testAnimal.myAge() == age);
		assertFalse("Failed", testAnimal.myAge() != age);
	}
	
	}
	
}
