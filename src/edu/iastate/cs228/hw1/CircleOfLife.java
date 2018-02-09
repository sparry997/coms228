package edu.iastate.cs228.hw1;

import java.io.FileNotFoundException;
import java.util.Scanner; 

/**
 *  
 * @author Spencer Parry
 *
 */

/**
 * 
 * The CircleOfLife class performs simulation over a grid jungle 
 * with squares occupied by deers, jaguars, pumas, grass, or none. 
 *
 */
public class CircleOfLife 
{
	
	/**
	 * Update the new jungle from the old jungle in one cycle. 
	 * @param jOld  old jungle
	 * @param jNew  new jungle 
	 */
	public static void updateJungle(Jungle jOld, Jungle jNew)
	{
		// TODO 
		// 
		// For every life form (i.e., a Living object) in the grid jOld, generate  
		// a Living object in the grid jNew at the corresponding location such that 
		// the former life form changes into the latter life form. 
		// 
		// Employ the method next() of the Living class. 
		
		for (int i = 0; i < jOld.getWidth(); i++) {
			for (int j = 0; j < jOld.getWidth(); j++) {
				
				jNew.grid[i][j] = null;
								
			}
		}
		
		for (int i = 0; i < jOld.getWidth(); i++) {
			for (int j = 0; j < jOld.getWidth(); j++) {
				
				jNew.grid[i][j] = jOld.grid[i][j].next(jNew);
								
			}
		}
		
	}
	
	/**
	 * Repeatedly generates jungles either randomly or from reading files. 
	 * Over each jungle, carries out an input number of cycles of evolution. 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{	
		// TODO 
		// 
		// Generate CircleOfLife simulations repeatedly like shown in the 
		// sample run in the project description. 
		// 
		// 1. Enter 1 to generate a random jungle, 2 to read a jungle from an input
		//    file, and 3 to end the simulation. (An input file always ends with 
		//    the suffix .txt.)
		// 
		// 2. Print out standard messages as given in the project description. 
		// 
		// 3. For convenience, you may define two jungles even and odd as below. 
		//    In an even numbered cycle (starting at zero), generate the jungle 
		//    odd from the jungle even; in an odd numbered cycle, generate even 
		//    from odd. 
		
		Jungle even;   				 // the jungle after an even number of cycles 
		Jungle odd;                  // the jungle after an odd number of cycles
		
		// 4. Print out initial and final jungles only.  No intermediate jungles should
		//    appear in the standard output.  (When debugging your program, you can 
		//    print intermediate jungles.)
		// 
		// 5. You may save some randomly generated jungles as your own test cases. 
		// 
		// 6. It is not necessary to handle file input & output exceptions for this 
		//    project. Assume data in an input file to be correctly formated. 
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Circle of Life in the Amazon Jungle");
		System.out.println("Please enter a selection:");
		System.out.println("1 (random jungle) 2 (file input) 3 (exit)");
		System.out.println("Trial 1: ");
		
		int selection = scanner.nextInt();
		int gridWidth = 0;
		String fileName;
		int cycleCount = 0;
		int evenOdd;
		int trialNumber = 2;
		
		while (selection != 3) {
			
			if (selection == 1) {
			System.out.println("Random Jungle");
			System.out.println("Enter grid width: ");
			gridWidth = scanner.nextInt();
			even = new Jungle(gridWidth);
			odd = new Jungle(gridWidth);
			even.randomInit();
			System.out.println("Enter the number of cycles: ");
			cycleCount = scanner.nextInt();
			System.out.println("\nInitial jungle: \n");
			System.out.println(even.toString());
			
			for (evenOdd = 0; evenOdd < cycleCount; evenOdd++) {
				
				if (evenOdd % 2 == 0) {
					updateJungle(even, odd);
				}
				if (evenOdd % 2 == 1) {
					updateJungle(odd, even);
				}
				
			}
			
			System.out.println("\nFinal Jungle: \n");
			
			if (evenOdd % 2 == 1) {
				System.out.println(odd.toString());
			}
			if (evenOdd % 2 == 0) {
				System.out.println(even.toString());
			}
			
			System.out.println("\nTrial " + trialNumber +": ");
			
			trialNumber++;
			
			selection = scanner.nextInt();
				
			}
			
			if (selection == 2) {
				System.out.println("Jungle input from a file");
				System.out.println("File Name: ");
				fileName = scanner.next();
				even = new Jungle(fileName);
				gridWidth = even.getWidth();
				odd = new Jungle(gridWidth);
				System.out.println("Enter the number of cycles: ");
				cycleCount = scanner.nextInt();
				System.out.println("\nInitial jungle: \n");
				System.out.println(even.toString());
				
				for (evenOdd = 0; evenOdd < cycleCount; evenOdd++) {
					
					if (evenOdd % 2 == 0) {
						updateJungle(even, odd);
					}
					if (evenOdd % 2 == 1) {
						updateJungle(odd, even);
					}
					
				}
				
				System.out.println("\nFinal Jungle: \n");
				
				if (evenOdd % 2 == 1) {
					System.out.println(odd.toString());
				}
				if (evenOdd % 2 == 0) {
					System.out.println(even.toString());
				}
				
				System.out.println("\nTrial " + trialNumber +": ");
				
				trialNumber++;
				
				selection = scanner.nextInt();
				
			}
						
										
		}
		
		scanner.close();
		
	}
}
