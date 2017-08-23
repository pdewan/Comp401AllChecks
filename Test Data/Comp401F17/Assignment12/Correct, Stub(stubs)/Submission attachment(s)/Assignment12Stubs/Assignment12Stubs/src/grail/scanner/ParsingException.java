package grail.scanner;

import java.io.IOException;
import java.text.ParseException;

import grail.interfaces.ParsingExceptionInterface;
import util.annotations.Tags;

@Tags({"ParsingException"})
public class ParsingException extends IOException implements ParsingExceptionInterface {

	@Override
	public String getExpected() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEncountered() {
		// TODO Auto-generated method stub
		return null;
	}

}
