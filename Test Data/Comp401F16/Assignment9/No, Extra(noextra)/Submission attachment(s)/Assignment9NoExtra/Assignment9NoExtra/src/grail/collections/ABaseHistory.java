package grail.collections;

import grail.interfaces.BaseHistory;
import grail.interfaces.Token;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.VECTOR_PATTERN)
public class ABaseHistory implements BaseHistory {
	
	
	//This collection has a fixed maximum size.
	public static final int MAX_SIZE = 50;
	

	// The underlying array to store the elements
	protected Token[] contents = new Token[MAX_SIZE];
	
	// number of filled elements
	protected int size = 0;	// number of filled elements (protected access)
	
	// Number of filled elements
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Token elementAt (int index) {
		return contents[index];
	}

	protected boolean isFull() {
		return size == MAX_SIZE;
	}
	
	@Override
	public void addElement(Token element) {
		if (isFull()) {
			System.out.println("Cannot add item to a full history");
		} else {
			contents[size] = element;
			size++;
		}
	} 	
	
}
