package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Word"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input","Value"})
@EditablePropertyNames({"Input"})
public class WordInput implements Input, LowercaseProperty
{
	String wordTyped;
	public WordInput()
	{
		wordTyped=null;
	}
	
	public String getInput()
	{
		return wordTyped;
	}
	
	public void setInput(String s)
	{
		wordTyped=s;
	}
	
	public String getLowercaseProperty()
	{
		return wordTyped.toLowerCase();
	}
}
