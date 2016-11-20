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
	private static final String EOI = "end of input";
	private static final String QUOTE_TOKEN = "quoted string";
	private static final String COMMAND = "move or say";
	private static final String NUMBER_TOKEN = "integer";
	private static final String AVATAR_NAME = "avatar name";

	// Key references
	private ScannerBeanInterface scannerBean;
	private BridgeSceneInterface scene;
	
	// Required table
	private Table avatars;
	
	// fields that back properties
	private String command ="";
	private String errorString = "";
	
	// Convenience fields- these could be passed as parameters
	private Token[] tokens;
	private Token currentToken;
	private int currentIndex;
	
	// Needed since not using exceptions, to let called functions 
	// indicate whether they succeeded
	boolean parsingError;
	
	// Constructor
	public CommandInterpreter(BridgeSceneInterface scene, ScannerBeanInterface scannerBean){
		this.scannerBean = scannerBean;
		this.scene = scene;
		avatars = SingletonsCreator.avatarTableFactoryMethod();
	}
	
	@Override
	public String getCommand(){
		return command;
	}
	
	@Override
	public void setCommand(String command){
		this.command = command;
		errorString = "";
		scannerBean.setScannedString(command);
		tokens = scannerBean.getTokens();
		
		// Check for unparseable tokens
		String[] errors = scannerBean.getErrors();
		if (scannerBean.getErrors().length != 0){
			errorString = "ERROR- Invalid tokens in command: " + errors[0];
			for (int i = 1; i < errors.length; ++i){
				errorString += (", " + errors[i]);
			}
			return;
		
		// If no unparsable tokens
		}else{
			currentIndex = 0;
			executeCommand();	
		}
	}//end setCommand
	
	/**
	 * This, like the other helper functions, expects currentIndex to be set
	 * to the index in tokens of the command to be parsed, and leaves currentIndex
	 * pointing to right past the last command token. 
	 * 
	 */
	private void executeCommand(){
		
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, COMMAND);
			return;
		}
		
		currentToken = tokens[currentIndex];
		
		// Check if it's a say command
		if (currentToken instanceof SayCommand){
			++currentIndex;
			executeSayCommand();
			
		// Check if it's a move command
		}else if (currentToken instanceof MoveCommand){
			++currentIndex;
			executeMoveCommand();
			
		}else {
			fillErrorString(currentToken.getInput(), COMMAND);
			return;
		}
	}

	private void executeSayCommand() {
		String quote;
		
		// Check for additional token
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, QUOTE_TOKEN);
			return;
		}
		
		currentToken = tokens[currentIndex];
		
		// Make sure it's a quote
		if (currentToken instanceof QuoteToken){
			quote = tokens[currentIndex].getInput();
		
		}else {	
			fillErrorString(currentToken.getInput(), QUOTE_TOKEN);
			return;
		}

		++currentIndex;
		
		// Make sure command has ended
		if (!(currentIndex >= tokens.length)){
			fillErrorString(tokens[currentIndex].getInput(), EOI);
			return;
		}
		
		scene.say(quote);
	}

	private void executeMoveCommand() {
		String avatarName;
		int moveX;
		int moveY;
		
		// Check for additional token
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, QUOTE_TOKEN);
			return;
		}
		
		currentToken = tokens[currentIndex];
		
		// Make sure it's a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			fillErrorString(currentToken.getInput(), AVATAR_NAME);
			return;
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			fillErrorString(currentToken.getInput(), AVATAR_NAME);
			return;
		}
		
		++currentIndex;
		
		moveX = processSignedInteger();
		if (parsingError){
			return;
		}
		moveY = processSignedInteger();
		if (parsingError){
			return;
		}
		
		// Make sure command has ended
		if (!(currentIndex >= tokens.length)){
			fillErrorString(tokens[currentIndex].getInput(), EOI);
			return;
		}
		
		avatar.move(moveX,moveY);
	}
	
	/**
	 * Expects currentIndex to be pointing to first token of signed integer,
	 * and leaves it pointing just past the last token. Sets parsingError to
	 * true if there was an incorrect token (reports it itself in console).
	 * 
	 * @return parsed signed integer.
	 */
	private int processSignedInteger() {

		parsingError = false;
		int returnValue = 1;
		
		// Check for additional token
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, NUMBER_TOKEN);
			parsingError = true;
			return 0;
		}
		
		currentToken = tokens[currentIndex];
		
		// See if it's a sign
		if (currentToken instanceof PlusToken){
			++currentIndex;
			
			// Check for additional token after sign
			if (currentIndex >= tokens.length){
				fillErrorString(EOI, NUMBER_TOKEN);
				parsingError = true;
				return 0;
			}
		
		} else if (currentToken instanceof MinusToken) {
			returnValue *= -1;
			++currentIndex;
			
			// Check for additional token
			if (currentIndex >= tokens.length){
				fillErrorString(EOI, NUMBER_TOKEN);
				parsingError = true;
				return 0;
			}
		}

		currentToken = tokens[currentIndex];
		if (currentToken instanceof NumberToken){
			returnValue *= ((Number)currentToken).getValue();
		}else{
			fillErrorString(currentToken.getInput(), NUMBER_TOKEN);
			parsingError = true;
			return 0;
		}
		++currentIndex;
		
		return returnValue;
	}

	private void fillErrorString(String encountered, String expected) {
		errorString = "ERROR- Encountered: " + encountered 
				+ " Expected: " + expected;
	}

	@Override
	public String getErrors() {
		return errorString;
	}
}
