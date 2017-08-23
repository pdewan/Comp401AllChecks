package grail.mvc.view;

import javax.swing.JTextField;

import bus.uigen.widgets.VirtualTextField;
import bus.uigen.widgets.swing.SwingTextFieldFactory;
import util.annotations.Tags;

/**
 * Used for object editor
 * @author
 *
 */
@Tags({"CustomSwingTextFieldFactory"})
public class CustomSwingTextFieldFactory extends SwingTextFieldFactory {
	
	@Override
	protected JTextField createJTextField(String text) {
		JTextField toReturn = new JTextField(text);
		toReturn.setBackground(java.awt.Color.GREEN);
		toReturn.setForeground(java.awt.Color.BLUE);
		return toReturn;
	}
}
