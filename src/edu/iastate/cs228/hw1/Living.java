package edu.iastate.cs228.hw1;

/**
 *  
 * @author Spencer Parry
 *
 */

/**
 * 
 * Living refers to the life form occupying a square in a jungle grid. It is a 
 * superclass of Empty, Grass, and Animal, the last of which is in turn a superclass
 * of Deer, Jaguar, and Puma. Living has two abstract methods awaiting implementation. 
 *
 */
public abstract class Living 
{
	protected Jungle jungle; // the jungle in which the life form resides
	protected int row;       // location of the square on which 
	protected int column;    // the life form resides
	
	// constants to be used as indices. 
	protected static final int DEER = 0; 
	protected static final int EMPTY = 1; 
	protected static final int GRASS = 2; 
	protected static final int JAGUAR = 3; 
	protected static final int PUMA = 4; 
	
	public static final int NUM_LIFE_FORMS = 5; 
	
	// life expectancies 
	public static final int DEER_MAX_AGE = 6; 
	public static final int JAGUAR_MAX_AGE = 5; 
	public static final int PUMA_MAX_AGE = 4; 
	
	
	/**
	 * Censuses all life forms in the 3 X 3 neighborhood in a jungle. 
	 * @param population  counts of all life forms
	 */
	protected void census(int population[ ])
	{		
		// TODO 
		// 
		// Count the numbers of Deers, Empties, Grasses, Jaguars, and Pumas  
		// in the 3 by 3 neighborhood centered at this Living object.  Store the 
		// counts in the array population[] at indices DEER, EMPTY, GRASS, JAGUAR, 
		// and PUMA, respectively. 
		
		for (int i = 0; i < this.censusCount().length; i++) {
			population[i] = this.censusCount()[i];
		}
		
	}

	/**
	 * Gets the identity of the life form on the square.
	 * @return State
	 */
	public abstract State who();
	// To be implemented in each class of Deer, Empty, Grass, Jaguar, and Puma. 
	// 
	// There are five states given in State.java. Include the prefix State in   
	// the return value, e.g., return State.Puma instead of Puma.  
	
	/**
	 * Determines the life form on the square in the next cycle.
	 * @param  jNew  jungle of the next cycle
	 * @return Living 
	 */
	public abstract Living next(Jungle jNew); 
	// To be implemented in the classes Deer, Empty, Grass, Jaguar, and Puma. 
	// 
	// For each class (life form), carry out the following: 
	// 
	// 1. Obtains counts of life forms in the 3X3 neighborhood of the class object. 

	// 2. Applies the survival rules for the life form to determine the life form  
	//    (on the same square) in the next cycle.  These rules are given in the  
	//    project description. 
	// 
	// 3. Generate this new life form at the same location in the jungle jNew.  
	
	/**
	 * Determines the age of the Deer, Jaguar, or Puma
	 * @return the age of the animal
	 */
	public abstract int myAge();
	
	/**
	 * Gets the count of the objects in the 3x3 square
	 * @return the count of the animals, grass, and empty units
	 */
	public abstract int[] censusCount();

}
