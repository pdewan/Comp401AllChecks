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
	public void animateArthur();
	
	@Tags({"asynchronousGalahad"})
	public void animateGalahad();
	
	@Tags({"asynchronousLancelot"})
	public void animateLancelot();
	
	@Tags({"asynchronousRobin"})
	public void animateRobin();
	
	@Tags({"asynchronousGuard"})
	public void clapGuard();
	
	@Tags({"waitingArthur"})
	public void animateArthurWithWait();
	
	@Tags({"waitingGalahad"})
	public void animateGalahadWithWait();
	
	@Tags({"waitingLancelot"})
	public void animateLancelotWithWait();
	
	@Tags({"waitingRobin"})
	public void animateRobinWithWait();
	
	@Tags({"startAnimation"})
	public void startAnimation();

	@Tags({"lockstepArthur"})
	public void animateArthurWithLockstep();
	
	@Tags({"lockstepGalahad"})
	public void animateGalahadWithLockstep();
	
	@Tags({"lockstepLancelot"})
	public void animateLancelotWithLockstep();
	
	@Tags({"lockstepRobin"})
	public void animateRobinWithLockstep();
	
	@Tags({"lockstepGuard"})
	public void clapGuardLockstep();
}