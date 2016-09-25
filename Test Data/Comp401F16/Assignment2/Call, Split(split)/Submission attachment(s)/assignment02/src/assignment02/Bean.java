package assignment02;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames; 
import util.annotations.Tags;

@Tags({"ScannerBean"}) 
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})


public class Bean {
	public void setScannedString (String myString) {
	
	 myString.split(" ");
	}
  
  
}