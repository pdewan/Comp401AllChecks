package grail.collections;

import java.util.ArrayList;
import java.util.List;

import grail.interfaces.Table;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@StructurePattern(StructurePatternNames.MAP_PATTERN)
@Tags({"Table"})
public class MyTable implements Table {
	
	private List<String> keys = new ArrayList<String>();
	private List<Object> values = new ArrayList<Object>();
	
	@Override
	public void put (String key, Object val){
		if (null == key || null == val){
			return;
		}
		
		int index = keys.indexOf(key);
		
		// If the element was not found, add to both columns
		if (index < 0){
			keys.add(key);
			values.add(val);
		
		// Otherwise update second column
		}else{
			values.set(index, val);
		}
		
	}
	
	@Override
	public Object get (String key){
		int index = keys.indexOf(key);
		
		// If not found
		if (index < 0){
			return null;
		
		}else{
			return values.get(index);
		}
	}
	
}//end class
