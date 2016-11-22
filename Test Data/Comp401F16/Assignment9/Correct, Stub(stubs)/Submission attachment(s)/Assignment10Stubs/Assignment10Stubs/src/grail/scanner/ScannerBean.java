package grail.scanner;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.util.Iterator;

import grail.collections.ClearableHistory;
import grail.interfaces.ClearableHistoryInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Token;
import grail.tokenBeans.EndToken;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import grail.tokenBeans.StartToken;
import grail.tokenBeans.WordToken;
import grail.tokenBeans.commandBeans.ApproachCommandToken;
import grail.tokenBeans.commandBeans.FailCommandToken;
import grail.tokenBeans.commandBeans.MoveCommandToken;
import grail.tokenBeans.commandBeans.PassCommandToken;
import grail.tokenBeans.commandBeans.RepeatCommandToken;
import grail.tokenBeans.commandBeans.SayCommandToken;
import grail.tokenBeans.extraCommandBeans.CallCommandToken;
import grail.tokenBeans.extraCommandBeans.DefineCommandToken;
import grail.tokenBeans.extraCommandBeans.ProceedAllCommandToken;
import grail.tokenBeans.extraCommandBeans.RedoCommandToken;
import grail.tokenBeans.extraCommandBeans.RotateLeftArmCommandToken;
import grail.tokenBeans.extraCommandBeans.RotateRightArmCommandToken;
import grail.tokenBeans.extraCommandBeans.SleepCommandToken;
import grail.tokenBeans.extraCommandBeans.ThreadCommandToken;
import grail.tokenBeans.extraCommandBeans.UndoCommandToken;
import grail.tokenBeans.extraCommandBeans.WaitCommandToken;


/**
 * A "Bean" object whose setter for scannedString prints the tokens and their types.
 * @author Semion
 *
 */
@Tags({"ScannerBean"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString", "Tokens", "Errors", "TokenList"})
@EditablePropertyNames({"ScannedString"})
public class ScannerBean implements ScannerBeanInterface{

	@Override
	public String getScannedString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setScannedString(String s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Token[] getTokens() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClearableHistoryInterface getTokenList() {
		// TODO Auto-generated method stub
		return null;
	}

}//end class
