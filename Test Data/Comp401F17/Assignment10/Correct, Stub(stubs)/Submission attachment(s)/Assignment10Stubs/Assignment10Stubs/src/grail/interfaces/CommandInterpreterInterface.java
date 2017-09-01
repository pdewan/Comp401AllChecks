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
	void clapGuard();
}