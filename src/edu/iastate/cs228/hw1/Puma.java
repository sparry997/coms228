package edu.iastate.cs228.hw1;

/**
 *  
 * @author Spencer Parry
 *
 */

/**
 * A puma eats deers and competes against a jaguar. 
 */
public class Puma extends Animal 
{
	
	private int rowpos;
	private int colpos;
	private Jungle jung;
	private int age;
	private int grass = 0;
	private int puma = 0;
	private int jag = 0;
	private int empty = 0;
	private int deer = 0;
	/**
	 * Constructor 
	 * @param j: jungle
	 * @param r: row position 
	 * @param c: column position
	 * @param a: age 
	 */
	public Puma (Jungle j, int r, int c, int a) 
	{
		// TODO 
		rowpos = r;
		colpos = c;
		age = a;
		jung = j;
		
	}
		
	/**
	 * A puma occupies the square. 	 
	 */
	public State who()
	{
		// TODO 
		return State.PUMA; 
	}
	
	public int myAge() {
		
		
		return age;
	}

	/**
	 * A puma dies of old age or hunger, or from attack by a jaguar. 
	 * @param jNew     jungle in the next cycle
	 * @return Living  life form occupying the square in the next cycle. 
	 */
	public Living next(Jungle jNew)
	{
		// TODO 
		// 
		// See Living.java for an outline of the function. 
		// See Section 2.2 in the project description for the survival rules for a puma. 
		
		
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
				
				for (int k = - 1; k < 1; k++) {
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
		
		
		if (this.age == 4) {
			
			return new Empty(jNew, rowpos, colpos);
		}
		
		else if ((jag > puma) && (jag >= 2)) {
			
			return new Jaguar(jNew, rowpos, colpos, 0);
		}
		
		else if ((jag + puma) > deer) {
			
			return new Empty(jNew, rowpos, colpos);
		}
		else {
			
			return new Puma(jNew, rowpos, colpos, age + 1);
		}
	}

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
