package edu.iastate.cs228.hw1;

/**
 *  
 * @author Spencer Parry
 *
 */

/*
 * A deer eats grass and lives no more than six years.
 */
public class Deer extends Animal 
{	
	
	private Jungle jung; //private jungle variable
	private int rowpos; //Stores row position
	private int colpos; //Stores column position
	private int age; //Stores age
	//Variables used for census count
	private int grass = 0;
	private int puma = 0;
	private int jag = 0;
	private int empty = 0;
	private int deer = 0;
	
	/**
	 * Creates a Deer object.
	 * @param j: jungle  
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Deer (Jungle j, int r, int c, int a) 
	{
		jung = j;
		rowpos = r;
		colpos = c;
		age = a;
		
		
	}
		
	// Deer occupies the square.
	public State who()
	{
		// TODO  
		return State.DEER; 
	}
	
	/**
	 * @return the age of the animal
	 */
	public int myAge() {
		
		
		return age;
	}	
	
	/**
	 * @param jNew     jungle in the next cycle 
	 * @return Living  new life form occupying the same square
	 */
	public Living next(Jungle jNew)
	{
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.3 in the project description for the survival rules for a deer. 	
		// 
		// This uses a combination of if-else statements to determine if the deer is in a 3x2, 2x3,
		// 2x2, or 3x3 area. It then counts the animals, and uses if-else statements to determine what 
		// to do with the animal in the given location.
		
		if (rowpos == 0 && colpos == 0) {
			
			for (int j = 0; j < 2; j++) {
				
				for (int k = 0; k < 2; k++) {
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
				}
				
			}
		}
		
		else if (rowpos == jung.getWidth() - 1 && colpos == 0) {
			
			for (int j = 0; j < 2; j++) {
				
				for (int k = -1; k < 1; k++) {
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
				}
				
			}
		}
		
		else if (colpos == jung.getWidth() - 1 && rowpos == 0) {
			
			for (int j = - 1; j < 1; j++) {
				
				for (int k = 0; k < 2; k++) {
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
				}
				
			}
		}
		
		else if (colpos == jung.getWidth() - 1 && rowpos == jung.getWidth() - 1) {

			for (int j = -1; j < 1; j++) {
				
				for (int k = -1; k < 1; k++) {
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
				}
				
			}
		}
		
		else if (colpos == 0 && rowpos > 0) {
			
			for (int j = 0; j < 2; j++)  {
				
				for (int k = -1; k < 2; k++) {
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
			
		}
		
		else if (colpos == jung.getWidth() - 1 && rowpos > 0) {
			
			for (int j = - 1; j < 1; j++)  {
				
				for (int k = -1; k < 2; k++) {
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
			
		}
		
		else if (colpos > 0 && rowpos == 0) {
			
				for (int j = - 1; j < 2; j++)  {
				
					for (int k = 0; k < 2; k++) {
					
						if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
							grass++;
						}
					
						if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
							empty++;
						}
					
						if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
							jag++;
						}
						if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
							puma++;
						}
						if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
							deer++;
						}
					
					}
				}
			
		}
		
		
		else if (colpos > 0 && rowpos == jung.getWidth() - 1) {
					
					for (int j = -1; j < 2; j++)  {
						
						for (int k = -1; k < 1; k++) {
							
							if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
								grass++;
							}
							
							if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
								empty++;
							}
							
							if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
								jag++;
							}
							if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
								puma++;
							}
							if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
								deer++;
							}
							
						}
					}
					
				}
		
		else {
			
			
			for (int j = -1; j < 2; j++)  {
				
				for (int k = -1; k < 2; k++) {
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.EMPTY) {
						empty++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.JAGUAR) {
						jag++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.PUMA) {
						puma++;
					}
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
								
		}
		
		
		if (this.age == 6) {
			
			return new Empty(jNew, rowpos, colpos);
		}
		
		else if (grass == 0) {
			
			return new Empty(jNew, rowpos, colpos);
		}
		
		else if ((puma + jag > deer) && (puma / 2 >= jag)) {
			
			return new Puma(jNew, rowpos, colpos, 0);
		}
		
		else if ((puma + jag > deer) && (jag >= puma) && (jag >= 2)) {
			
			return new Jaguar(jNew, rowpos, colpos, 0);
		}
		else {
			
			return new Deer(jNew, rowpos, colpos, age + 1);
		}
		
	}

/**
 * Gets the count of the animals in the 3x3 area
 * @return an array of ints that represent the population
 */
 	public int[] censusCount() {
		
 		int[] censusVals = new int[5];
 		
 		for (int i = 0; i < jung.getWidth(); i++) {
 			for (int j = 0; j < jung.getWidth(); j++) {
 				if (jung.grid[i][j].who() == State.GRASS) {
					grass++;
				}
				
				if (jung.grid[i][j].who() == State.EMPTY) {
					empty++;
				}
				
				if (jung.grid[i][j].who() == State.JAGUAR) {
					jag++;
				}
				if (jung.grid[i][j].who() == State.PUMA) {
					puma++;
				}
				if (jung.grid[i][j].who() == State.DEER) {
					deer++;
				}
 			}
 		}
 		
 		censusVals[0] = deer;
 		censusVals[1] = empty;
 		censusVals[2] = grass;
 		censusVals[3] = jag;
 		censusVals[4] = puma;
 		
 		return censusVals;
	 
 	}
 	
 	}
