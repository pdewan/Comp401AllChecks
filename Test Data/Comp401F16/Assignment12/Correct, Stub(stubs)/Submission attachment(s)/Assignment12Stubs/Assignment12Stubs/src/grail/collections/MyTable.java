package grail.collections;

import java.util.ArrayList;
import java.util.List;

import grail.interfaces.Table;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags({"Table"})
public class MyTable<KeyType> implements Table<KeyType> {

	@Override
	public void put(String key, KeyType val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KeyType get(String key) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}//end class
