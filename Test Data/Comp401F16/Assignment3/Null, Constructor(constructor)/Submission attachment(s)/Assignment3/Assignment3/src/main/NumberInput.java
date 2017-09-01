package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Number"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input","Value"})
@EditablePropertyNames({"Input"})
public class NumberInput implements Input, IntProperty
{
	String numberTyped;
	public NumberInput()
	{
		numberTyped=null;
	}
	
	public String getInput()
	{
		return numberTyped;
	}
	
	public void setInput(String s)
	{
		numberTyped=s;
	}
	
	public int getIntProperty()
	{
		return Integer.parseInt(numberTyped);
	}
}
