package edu.iastate.cs228.hw1;

/**
 *  
 * @author Spencer Parry
 *
 */

/**
 * Grass may be eaten out or taken over by deers. 
 *
 */
public class Grass extends Living 
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
	 * Constructs a Grass object
	 * @param j jungle unit
	 * @param r row position
	 * @param c column position
	 */
	public Grass (Jungle j, int r, int c) 
	{
		// TODO 
		rowpos = r;
		colpos = c;
		jung = j;
		
	}
	
	public State who()
	{
		// TODO  
		return State.GRASS; 
	}
	
	/**
	 * Grass can be eaten out by too many deers in the neighborhood. Deers may also 
	 * multiply fast enough to take over Grass. 
	 * 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.4 in the project description for the survival rules for grass. 
		// This uses a combination of if-else statements to determine if the deer is in a 3x2, 2x3,
		// 2x2, or 3x3 area. It then counts the animals, and uses if-else statements to determine what 
		// to do with the animal in the given location.
		
		if (rowpos == 0 && colpos == 0) {
			
			for (int j = 0; j < 2; j++) {
				
				for (int k = 0; k < 2; k++) {
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
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

					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
				}
				
			}
		}
		
		else if (colpos == 0 && rowpos > 0) {
			
			for (int j = 0; j < 2; j++)  {
				
				for (int k = -1; k < 1; k++) {
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}

					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
			
		}
		
		else if (colpos == jung.getWidth() - 1 && rowpos > 0) {
			
			for (int j = -1; j < 1; j++)  {
				
				for (int k = -1; k < 2; k++) {
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
						grass++;
					}
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
			
		}
		
		else if (colpos > 0 && rowpos == 0) {
			
				for (int j = -1; j < 1; j++)  {
				
					for (int k = 0; k < 2; k++) {
					
						if (jung.grid[rowpos + k][colpos + j].who() == State.GRASS) {
							grass++;
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
					
					if (jung.grid[rowpos + k][colpos + j].who() == State.DEER) {
						deer++;
					}
					
				}
			}
								
		}
				
		if (deer / 3 >= grass) {
			jNew.grid[colpos][rowpos] = new Empty(jNew, colpos, rowpos);
			return new Empty(jNew, rowpos, colpos);
		}
		
		else if (deer >= 4) {
			
			return new Deer(jNew, rowpos, colpos, 0);
		}
		else {
			
			return new Grass(jNew, rowpos, colpos);
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

@Override
public int myAge() {
	return 0;
}

}
