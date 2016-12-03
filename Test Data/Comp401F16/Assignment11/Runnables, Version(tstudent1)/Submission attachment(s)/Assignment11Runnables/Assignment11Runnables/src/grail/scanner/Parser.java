package grail.scanner;

import grail.SingletonsCreator;
import grail.interfaces.AvatarInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CompositeCommandThread;
import grail.interfaces.Number;
import grail.interfaces.ParserInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Token;
import grail.interfaces.Word;
import grail.scanner.commands.ApproachCommand;
import grail.scanner.commands.CommandList;
import grail.scanner.commands.FailCommand;
import grail.scanner.commands.MoveCommand;
import grail.scanner.commands.PassCommand;
import grail.scanner.commands.RepeatCommand;
import grail.scanner.commands.SayCommand;
import grail.tokenBeans.EndToken;
import grail.tokenBeans.MinusToken;
import grail.tokenBeans.NumberToken;
import grail.tokenBeans.PlusToken;
import grail.tokenBeans.QuoteToken;
import grail.tokenBeans.StartToken;
import grail.tokenBeans.commandBeans.ApproachCommandToken;
import grail.tokenBeans.commandBeans.FailCommandToken;
import grail.tokenBeans.commandBeans.MoveCommandToken;
import grail.tokenBeans.commandBeans.PassCommandToken;
import grail.tokenBeans.commandBeans.RepeatCommandToken;
import grail.tokenBeans.commandBeans.SayCommandToken;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"Parser"})
@PropertyNames({"CommandText", "CommandObject", "Errors"})
@EditablePropertyNames({"CommandText"})
public class Parser implements ParserInterface {

	private static final String EOI = "end of input";
	private static final String QUOTE_TOKEN = "quoted string";
	private static final String COMMAND = "move/say/approach/pass/fail/repeat/{";
	private static final String NUMBER_TOKEN = "integer";
	private static final String AVATAR_NAME = "avatar name";
	private static final String END_TOKEN = "end token (})";
	private static final String EMPTY_STRING = "";
	
	
	private ScannerBeanInterface scanner = SingletonsCreator.scannerFactoryMethod();
	private BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
	private Table avatars = SingletonsCreator.avatarTableFactoryMethod();
	
	// Property-backing fields
	private String commandText = "";
	private Runnable commandObject;
	private String errorString = "";
	
	private Token[] tokens;
	private int tokenIndex;
	
	@Override
	public String getCommandText(){
		return commandText;
	}
	
	
	@Override
	public void setCommandText(String string){
		commandText = string;
		errorString = "";
		reset();
	
		scanner.setScannedString(string);
		tokens = scanner.getTokens();
		
		// Check for unparseable tokens
		String[] errors = scanner.getErrors();
		if (errors.length != 0){
			errorString = "ERROR- Invalid tokens in command: " + errors[0];
			for (int i = 1; i < errors.length; ++i){
				errorString += (", " + errors[i]);
			}
		}
		
		// If parseable, parse into one command
		commandObject = parseCommand();
		if (!EMPTY_STRING.equals(errorString)){
			return;
		}
		
		// Make sure command has ended
		if (hasNext()){
			fillErrorString(next().getInput(), EOI);
		}
	}
	
	@Override
	public Runnable getCommandObject(){
		return commandObject;
	}
	
	@Override
	public String getErrors(){
		return errorString;
	}
	
	private Runnable parseCommand(){
		
		if (!hasNext()){
			fillErrorString(EOI, COMMAND);
			return null;
		}
		
		// Parse proper command based on first token
		Token currentToken = peek();
		
		if (currentToken instanceof SayCommandToken){
			return parseSayCommand();
			
		}else if (currentToken instanceof MoveCommandToken){
			return parseMoveCommand();
			
		}else if (currentToken instanceof ApproachCommandToken){
			return parseApproachCommand();
			
		}else if (currentToken instanceof PassCommandToken){
			return parsePassCommand();
			
		}else if (currentToken instanceof FailCommandToken){
			return parseFailCommand();
			
		}else if (currentToken instanceof RepeatCommandToken){
			return parseRepeatCommand();
			
		}else if (currentToken instanceof StartToken){
			return parseCommandList();
			
		}else {
			fillErrorString(currentToken.getInput(), COMMAND);
			return null;
		}
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return SayCommand
	 */
	private SayCommand parseSayCommand(){
		
		next(); 	// skip the move token
		
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, QUOTE_TOKEN);
			return null;
		}
		
		String quote;
		Token currentToken = next();	// grab the quote
		
