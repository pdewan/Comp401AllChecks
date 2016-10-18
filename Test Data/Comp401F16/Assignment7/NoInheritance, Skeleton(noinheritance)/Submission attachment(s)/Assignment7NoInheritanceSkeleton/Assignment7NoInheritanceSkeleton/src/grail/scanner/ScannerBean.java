package grail.scanner;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

import java.util.Iterator;

import grail.collections.ClearableHistory;
import grail.commandBeans.ApproachCommand;
import grail.commandBeans.FailCommand;
import grail.commandBeans.MoveCommand;
import grail.commandBeans.PassCommand;
import grail.commandBeans.RepeatCommand;
import grail.commandBeans.SayCommand;
import grail.extraCommandBeans.CallCommand;
import grail.extraCommandBeans.DefineCommand;
import grail.extraCommandBeans.ProceedAllCommand;
import grail.extraCommandBeans.RedoCommand;
import grail.extraCommandBeans.RotateLeftArmCommand;
import grail.extraCommandBeans.RotateRightArmCommand;
import grail.extraCommandBeans.SleepCommand;
import grail.extraCommandBeans.ThreadCommand;
import grail.extraCommandBeans.UndoCommand;
import grail.extraCommandBeans.WaitCommand;
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

}//end class
