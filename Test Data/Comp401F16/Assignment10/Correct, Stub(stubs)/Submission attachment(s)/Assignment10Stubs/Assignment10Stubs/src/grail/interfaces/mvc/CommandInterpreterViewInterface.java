package grail.interfaces.mvc;

import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import util.annotations.Tags;

@Tags({"CommandInterpreterView"})
public interface CommandInterpreterViewInterface extends PropertyChangeListener {
	public void addControllerListener(ActionListener listener);
	public JTextField getTextField();
	public JButton getSay();
	public JButton getApproach();
	public JButton getFail();
	public JButton getPass();
	public JButton getButton();
	public JMenuItem getMenuItem();
}
