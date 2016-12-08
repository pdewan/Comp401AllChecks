package grail.scanner.commands;

import grail.collections.MoveCommandUndoer;
import grail.interfaces.CommandThread;
import grail.interfaces.UndoableCommandThread;
import grail.interfaces.Undoer;
import util.annotations.Tags;
@Tags({"UndoCommand"})
public class UndoCommand implements CommandThread {

	Undoer undoer;
	
	public UndoCommand(Undoer undoer2){
		this.undoer = undoer2;
	}
	
	@Override
	public void run() {
		undoer.undo();
	}

}
