package grail.scanner;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

import grail.SingletonsCreator;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.collections.MyTable;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.CompositeCommandThread;
import grail.interfaces.Number;
import grail.interfaces.ParserInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Token;
import grail.interfaces.UndoableCommandThread;
import grail.interfaces.Undoer;
import grail.interfaces.Word;
import grail.scanner.commands.ApproachCommand;
import grail.scanner.commands.CallCommand;
import grail.scanner.commands.CommandList;
import grail.scanner.commands.DefineCommand;
import grail.scanner.commands.ExecuteUndoableCommand;
import grail.scanner.commands.FailCommand;
import grail.scanner.commands.MoveCommand;
import grail.scanner.commands.PassCommand;
import grail.scanner.commands.ProceedAllCommand;
import grail.scanner.commands.RedoCommand;
import grail.scanner.commands.RepeatCommand;
import grail.scanner.commands.RotateLeftArmCommand;
import grail.scanner.commands.RotateRightArmCommand;
import grail.scanner.commands.SayCommand;
import grail.scanner.commands.SleepCommand;
import grail.scanner.commands.ThreadCommand;
import grail.scanner.commands.UndoCommand;
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
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"Parser"})
@PropertyNames({"CommandText", "CommandObject", "Errors"})
@EditablePropertyNames({"CommandText"})
public class Parser implements ParserInterface {

	@Override
	public String getCommandText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCommandText(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CommandThread getCommandObject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrors() {
		// TODO Auto-generated method stub
		return null;
	}

}