		// Make sure it's a quote
		if (currentToken instanceof QuoteToken){
			quote = currentToken.getInput();
		
		}else {	
			fillErrorString(currentToken.getInput(), QUOTE_TOKEN);
			return null;
		}
		
		return new SayCommand(scene, quote);
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return MoveCommand
	 */
	private MoveCommand parseMoveCommand(){
		next(); // Skip first token
		
		// The three things we need
		String avatarName;
		int moveX;
		int moveY;
		
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, AVATAR_NAME);
			return null;
		}
		
		Token currentToken = next();
		
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
		
		moveX = parseNumber();
		if (!EMPTY_STRING.equals(getErrors())){
			return null;	//processSignedInteger already filled errorString
		}
		
		moveY = parseNumber();
		if (!EMPTY_STRING.equals(getErrors())){
			return null;
		}
		
		return new MoveCommand(avatar, moveX, moveY);
	}
	
	/**
	 * Expects index to be pointing to first token of signed integer,
	 * and leaves it pointing just past the last token. Sets parsingError to
	 * true if there was an incorrect token (reports it itself in console).
	 * 
	 * @return parsed signed integer.
	 */
	@Tags({"parseNumber"})
	private int parseNumber() {

		int returnValue = 1;	// Must start at 1 to allow multiplication
		
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, NUMBER_TOKEN);
			return 0;
		}
		
		Token currentToken = next();
		
		// See if it's a sign
		if (currentToken instanceof PlusToken){

			// Check for additional token after sign
			if (!hasNext()){
				fillErrorString(EOI, NUMBER_TOKEN);
				return 0;
			}
			
			// No modifications necessary
			currentToken = next();
					
		} else if (currentToken instanceof MinusToken) {
			returnValue *= -1;
			
			// Check for additional token
			if (!hasNext()){
				fillErrorString(EOI, NUMBER_TOKEN);
				return 0;
			}
			
			currentToken = next();
		}

		// Grab the actual number
		if (currentToken instanceof NumberToken){
			returnValue *= ((Number)currentToken).getValue();
		
		}else{
			fillErrorString(currentToken.getInput(), NUMBER_TOKEN);
			return 0;
		}
		
		return returnValue;
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return ApproachCommand
	 */
	private ApproachCommand parseApproachCommand(){
		next(); 	// skip the first token
		
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, AVATAR_NAME);
			return null;
		}
		
		Token currentToken = next();
		String avatarName;
		
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
		
		return new ApproachCommand(scene, avatar);
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return PassCommand
	 */
	private PassCommand parsePassCommand(){
		next(); 	// skip token
		return new PassCommand(scene);
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return FailCommand
	 */
	private FailCommand parseFailCommand(){
		next(); 	// skip token
		return new FailCommand(scene);
	}
	
	
	private CommandList parseCommandList(){
		next();	// Skip first token
		
		CompositeCommandThread commandList = new CommandList();
		
		while(hasNext() && !(peek() instanceof EndToken)){
			commandList.add(parseCommand());
			
			// Check that each command was properly parsed
			if (!EMPTY_STRING.equals(getErrors())){
				return null;
			}
		}
		
		// See if there is a closing bracket
		if (!hasNext()){
			fillErrorString(EOI, END_TOKEN);	
			return null;
		}
		
		Token currentToken = next();
		if (!(currentToken instanceof EndToken)){
			fillErrorString(currentToken.getInput(), END_TOKEN);
			return null;
		}
		
		return (CommandList)commandList;
	}
	
	
	private RepeatCommand parseRepeatCommand(){
		next();	// Skip first token
		
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, NUMBER_TOKEN);
			return null;
		}
		
		Token currentToken = next();
		int numRepetitions = 0;
		
		if (currentToken instanceof NumberToken){
			numRepetitions = ((NumberToken) currentToken).getValue();
		
		}else{
			fillErrorString(currentToken.getInput(), NUMBER_TOKEN);
			return null;
		}
			
		// Check for additional token
		if (!hasNext()){
			fillErrorString(EOI, COMMAND);
			return null;
		}
		
		Runnable command = parseCommand();
		
		return new RepeatCommand(numRepetitions, command);
	}
	
	private void fillErrorString(String encountered, String expected) {
		errorString = "ERROR- Encountered: " + encountered 
				+ " Expected: " + expected;
	}
	
	private Token next(){
		Token toReturn = tokens[tokenIndex];
		++tokenIndex;
		return toReturn;
	}
	private Token peek(){
		return tokens[tokenIndex];
	}
	
	private boolean hasNext(){
		return tokenIndex < tokens.length;
	}

	private void reset(){
		tokenIndex = 0;
	}
	
}
