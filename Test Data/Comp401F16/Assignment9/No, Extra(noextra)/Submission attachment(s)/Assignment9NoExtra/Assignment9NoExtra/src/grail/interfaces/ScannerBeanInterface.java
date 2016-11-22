package grail.interfaces;

import util.annotations.Tags;

@Tags({"ScannerBean"})
public interface ScannerBeanInterface {
	public String getScannedString();
	public void setScannedString(String s);
	public Token[] getTokens();
	public String[] getErrors();
	public ClearableHistoryInterface getTokenList();
}
