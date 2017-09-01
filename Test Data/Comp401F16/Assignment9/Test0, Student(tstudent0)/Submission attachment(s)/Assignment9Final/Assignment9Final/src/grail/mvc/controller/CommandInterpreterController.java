package grail.mvc.controller;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import grail.SingletonsCreator;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterController"})
@PropertyNames({"TextField", "MenuItem", "Button"})
public class CommandInterpreterController implements CommandInterpreterControllerInterface {
	
	public static final String MOVE_ARTHUR_LEFT = "Move Arthur left";
	public static final String MOVE_ARTHUR_RIGHT = "Move Arthur right";
	
	private static final String MOVE_ARTHUR_LEFT_COMMAND = "move arthur - 20 0";
	private static final String MOVE_ARTHUR_RIGHT_COMMAND = "move arthur 20 0";
	
	private CommandInterpreterInterface interpreter;
	private CommandInterpreterViewInterface uiFrame;
	private JTextField textField;
	
	public CommandInterpreterController(CommandInterpreterViewInterface frame){
		uiFrame = frame;
		frame.addControllerListener(this);
		textField = frame.getTextField();
		interpreter = SingletonsCreator.commandInterpreterFactoryMethod();
	}

	@Override
	public JTextField getTextField(){
		return textField;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		Object o =event.getSource();
		int i = event.getID();
		String s =event.getActionCommand();
		if (event.getSource() == textField){
			interpreter.setCommand(event.getActionCommand());
			return;
		
		}else	if (MOVE_ARTHUR_LEFT.equals(event.getActionCommand())){
			interpreter.setCommand(MOVE_ARTHUR_LEFT_COMMAND);
		
		}else if (MOVE_ARTHUR_RIGHT.equals(event.getActionCommand())){
			interpreter.setCommand(MOVE_ARTHUR_RIGHT_COMMAND);
			
		}
	}

	@Override
	public JButton getButton() {
		return uiFrame.getButton();
	}

	@Override
	public JMenuItem getMenuItem() {
		return uiFrame.getMenuItem();
	}


}
