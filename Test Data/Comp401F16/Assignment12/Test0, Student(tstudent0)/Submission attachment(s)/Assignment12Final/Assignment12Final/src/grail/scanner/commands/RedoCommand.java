package grail.scanner.commands;

import grail.collections.MoveCommandUndoer;
import grail.interfaces.CommandThread;
import grail.interfaces.UndoableCommandThread;
import grail.interfaces.Undoer;
import util.annotations.Tags;

@Tags({"RedoCommand"})
public class RedoCommand implements CommandThread {

	Undoer undoer;
	
	public RedoCommand(Undoer undoer2){
		this.undoer = undoer2;
	}
	
	@Override
	public void run() {
		undoer.redo();
	}

}
