package grail.interfaces;

import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter","ObservableCommandInterpreter"})
public interface CommandInterpreterInterface {

	public String getCommand();
	public void setCommand(String command);

	public String getErrors();
	public void addPropertyChangeListener(PropertyChangeListener listener);
	
	@Tags({"asynchronousArthur"})
	public void asynchronousArthur();
	
	@Tags({"asynchronousGalahad"})
	public void asynchronousGalahad();
	
	@Tags({"asynchronousLancelot"})
	public void asynchronousLancelot();
	
	@Tags({"asynchronousRobin"})
	public void asynchronousRobin();
	
	@Tags({"asynchronousGuard"})
	public void asynchronousGuard();
	
	@Tags({"waitingArthur"})
	public void waitingArthur();
	
	@Tags({"waitingGalahad"})
	public void waitingGalahad();
	
	@Tags({"waitingLancelot"})
	public void waitingLancelot();
	
	@Tags({"waitingRobin"})
	public void waitingRobin();
	
	@Tags({"startAnimation"})
	public void startAnimation();

	@Tags({"lockstepArthur"})
	public void lockstepArthur();
	
	@Tags({"lockstepGalahad"})
	public void lockstepGalahad();
	
	@Tags({"lockstepLancelot"})
	public void lockstepLancelot();
	
	@Tags({"lockstepRobin"})
	public void lockstepRobin();
	
	@Tags({"lockstepGuard"})
	public void lockstepGuard();
}