package main;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input","Value"})
@EditablePropertyNames({"Input"})
public class QuoteInput implements Input
{
	String quoteTyped;
	public QuoteInput()
	{
		quoteTyped=null;
	}
	
	public String getInput()
	{
		return quoteTyped;
	}
	
	public void setInput(String s)
	{
		quoteTyped=s;
	}
}
