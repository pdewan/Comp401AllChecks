package grail.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.SingletonsCreator;
import grail.animations.AnimatingCommand;
import grail.animations.Animator;
import grail.animations.ClapCommand;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import grail.interfaces.ParserInterface;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter","ObservableCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors"})
@EditablePropertyNames({"Command"})
public class CommandInterpreter implements CommandInterpreterInterface {

	private List<PropertyChangeListener> listeners = new ArrayList<PropertyChangeListener>();
	
	// Key references
	private ScannerBeanInterface scannerBean;
	private BridgeSceneInterface scene;
	private ParserInterface parser;
	
	// Required table
	private Table avatars;
	
	// fields that back properties
	private String command ="";
	private String errorString = "";
	
	// Avatar-specific animators
	AnimatorInterface arthurAnimator = new Animator();
	AnimatorInterface robinAnimator = new Animator();
	AnimatorInterface galahadAnimator = new Animator();
	AnimatorInterface lancelotAnimator = new Animator();
	AnimatorInterface guardAnimator = new Animator();
	
	// Constructor
	public CommandInterpreter(BridgeSceneInterface scene, ScannerBeanInterface scannerBean){
		this.scannerBean = scannerBean;
		this.scene = scene;
		parser = SingletonsCreator.parserFactoryMethod();
		avatars = SingletonsCreator.avatarTableFactoryMethod();
	}
	
	@Override
	public String getCommand(){
		return command;
	}
	
	@Override
	public void setCommand(String command){
		String oldCommand = this.command;
		this.command = command;
		parser.setCommandText(command);
		
		String oldErrorString = errorString;
		errorString = parser.getErrors();
		notifyAllListeners("Errors", oldErrorString, errorString);
		notifyAllListeners("Command", oldCommand, command);
		
		// Execute the command
		Runnable commandThread = parser.getCommandObject();
		if (null == commandThread){
			return;
		}else{
			commandThread.run();
		}
	}//end setCommand

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
		Thread thread = new Thread(new AnimatingCommand(arthurAnimator, scene.getArthur()));
		thread.start();
	}

	@Tags({"asynchronousGalahad"})
	@Override
	public void animateGalahad() {
		Thread thread = new Thread(new AnimatingCommand(galahadAnimator, scene.getGalahad()));
		thread.start();
	}

	@Tags({"asynchronousLancelot"})
	@Override
	public void animateLancelot() {
		Thread thread = new Thread(new AnimatingCommand(lancelotAnimator, scene.getLancelot()));
		thread.start();
	}

	@Override
	@Tags({"asynchronousRobin"})
	public void animateRobin() {
		Thread thread = new Thread(new AnimatingCommand(robinAnimator, scene.getRobin()));
		thread.start();
	}
	
	@Override
	@Tags({"asynchronousGuard"})
	public void clapGuard(){
		Thread thread = new Thread(new ClapCommand(guardAnimator, scene));
		thread.start();
	}
	
	
}
