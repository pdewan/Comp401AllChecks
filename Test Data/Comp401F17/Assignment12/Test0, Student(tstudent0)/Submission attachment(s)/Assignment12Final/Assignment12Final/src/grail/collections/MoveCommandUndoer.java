package grail.collections;

import java.util.ArrayList;
import java.util.List;

import grail.interfaces.CommandThread;
import grail.interfaces.UndoableCommandThread;
import grail.interfaces.Undoer;
import grail.scanner.commands.MoveCommand;

public class MoveCommandUndoer implements Undoer {

	private List<UndoableCommandThread> moveCommands = new ArrayList<UndoableCommandThread>();
	private int size = 0;
	private int nextCommandIndex = 0;
	
	@Override
	public void execute(UndoableCommandThread c) {
		moveCommands.add(nextCommandIndex, (MoveCommand)c);
		++nextCommandIndex;
		size = nextCommandIndex;
		c.run();
	}
	
	@Override
	public void clear() {
		moveCommands.clear();
		size = 0;
		nextCommandIndex = 0;
	}

	@Override
	public void undo() {
		
		// The command to undo lies right behind nextCommandIndex
		if (nextCommandIndex <= 0){
			return;
		
		}else{
			--nextCommandIndex;
			moveCommands.get(nextCommandIndex).undo();
		}
		
	}

	@Override
	public void redo() {
		if (nextCommandIndex >= size){
			return;
		
		}else{
			CommandThread command = moveCommands.get(nextCommandIndex);
			++nextCommandIndex;
			command.run();
		}
	}

}
