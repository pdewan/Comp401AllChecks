package grail.interfaces.mvc;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
public interface CommandInterpreterControllerInterface extends ActionListener, PropertyChangeListener{
	public JTextField getTextField();
	public JButton getSay();
	public JButton getPass();
	public JButton getFail();
	public JButton getApproach();
	
}
