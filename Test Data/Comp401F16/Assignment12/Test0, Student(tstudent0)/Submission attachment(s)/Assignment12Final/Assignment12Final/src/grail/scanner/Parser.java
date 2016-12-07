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

	private static final String EOI = "end of input";
	private static final String QUOTE_TOKEN = "quoted string";
	private static final String COMMAND = "valid command";
	private static final String NUMBER_TOKEN = "integer";
	private static final String AVATAR_NAME = "avatar name";
	private static final String END_TOKEN = "end token (})";
	private static final String DEFINED_COMMAND_NAME = "defined command name";
	private static final String WORD_TOKEN = "word token";
	private static final String EMPTY_STRING = "";
	
	private ScannerBeanInterface scanner = SingletonsCreator.scannerFactoryMethod();
	private BridgeSceneInterface scene = SingletonsCreator.bridgeSceneFactoryMethod();
	private Table<AvatarInterface> avatars = SingletonsCreator.avatarTableFactoryMethod();
	private Table<CommandThread> routines = new MyTable<CommandThread>();
	private BroadcastingClearanceManager clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();
	private Set<String> routineNames = new HashSet<String>();
	private Undoer undoer = SingletonsCreator.undoerFactoryMethod();
	
	// Property-backing fields
	private String commandText = "";
	private CommandThread commandObject;
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

		try{
			scanner.setScannedString(string);
			tokens = scanner.getTokens();

			// parse into one command
			commandObject = parseCommand();
			
			// Make sure command has ended
			if (hasNext()){
				throw new ParsingException(next().getInput(), EOI);
			}
		}catch(ParsingException e){
			fillErrorString(e.getEncountered(), e.getExpected());
			
		}catch(ScanningException e){
			String[] errors = e.getErrors();
			errorString = "ERROR- Invalid tokens in command: " + errors[0];
			for (int i = 1; i < errors.length; ++i){
				errorString += (", " + errors[i]);
			}
			commandObject = null;
		}//end catch ScanningException
		
	}
	
	@Override
	public CommandThread getCommandObject(){
		return commandObject;
	}
	
	@Override
	public String getErrors(){
		return errorString;
	}
	
	private CommandThread parseCommand() throws ParsingException{
		
		if (!hasNext()){
			throw new ParsingException(EOI, COMMAND);
		}
		
		// Parse proper command based on first token
		Token currentToken = peek();
		
		if (currentToken instanceof SayCommandToken){
			return parseSayCommand();
			
		}else if (currentToken instanceof MoveCommandToken){
			UndoableCommandThread moveCommand = parseMoveCommand();
			return new ExecuteUndoableCommand(undoer, moveCommand);
			
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
			
		}else if (currentToken instanceof RotateLeftArmCommandToken){
			return parseRotateLeftArm();
			
		}else if (currentToken instanceof RotateRightArmCommandToken){
			return parseRotateRightArm();
			
		}else if (currentToken instanceof SleepCommandToken){
			return parseSleep();
			
		}else if (currentToken instanceof DefineCommandToken){
			return parseDefine();
			
		}else if (currentToken instanceof CallCommandToken){
			return parseCall();
			
		}else if (currentToken instanceof ThreadCommandToken){
			return parseThread();
			
		}else if (currentToken instanceof ProceedAllCommandToken){
			return parseProceedAll();
			
		}else if (currentToken instanceof UndoCommandToken){
			return parseUndo();
			
		}else if (currentToken instanceof RedoCommandToken){
			return parseRedo();
			
		}else {
			throw new ParsingException(currentToken.getInput(), COMMAND);
		}
	}
	
	@Tags({"parseProceedAllCommand"})
	private CommandThread parseProceedAll() {
		next();	//consume token
		
		return new ProceedAllCommand(clearanceManager);
	}
	
	@Tags({"parseRedoCommand"})
	private CommandThread parseRedo() {
		next();	//consume token
		
		return new RedoCommand(undoer);
	}
	
	@Tags({"parseUndoCommand"})
	private CommandThread parseUndo() {
		next();	//consume token
		
		return new UndoCommand(undoer);
	}
	
	@Tags({"parseThreadCommand"})
	private CommandThread parseThread() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, DEFINED_COMMAND_NAME);
		}
		
		Token currentToken = next();
		String commandName;
		
		// Make sure token is a word
		if (currentToken instanceof Word){
			commandName = currentToken.getInput();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), DEFINED_COMMAND_NAME);
		}
		
		if (!routineNames.contains(commandName)){
			throw new ParsingException(currentToken.getInput(), DEFINED_COMMAND_NAME);
		}
		
		return new ThreadCommand(commandName, routines);
	}

	@Tags({"parseCallCommand"})
	private CommandThread parseCall() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, DEFINED_COMMAND_NAME);
		}
		
		Token currentToken = next();
		String commandName;
		
		// Make sure token is a word
		if (currentToken instanceof Word){
			commandName = currentToken.getInput();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), DEFINED_COMMAND_NAME);
		}
		
		if (!routineNames.contains(commandName)){
			throw new ParsingException(currentToken.getInput(), DEFINED_COMMAND_NAME);
		}
		
		return new CallCommand(commandName, routines);
	}

	@Tags({"parseDefineCommand"})
	private CommandThread parseDefine() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, WORD_TOKEN);
		}
		
		String commandName;
		Token currentToken = next();
		
		if (currentToken instanceof WordToken){
			commandName = currentToken.getInput();
			routineNames.add(commandName);
		
		} else{
			throw new ParsingException(EOI, WORD_TOKEN);
		}
		
		CommandThread command = parseCommand();
		
		return new DefineCommand(commandName, command, routines);
	}

	@Tags({"parseSleepCommand"})
	private CommandThread parseSleep() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, NUMBER_TOKEN);
		}
		
		long sleepMilliseconds;
		Token currentToken = next();
		if (currentToken instanceof NumberToken){
			sleepMilliseconds = ((NumberToken) currentToken).getValue();
		}else{
			throw new ParsingException(currentToken.getInput(), NUMBER_TOKEN);
		}
		
		return new SleepCommand(sleepMilliseconds);
	}

	@Tags({"parseRotateRightArmCommand"})
	private CommandThread parseRotateRightArm() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, AVATAR_NAME);
		}
		
		String avatarName;
		Token currentToken = next();

		// Make sure token is a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		int rotateDegrees = parseNumber();
		
		return new RotateRightArmCommand(avatar, rotateDegrees);
	}

	@Tags({"parseRotateLeftArmCommand"})
	private CommandThread parseRotateLeftArm() throws ParsingException {
		next(); 	//skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, AVATAR_NAME);
		}
		
		String avatarName;
		Token currentToken = next();

		// Make sure token is a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		int rotateDegrees = parseNumber();
		
		return new RotateLeftArmCommand(avatar, rotateDegrees);
	}

	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return SayCommand
	 * @throws ParsingException 
	 */
	private SayCommand parseSayCommand() throws ParsingException{
		
		next(); 	// skip the move token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, QUOTE_TOKEN);
		}
		
		String quote;
		Token currentToken = next();	// grab the quote
		
		// Make sure it's a quote
		if (currentToken instanceof QuoteToken){
			quote = currentToken.getInput();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), QUOTE_TOKEN);
		}
		
		return new SayCommand(scene, quote);
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return MoveCommand
	 * @throws ParsingException 
	 */
	private MoveCommand parseMoveCommand() throws ParsingException{
		next(); // Skip first token
		
		// The three things we need
		String avatarName;
		int moveX;
		int moveY;
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, AVATAR_NAME);
		}
		
		Token currentToken = next();
		
		// Make sure it's a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		moveX = parseNumber();
		moveY = parseNumber();
		
		return new MoveCommand(avatar, moveX, moveY);
	}
	
	/**
	 * Expects index to be pointing to first token of signed integer,
	 * and leaves it pointing just past the last token. Sets parsingError to
	 * true if there was an incorrect token (reports it itself in console).
	 * 
	 * @return parsed signed integer.
	 * @throws ParsingException 
	 */
	@Tags({"parseNumber"})
	private int parseNumber() throws ParsingException {

		int returnValue = 1;	// Must start at 1 to allow multiplication
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, NUMBER_TOKEN);
		}
		
		Token currentToken = next();
		
		// See if it's a sign
		if (currentToken instanceof PlusToken){

			// Check for additional token after sign
			if (!hasNext()){
				throw new ParsingException(EOI, NUMBER_TOKEN);
			}
			
			// No modifications necessary
			currentToken = next();
					
		} else if (currentToken instanceof MinusToken) {
			returnValue *= -1;
			
			// Check for additional token
			if (!hasNext()){
				throw new ParsingException(EOI, NUMBER_TOKEN);
			}
			
			currentToken = next();
		}

		// Grab the actual number
		if (currentToken instanceof NumberToken){
			returnValue *= ((Number)currentToken).getValue();
		
		}else{
			throw new ParsingException(currentToken.getInput(), NUMBER_TOKEN);
		}
		
		return returnValue;
	}
	
	/**
	 * Like the other helper methods, expects index to point to first token of command,
	 * and the first token to be correct.
	 * 
	 * @return ApproachCommand
	 * @throws ParsingException 
	 */
	private ApproachCommand parseApproachCommand() throws ParsingException{
		next(); 	// skip the first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, AVATAR_NAME);
		}
		
		Token currentToken = next();
		String avatarName;
		
		// Make sure it's a word
		if (currentToken instanceof Word){
			avatarName = ((Word)currentToken).getValue();
		
		}else {	
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
		}
		
		// Check that word is valid avatar name
		AvatarInterface avatar = (AvatarInterface)avatars.get(avatarName);
		if (null == avatar){
			throw new ParsingException(currentToken.getInput(), AVATAR_NAME);
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
	
	
	private CompositeCommandThread parseCommandList() throws ParsingException{
		next();	// Skip first token
		
		CompositeCommandThread commandList = new CommandList();
		
		while(hasNext() && !(peek() instanceof EndToken)){
			commandList.add(parseCommand());
		}
		
		// See if there is a closing bracket
		if (!hasNext()){
			throw new ParsingException(EOI, END_TOKEN);
		}
		
		Token currentToken = next();
		if (!(currentToken instanceof EndToken)){
			throw new ParsingException(currentToken.getInput(), END_TOKEN);
		}
		
		return commandList;
	}
	
	
	private RepeatCommand parseRepeatCommand() throws ParsingException{
		next();	// Skip first token
		
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, NUMBER_TOKEN);
		}
		
		Token currentToken = next();
		int numRepetitions = 0;
		
		if (currentToken instanceof NumberToken){
			numRepetitions = ((NumberToken) currentToken).getValue();
		
		}else{
			throw new ParsingException(currentToken.getInput(), NUMBER_TOKEN);
		}
			
		// Check for additional token
		if (!hasNext()){
			throw new ParsingException(EOI, COMMAND);
		}
		
		CommandThread command = parseCommand();
		
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
