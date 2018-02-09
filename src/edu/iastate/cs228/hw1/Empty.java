package edu.iastate.cs228.hw1;

/**
 *  
 * @author Spencer Parry
 *
 */

/** 
 * Empty squares are competed by various forms of life.
 */
public class Empty extends Living 
{
	
	private Jungle jung; //private jungle variable
	private int rowpos; //Stores row position
	private int colpos; //Stores column position
	//Variables used for census count
	private int grass = 0;
	private int puma = 0;
	private int jag = 0;
	private int empty = 0;
	private int deer = 0;
	
	/**
	 * Constructs an Empty object
	 * @param j
	 * @param r
	 * @param c
	 */
	public Empty (Jungle j, int r, int c) 
	{
		// TODO  
		
		rowpos = r;
		colpos = c;
		jung = j;
	}
	
	/**
	 * @return The empty state
	 */
	public State who()
	{
		// TODO 
		return State.EMPTY; 
	}
	
	/**
	 * An empty square will be occupied by a neighboring Deer, Grass, Jaguar, or Puma, or 
	 * remain empty. 
	 * @param jNew     jungle in the next life cycle.
	 * @return Living  life form in the next cycle.   
	 */
	public Living next(Jungle jNew)
	{
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.5 in the project description for corresponding survival rules. 
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
			
			for (int j = -1; j < 1; j++) {
				
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
		
		
		if (deer > 1) {
			
			return new Deer(jNew, rowpos, colpos, 0);
		}
		
		else if (puma > 1) {
			
			return new Puma(jNew, rowpos, colpos, 0);
		}
		else if (jag > 1) {
			
			return new Jaguar(jNew, rowpos, colpos, 0);
		}
		else if (grass >= 1) {
			
			return new Grass(jNew, rowpos, colpos);
		}
		else {
			
			return new Empty(jNew, rowpos, colpos);
		}
	}

	@Override
	public int myAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Gets the count of the animals in the 3x3 area
	 * @return an array of ints that represent the population
	 */
	@Override
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
