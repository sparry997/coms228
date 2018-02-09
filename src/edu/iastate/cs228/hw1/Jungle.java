package edu.iastate.cs228.hw1;



/**
 *  
 * @author Spencer Parry
 *
 */

import java.io.File; 
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random; 

/**
 * 
 * The jungle is represented as a square grid of size width X width. 
 *
 */
public class Jungle 
{
	private int width = 0; // grid size: width X width 
	
	public Living[][] grid; 
	
	private String currentSelec;

	
	/**
	 *  Default constructor reads from a file 
	 */
	public Jungle(String inputFileName) throws FileNotFoundException
	{		
        // TODO 
		// 
		// Assumption: The input file is in correct format. 
		// 
		// You may create the grid jungle in the following steps: 
		// 
		// 1) Reads the first line to determine the width of the grid.
		// 
		// 2) Creates a grid object. 
		// 
		// 3) Fills in the grid according to the input file. 
		// 
		// Be sure to close the input file when you are done. 
		
		File file = new File(inputFileName);
				
		Scanner sc = new Scanner(file);
		
		String line;
		
		
		//Gets width of grid
		while (sc.hasNextLine()) {
			
			line = sc.nextLine();
			
			if (line.length() <= 0) {
				break;
			}
			
			else if (line.charAt(line.length() - 2) == 'G' || line.charAt(line.length() - 2) == 'E') {
				
			}
			
			else {
			
			width++;
			}
		}
		
		
		
		grid = new Living[width][width];
		
		//Opens up scanner and uses a for loop to add the animal to the grid
		Scanner scanner = new Scanner(file);
		
		for (int i = 0; i < width; i++) {
			
			for (int j = 0; j < width; j++) {
				currentSelec = scanner.next();
				
				if (currentSelec.equals("E")) {					
					grid[i][j] = new Empty(this, i, j);				
				}
				
				else if (currentSelec.equals("G")) {				
					grid[i][j] = new Grass(this, i, j);	
				}
				
				else if (currentSelec.charAt(0) == 'D') {									
					grid[i][j] = new Deer(this, i, j, currentSelec.charAt(1) - '0');
				}
				
				else if (currentSelec.charAt(0) == 'P') {
					grid[i][j] = new Puma(this, i, j, currentSelec.charAt(1) - '0');
				}
				
				else if (currentSelec.charAt(0) == 'J') {
					grid[i][j] = new Jaguar(this, i, j, currentSelec.charAt(1) - '0');
				}
			}
		}
		
		sc.close();
		scanner.close();
		
	}
	
	/**
	 * Constructor that builds a w X w grid without initializing it. 
	 * @param width  the grid 
	 */
	public Jungle(int w)
	{
		// TODO 
		
		width = w;
		
		grid = new Living[width][width];
		
	}
	
	/**
	 * Gets the width 
	 * @return the width of the grid
	 */
	public int getWidth()
	{
		// TODO  
		return width;   
	}
	
	/**
	 * Initialize the jungle by randomly assigning to every square of the grid  
	 * one of Deer, Empty, Grass, Jaguar, or Puma.  
	 * 
	 * Every animal starts at age 0.
	 */
	public void randomInit()
	{
		//Creates a grid by using a random int to pick an animal and a for loop to set the grid
		Random generator = new Random(); 
		
		for (int i = 0; i < width; i++)
		{
									
			for (int j = 0; j < width; j++) {
				
				int selector = generator.nextInt(5);
				
				if (selector == 0) {
					grid[i][j] = new Deer(this, i, j, 0);
				}
				else if (selector == 1) {
					grid[i][j] = new Empty(this, i, j);
				}
				else if (selector == 2) {
					grid[i][j] = new Grass(this, i, j);
				}
				else if (selector == 3) {
					grid[i][j] = new Jaguar(this, i, j, 0);
				}
				else {
					grid[i][j] = new Puma(this, i, j, 0);
				}
				
				
			}
		}
		
	}
	
	
	/**
	 * Output the jungle grid. For each square, output the first letter of the living form
	 * occupying the square. If the living form is an animal, then output the age of the animal 
	 * followed by a blank space; otherwise, output two blanks.  
	 */
	public String toString()
	{
		
		String output = new String();
		ArrayList<String> states=new ArrayList<String>();
		
		for (int i = 0; i < width; i++) {
			
			if (i >= 1) {
				states.add("\n");
			}
			for (int j = 0; j < (width); j++) {
				
				if (grid[i][j].who() == State.DEER) {
					
					states.add("D" + grid[i][j].myAge() +" ");
				}
				else if (grid[i][j].who() == State.EMPTY) {
					states.add("E  ");
				}
				else if (grid[i][j].who() == State.GRASS) {
					states.add("G  ");
				}
				else if (grid[i][j].who() == State.JAGUAR) {
					states.add("J" + grid[i][j].myAge() +" ");
				}
				else if (grid[i][j].who() == State.PUMA) {
					states.add("P" + grid[i][j].myAge() +" ");
				}
				
			}
		}
		
		for (int i = 0; i < states.size(); i++) {
			
			output = output + states.get(i);
		}
		
		return output; 
	}
	

	/**
	 * Write the jungle grid to an output file.  Also useful for saving a randomly 
	 * generated jungle for debugging purpose. 
	 * @throws FileNotFoundException
	 */
	public void write(String outputFileName) throws FileNotFoundException
	{
		
		// TODO 
		// 
		// 1. Open the file. 
		// 
		// 2. Write to the file. The five life forms are represented by characters 
		//    D, E, G, J, P. Leave one blank space in between. Examples are given in
		//    the project description. 
		// 
		// 3. Close the file. 
		
		File file = new File(outputFileName); 
		
		PrintWriter output = new PrintWriter(file);
		
		output.print(this.toString());
		
		output.close();
		
		
		
	}	
}
