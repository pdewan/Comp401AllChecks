package grail.scanner;

import java.io.IOException;

import grail.interfaces.ScanningExceptionInterface;
import util.annotations.Tags;

@Tags({"ScanningException"})
public class ScanningException extends IOException implements ScanningExceptionInterface {

}
