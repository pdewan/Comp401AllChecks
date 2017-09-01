package grail.mvc.controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import grail.SingletonsCreator;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.mvc.view.CommandInterpreterView;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
@PropertyNames({"TextField", "Say", "Pass", "Fail", "Approach", "MenuItem", "Button"})
public class CommandInterpreterController implements CommandInterpreterControllerInterface {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
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
	public JButton getPass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getFail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JButton getApproach() {
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
