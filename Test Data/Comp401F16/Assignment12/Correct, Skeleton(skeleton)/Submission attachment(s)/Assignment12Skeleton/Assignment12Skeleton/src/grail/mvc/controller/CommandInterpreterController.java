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
	
}
