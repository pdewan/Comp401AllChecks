package grail.scanner;

import java.io.IOException;

import grail.interfaces.ScanningExceptionInterface;
import util.annotations.Tags;

@Tags({"ScanningException"})
public class ScanningException extends IOException implements ScanningExceptionInterface {

	private String[] errors;
	
	public ScanningException(String[] errors){
		super("Invalid tokens in scanned string");
		this.errors = errors;
	}
	
	@Override
	public String[] getErrors() {
		return errors;
	}
	
}
