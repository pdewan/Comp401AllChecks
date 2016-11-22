package grail.mvc.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import grail.SingletonsCreator;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.mvc.controller.CommandInterpreterController;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterView"})
@PropertyNames({"TextField", "ProgressBar", "Say", "Pass", "Fail", "Approach", "MenuItem", "Button"})
public class CommandInterpreterView extends JFrame implements CommandInterpreterViewInterface{

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addControllerListener(ActionListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JTextField getTextField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getSay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getApproach() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getFail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getButton() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JMenuItem getMenuItem() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
