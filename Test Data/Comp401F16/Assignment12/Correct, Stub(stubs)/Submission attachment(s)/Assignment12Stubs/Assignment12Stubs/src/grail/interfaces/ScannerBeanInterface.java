package grail.interfaces;

import grail.scanner.ScanningException;
import util.annotations.Tags;

@Tags({"ScannerBean"})
public interface ScannerBeanInterface {
	public String getScannedString();
	public void setScannedString(String s) throws ScanningException;
	public Token[] getTokens();
	public String[] getErrors();
	public ClearableHistoryInterface getTokenList();
}
