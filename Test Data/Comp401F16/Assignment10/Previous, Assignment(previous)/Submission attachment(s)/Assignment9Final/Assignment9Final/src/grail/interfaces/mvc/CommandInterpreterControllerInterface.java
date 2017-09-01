package grail.interfaces.mvc;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
public interface CommandInterpreterControllerInterface extends ActionListener{
	public JTextField getTextField();
	public JButton getButton();
	public JMenuItem getMenuItem();
}
