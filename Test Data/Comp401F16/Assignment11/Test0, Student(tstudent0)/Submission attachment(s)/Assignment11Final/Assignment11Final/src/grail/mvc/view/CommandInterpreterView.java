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
import javax.swing.JTextField;

import grail.SingletonsCreator;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@Tags({"CommandInterpreterView"})
@PropertyNames({"TextField", "ProgressBar", "Say", "Pass", "Fail", "Approach", "MenuItem", "Button"})
public class CommandInterpreterView extends JFrame implements CommandInterpreterViewInterface{
	
	private static final int FRAME_ROWS = 4;
	private static final int FRAME_COLUMNS = 1;
	private static final int PANEL_ROWS = 1;
	private static final int PANEL_COLUMNS = 2;
	private static final String ERRORS_PROPERTY = "Errors";
	
	private static final int BUTTON_GRID_ROWS = 2;
	private static final int BUTTON_GRID_COLUMNS = 2;
	
	public static final String MOVE_ARTHUR_LEFT = "Move Arthur left";
	public static final String MOVE_ARTHUR_RIGHT = "Move Arthur right";
	public static final String SAY = "Say";
	public static final String APPROACH = "Approach";
	public static final String PASS = "Pass";
	public static final String FAIL = "Fail";
	
	private JLabel commandLabel;
	private JTextField commandField;
	
	private JMenuItem moveArthurLeft;
	private JButton moveArthurRight;
	
	private JTextField errorField;
	private JLabel errorLabel;
	
	private JButton sayButton;
	private JButton approachButton;
	private JButton failButton;
	private JButton passButton;
	
	private CommandInterpreterInterface interpreter;
	
	public CommandInterpreterView(){
		super("CommandInterpreter UI");
		
		interpreter = SingletonsCreator.commandInterpreterFactoryMethod();
		interpreter.addPropertyChangeListener(this);
		
		setLayout(new GridLayout(FRAME_ROWS, FRAME_COLUMNS));
		
		commandField = new JTextField("");
		commandLabel = new JLabel("Command:");
		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLUMNS));
		commandPanel.add(commandLabel);
		commandPanel.add(commandField);
		
		errorField = new JTextField();
		errorField.setEditable(false);
		errorLabel = new JLabel("Errors:");
		JPanel errorPanel = new JPanel();
		errorPanel.setLayout(new GridLayout(PANEL_ROWS, PANEL_COLUMNS));
		errorPanel.add(errorLabel);
		errorPanel.add(errorField);
		
		moveArthurLeft = new JMenuItem(MOVE_ARTHUR_LEFT);
		JMenu menu = new JMenu("move");
		JMenuBar menuBar = new JMenuBar();
		menu.add(moveArthurLeft);
		menuBar.add(menu);
		
		moveArthurRight = new JButton(MOVE_ARTHUR_RIGHT);
		
		sayButton = new JButton(SAY);
		approachButton = new JButton(APPROACH);
		failButton = new JButton(FAIL);
		passButton = new JButton(PASS);
		
		JPanel buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(BUTTON_GRID_ROWS, BUTTON_GRID_COLUMNS));
		buttonGrid.add(sayButton);
		buttonGrid.add(approachButton);
		buttonGrid.add(failButton);
		buttonGrid.add(passButton);
		
		
		setJMenuBar(menuBar);
		add(commandPanel);
		add(moveArthurRight);
		add(errorPanel);
		add(buttonGrid);
	}

	@Override
	public void addControllerListener(ActionListener listener) {
		commandField.addActionListener(listener);
		moveArthurLeft.addActionListener(listener);
		moveArthurRight.addActionListener(listener);
		sayButton.addActionListener(listener);
		approachButton.addActionListener(listener);
		failButton.addActionListener(listener);
		passButton.addActionListener(listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (event.getPropertyName().equalsIgnoreCase(ERRORS_PROPERTY)){
			errorField.setText(interpreter.getErrors());
		}
	}
	
	@Override
	public JTextField getTextField(){
		return commandField;
	}
	
	@Override
	public JButton getSay(){
		return sayButton;
	}
	
	@Override
	public JButton getApproach(){
		return approachButton;
	}
	
	@Override
	public JButton getFail(){
		return failButton;
	}
	
	@Override
	public JButton getPass(){
		return passButton;
	}
	@Override
	public JButton getButton(){
		return moveArthurRight;
	}
	@Override
	public JMenuItem getMenuItem(){
		return moveArthurLeft;
	}

}
