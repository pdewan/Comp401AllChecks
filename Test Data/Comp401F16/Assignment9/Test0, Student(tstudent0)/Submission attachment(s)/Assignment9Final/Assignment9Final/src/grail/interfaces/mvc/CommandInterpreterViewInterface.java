package grail.interfaces.mvc;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public interface CommandInterpreterViewInterface extends PropertyChangeListener {
	public void addControllerListener(ActionListener listener);
	public JTextField getTextField();
	public JButton getButton();
	public JMenuItem getMenuItem();
}
