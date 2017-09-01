package grail.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.SingletonsCreator;
import grail.animations.AnimatingCommand;
import grail.animations.Animator;
import grail.animations.ClapCommand;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Token;
import grail.interfaces.Word;
import grail.scanner.commands.MoveCommand;
import grail.scanner.commands.SayCommand;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import grail.tokenBeans.commandBeans.MoveCommandToken;
import grail.tokenBeans.commandBeans.SayCommandToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import grail.interfaces.Number;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter","ObservableCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors"})
@EditablePropertyNames({"Command"})
public class CommandInterpreter implements CommandInterpreterInterface {
	private static final String EOI = "end of input";
	private static final String QUOTE_TOKEN = "quoted string";
	private static final String COMMAND = "move or say";
	private static final String NUMBER_TOKEN = "integer";
	private static final String AVATAR_NAME = "avatar name";

	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
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
		String oldErrorString = errorString;	//used for notifying about change
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
		
		// If no unparsable tokens
		}else{
			currentIndex = 0;
			
			// Grader requires having the parse calls be done from this setter,
			// hence the executeCommand() call is inlined here.
			{
				CommandThread commandThread = null;
				
				if (currentIndex >= tokens.length){
					fillErrorString(EOI, COMMAND);
					return;
				}
				
				currentToken = tokens[currentIndex];
				
				// Parse:
				// Check if it's a say command
				if (currentToken instanceof SayCommandToken){
					++currentIndex;
					commandThread = parseSay();
					
				// Check if it's a move command
				}else if (currentToken instanceof MoveCommandToken){
					++currentIndex;
					commandThread = parseMove();
					
				}else {
					fillErrorString(currentToken.getInput(), COMMAND);
					return;
				}
				
				// Execute:
				if (null == commandThread){
					return;
				}else{
					commandThread.run();
				}
			}//end inline executeCommand()
		}
		notifyAllListeners("Errors", oldErrorString, errorString);
	}//end setCommand
	
	/**
	 * This, like the other helper functions, expects currentIndex to be set
	 * to the index in tokens of the command to be parsed, and leaves currentIndex
	 * pointing to right past the last command token. 
	 * 
	 */
	private void executeCommand(){
		CommandThread commandThread = null;
		
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, COMMAND);
			return;
		}
		
		currentToken = tokens[currentIndex];
		
		// Parse:
		// Check if it's a say command
		if (currentToken instanceof SayCommandToken){
			++currentIndex;
			commandThread = parseSay();
			
		// Check if it's a move command
		}else if (currentToken instanceof MoveCommandToken){
			++currentIndex;
			commandThread = parseMove();
			
		}else {
			fillErrorString(currentToken.getInput(), COMMAND);
			return;
		}
		
		// Execute:
		if (null == commandThread){
			return;
		}else{
			commandThread.run();
		}
	}
	
	/**
	 * Requires currentIndex to be set to just past a say token.
	 * 
	 * Returns null if invalid.
	 */
	@Tags({"parseSay"})
	private CommandThread parseSay() {
		String quote;
		
		// Check for additional token
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, QUOTE_TOKEN);
			return null;
		}
		
		currentToken = tokens[currentIndex];
		
		// Make sure it's a quote
		if (currentToken instanceof QuoteToken){
			quote = tokens[currentIndex].getInput();
		
		}else {	
			fillErrorString(currentToken.getInput(), QUOTE_TOKEN);
			return null;
		}

		++currentIndex;
		
		// Make sure command has ended
		if (!(currentIndex >= tokens.length)){
			fillErrorString(tokens[currentIndex].getInput(), EOI);
			return null;
		}
		
		return new SayCommand(scene, quote);
	}

	/**
	 * Requires currentIndex to be set to just past a move token.
	 * 
	 * Returns null if invalid.
	 */
	@Tags({"parseMove"})
	private CommandThread parseMove() {
		String avatarName;
		int moveX;
		int moveY;
		
		// Check for additional token
		if (currentIndex >= tokens.length){
			fillErrorString(EOI, AVATAR_NAME);
			return null;
		}
		
		currentToken = tokens[currentIndex];
		
		// Make sure it's a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			fillErrorString(currentToken.getInput(), AVATAR_NAME);
			return null;
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			fillErrorString(currentToken.getInput(), AVATAR_NAME);
			return null;
		}
		
		++currentIndex;
		
		moveX = processSignedInteger();
		if (parsingError){
			return null;
		}
		moveY = processSignedInteger();
		if (parsingError){
			return null;
		}
		
		// Make sure command has ended
		if (!(currentIndex >= tokens.length)){
			fillErrorString(tokens[currentIndex].getInput(), EOI);
			return null;
		}
		
		return new MoveCommand(avatar, moveX, moveY);
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

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		listeners.add(listener);
	}
	
	private void notifyAllListeners(String propertyName, Object oldValue, Object newValue){
		for (PropertyChangeListener listener : listeners){
			listener.propertyChange(new PropertyChangeEvent(this, propertyName, oldValue, newValue));
		}
	}

	@Override
	@Tags({"asynchronousArthur"})
	public void animateArthur() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(), scene.getArthur()));
		thread.start();
	}

	@Tags({"asynchronousGalahad"})
	@Override
	public void animateGalahad() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(), scene.getGalahad()));
		thread.start();
	}

	@Tags({"asynchronousLancelot"})
	@Override
	public void animateLancelot() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(), scene.getLancelot()));
		thread.start();
	}

	@Override
	@Tags({"asynchronousRobin"})
	public void animateRobin() {
		Thread thread = new Thread(new AnimatingCommand(new Animator(), scene.getRobin()));
		thread.start();
	}
	
	@Override
	@Tags({"asynchronousGuard"})
	public void clapGuard(){
		Thread thread = new Thread(new ClapCommand(new Animator(), scene));
		thread.start();
	}
	
	
}
