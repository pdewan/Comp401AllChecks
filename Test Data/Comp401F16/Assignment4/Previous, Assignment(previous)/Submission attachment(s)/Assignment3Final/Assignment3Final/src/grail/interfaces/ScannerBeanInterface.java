package grail.interfaces;

import util.annotations.Tags;

@Tags({"ScannerBean"})
public interface ScannerBeanInterface {

	String getScannedString();

	void setScannedString(String s);

}