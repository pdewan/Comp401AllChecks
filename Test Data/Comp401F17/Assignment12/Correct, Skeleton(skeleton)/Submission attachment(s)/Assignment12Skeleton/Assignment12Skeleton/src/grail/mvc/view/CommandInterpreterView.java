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
	
}
