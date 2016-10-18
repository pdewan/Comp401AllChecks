package grail.scanner;

import grail.SingletonsCreator;
import grail.collections.MyTable;
import grail.commandBeans.MoveCommand;
import grail.commandBeans.SayCommand;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Token;
import grail.interfaces.Word;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import grail.interfaces.Number;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors"})
@EditablePropertyNames({"Command"})
public class CommandInterpreter implements CommandInterpreterInterface {

}
