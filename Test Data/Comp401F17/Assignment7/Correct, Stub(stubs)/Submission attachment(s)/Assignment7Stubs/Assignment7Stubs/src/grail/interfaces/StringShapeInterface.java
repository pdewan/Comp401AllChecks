package grail.interfaces;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public interface StringShapeInterface extends Locatable{

	public void setText(String newString);
	public String getText();
	
}
