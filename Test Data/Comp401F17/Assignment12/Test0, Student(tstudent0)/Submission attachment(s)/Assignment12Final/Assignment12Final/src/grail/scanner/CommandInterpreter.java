package grail.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.SingletonsCreator;
import grail.animations.AnimatingCommand;
import grail.animations.SleepBasedAnimator;
import grail.animations.WaitBasedAnimator;
import grail.animations.ClapCommand;
import grail.animations.ClapLockstepCommand;
import grail.animations.fromJavaTeaching.ABroadcastingClearanceManager;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Undoer;
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
	private BroadcastingClearanceManager clearanceManager;
	
	// Required table
	private Table avatars;
	
	// fields that back properties
	private String command ="";
	private String errorString = "";
	
	// Avatar-specific animators
	AnimatorInterface arthurAnimator = new SleepBasedAnimator();
	AnimatorInterface robinAnimator = new SleepBasedAnimator();
	AnimatorInterface galahadAnimator = new SleepBasedAnimator();
	AnimatorInterface lancelotAnimator = new SleepBasedAnimator();
	AnimatorInterface guardAnimator = new SleepBasedAnimator();
	
	// Lockstep animators
	AnimatorInterface arthurLockstepAnimator = new WaitBasedAnimator();
	AnimatorInterface robinLockstepAnimator = new WaitBasedAnimator();
	AnimatorInterface galahadLockstepAnimator = new WaitBasedAnimator();
	AnimatorInterface lancelotLockstepAnimator = new WaitBasedAnimator();
	
	// Constructor
	public CommandInterpreter(BridgeSceneInterface scene, ScannerBeanInterface scannerBean){
		this.scannerBean = scannerBean;
		this.scene = scene;
		parser = SingletonsCreator.parserFactoryMethod();
		avatars = SingletonsCreator.avatarTableFactoryMethod();
		clearanceManager = SingletonsCreator.broadcastingClearanceManagerMethod();
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
		CommandThread commandThread = parser.getCommandObject();
		commandThread.run();
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
	public void asynchronousArthur() {
		Thread thread = new Thread(new AnimatingCommand(arthurAnimator, scene.getArthur()));
		thread.start();
	}

	@Tags({"asynchronousGalahad"})
	@Override
	public void asynchronousGalahad() {
		Thread thread = new Thread(new AnimatingCommand(galahadAnimator, scene.getGalahad()));
		thread.start();
	}

	@Tags({"asynchronousLancelot"})
	@Override
	public void asynchronousLancelot() {
		Thread thread = new Thread(new AnimatingCommand(lancelotAnimator, scene.getLancelot()));
		thread.start();
	}

	@Override
	@Tags({"asynchronousRobin"})
	public void asynchronousRobin() {
		Thread thread = new Thread(new AnimatingCommand(robinAnimator, scene.getRobin()));
		thread.start();
	}
	
	@Override
	@Tags({"asynchronousGuard"})
	public void asynchronousGuard(){
		Thread thread = new Thread(new ClapCommand(guardAnimator, scene));
		thread.start();
	}
	
	@Override
	@Tags({"waitingArthur"})
	public void waitingArthur() {
		Thread thread = new Thread(new AnimatingCommand(arthurAnimator, scene.getArthur(), true));
		thread.start();
	}

	@Tags({"waitingGalahad"})
	@Override
	public void waitingGalahad() {
		Thread thread = new Thread(new AnimatingCommand(galahadAnimator, scene.getGalahad(), true));
		thread.start();
	}

	@Tags({"waitingLancelot"})
	@Override
	public void waitingLancelot() {
		Thread thread = new Thread(new AnimatingCommand(lancelotAnimator, scene.getLancelot(), true));
		thread.start();
	}

	@Override
	@Tags({"waitingRobin"})
	public void waitingRobin() {
		Thread thread = new Thread(new AnimatingCommand(robinAnimator, scene.getRobin(), true));
		thread.start();
	}
	
	@Tags({"startAnimation"})
	@Override
	public void startAnimation() {
		clearanceManager.proceedAll();
	}

	@Override
	public void lockstepArthur() {
		Thread thread = new Thread(new AnimatingCommand(arthurLockstepAnimator, scene.getArthur()));
		thread.start();
	}

	@Override
	public void lockstepGalahad() {
		Thread thread = new Thread(new AnimatingCommand(galahadLockstepAnimator, scene.getGalahad()));
		thread.start();
	}

	@Override
	public void lockstepLancelot() {
		Thread thread = new Thread(new AnimatingCommand(lancelotLockstepAnimator, scene.getLancelot()));
		thread.start();
	}

	@Override
	public void lockstepRobin() {
		Thread thread = new Thread(new AnimatingCommand(robinLockstepAnimator, scene.getRobin()));
		thread.start();
	}
	
	/**
	 * Moves any lockstep methods forward a step.
	 */
	@Override
	@Tags({"clapGuardLockstep"})
	public void lockstepGuard(){
		Thread thread = new Thread(new ClapLockstepCommand(guardAnimator, scene));
		thread.start();
	}
}
