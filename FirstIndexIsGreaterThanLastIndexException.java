package integerSortingAlgorithm;

public class FirstIndexIsGreaterThanLastIndexException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FirstIndexIsGreaterThanLastIndexException() {
		super("Last Index Is Greater Than First Index");
	}

}
