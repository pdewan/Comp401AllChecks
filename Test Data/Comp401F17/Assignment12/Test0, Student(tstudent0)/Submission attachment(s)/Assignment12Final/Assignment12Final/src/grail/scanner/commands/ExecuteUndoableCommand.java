package grail.scanner.commands;

import grail.collections.MoveCommandUndoer;
import grail.interfaces.CommandThread;
import grail.interfaces.UndoableCommandThread;
import grail.interfaces.Undoer;

public class ExecuteUndoableCommand implements CommandThread {

	Undoer undoer;
	UndoableCommandThread moveCommand;
	
	public ExecuteUndoableCommand(Undoer undoer2, UndoableCommandThread moveCommand2){
		this.undoer = undoer2;
		this.moveCommand = moveCommand2;
	}
	
	@Override
	public void run() {
		undoer.execute(moveCommand);
	}

}
