package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({ "TokenWord", "Word" })
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({ "Input", "Value" })
@EditablePropertyNames({ "Input" })

public interface TokenWord {

	public String getValue();

}
