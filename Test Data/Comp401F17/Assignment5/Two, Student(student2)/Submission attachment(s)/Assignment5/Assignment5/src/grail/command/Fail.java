package grail.command;
import grail.interfaces.Token;
import grail.interfaces.WordToken;
import grail.tokens.Word;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Fail"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})

public class Fail extends Word implements Token, WordToken {
	
	public Fail (String newInput) {
		super(newInput);
	}
	
}