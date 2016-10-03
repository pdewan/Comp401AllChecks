package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Start"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input","Value"})
@EditablePropertyNames({"Input"})
public class StartInput implements Input
{
	String startInputTyped;
	public StartInput()
	{
		startInputTyped=null;
	}
	
	public String getInput()
	{
		return startInputTyped;
	}
	
	public void setInput(String s)
	{
		startInputTyped=s;
	}
}
