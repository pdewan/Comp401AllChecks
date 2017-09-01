package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"End"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input","Value"})
@EditablePropertyNames({"Input"})
public class EndInput implements Input
{
	String EndInputTyped;
	public EndInput()
	{
		EndInputTyped=null;
	}
	
	public String getInput()
	{
		return EndInputTyped;
	}
	
	public void setInput(String s)
	{
		EndInputTyped=s;
	}
}
