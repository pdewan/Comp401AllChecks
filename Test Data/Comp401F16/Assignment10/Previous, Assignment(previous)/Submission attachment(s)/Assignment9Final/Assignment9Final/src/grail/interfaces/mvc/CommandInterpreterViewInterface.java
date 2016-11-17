package grail.interfaces.mvc;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JTextField;

public interface CommandInterpreterViewInterface extends PropertyChangeListener {
	public void addControllerListener(ActionListener listener);
	JTextField getTextField();
}
