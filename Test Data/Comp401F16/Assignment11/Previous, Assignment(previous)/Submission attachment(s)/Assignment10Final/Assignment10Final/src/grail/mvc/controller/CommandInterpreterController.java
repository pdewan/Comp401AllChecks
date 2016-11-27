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
	
	public static final String SAY_TAG = "Say";
	public static final String APPROACH_TAG = "Approach";
	public static final String PASS_TAG = "Passed";
	public static final String FAIL_TAG = "Failed";
	
	private static final String MOVE_ARTHUR_LEFT_COMMAND = "move arthur - 20 0";
	private static final String MOVE_ARTHUR_RIGHT_COMMAND = "move arthur 20 0";
	private static final String SAY_COMMAND = "say \"Guess someone clicked a button\"";
	
	private CommandInterpreterInterface interpreter;
	private CommandInterpreterViewInterface uiFrame;
	private BridgeSceneInterface scene;
	
	private JTextField textField;
	private JButton sayButton;
	private JButton approachButton;
	private JButton failButton;
	private JButton passButton;
	
	public CommandInterpreterController(CommandInterpreterViewInterface frame){
		uiFrame = frame;
		frame.addControllerListener(this);
		
		textField = frame.getTextField();
		sayButton = frame.getSay();
		approachButton = frame.getApproach();
		failButton = frame.getFail();
		passButton = frame.getPass();
		
		interpreter = SingletonsCreator.commandInterpreterFactoryMethod();
		interpreter.addPropertyChangeListener(this);
		
		scene = SingletonsCreator.bridgeSceneFactoryMethod();
		scene.addPropertyChangeListener(this);
		
		//Set initial buttons settings
		sayButton.setEnabled(scene.preSay());
		approachButton.setEnabled(scene.preApproach());
		failButton.setEnabled(scene.preFailed());
		passButton.setEnabled(scene.prePassed());
	}

	@Override
	public JTextField getTextField(){
		return textField;
	}
	
	@Override
	public JButton getSay(){
		return sayButton;
	}
	
	@Override
	public JButton getPass(){
		return passButton;
	}
	
	@Override
	public JButton getFail(){
		return failButton;
	}
	
	@Override
	public JButton getApproach(){
		return approachButton;
	}

	@Override
	public JButton getButton() {
		return uiFrame.getButton();
	}

	@Override
	public JMenuItem getMenuItem() {
		return uiFrame.getMenuItem();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source =event.getSource();
		
		if (source == textField){
			interpreter.setCommand(event.getActionCommand());
			return;
			
		}else if (source == sayButton){
			interpreter.setCommand(SAY_COMMAND);
			
		}else if (source == approachButton){
			scene.approach(scene.getArthur());
			
		}else if (source == passButton){
			scene.passed();
			
		}else if (source == failButton){
			scene.failed();
			
		}else	if (CommandInterpreterView.MOVE_ARTHUR_LEFT.equals(event.getActionCommand())){
			interpreter.setCommand(MOVE_ARTHUR_LEFT_COMMAND);
		
		}else if (CommandInterpreterView.MOVE_ARTHUR_RIGHT.equals(event.getActionCommand())){
			interpreter.setCommand(MOVE_ARTHUR_RIGHT_COMMAND);
			
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		String methodName = (String)(event.getOldValue());
		Object newValue= event.getNewValue();
		
		if (SAY_TAG.equalsIgnoreCase(methodName)){
			sayButton.setEnabled((Boolean)newValue);
			
		} else if (APPROACH_TAG.equalsIgnoreCase(methodName)){
			approachButton.setEnabled((Boolean)newValue);
			
		}else if (PASS_TAG.equalsIgnoreCase(methodName)){
			passButton.setEnabled((Boolean)newValue);
			
		}else if (FAIL_TAG.equalsIgnoreCase(methodName)){
			failButton.setEnabled((Boolean)newValue);
		}
	}


}
