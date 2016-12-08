package grail.scanner;

import java.io.IOException;
import java.text.ParseException;

import grail.interfaces.ParsingExceptionInterface;
import util.annotations.Tags;

@Tags({"ParsingException"})
public class ParsingException extends IOException implements ParsingExceptionInterface {

	private String expected;
	private String encountered;
	
	public ParsingException(String encountered, String expected){
		super("Encountered token not matched expected token");
		this.expected= expected;
		this.encountered = encountered;
	}
	
	@Override
	public String getExpected(){
		return expected;
	};
	@Override
	public String getEncountered(){
		return encountered;
	};
}
