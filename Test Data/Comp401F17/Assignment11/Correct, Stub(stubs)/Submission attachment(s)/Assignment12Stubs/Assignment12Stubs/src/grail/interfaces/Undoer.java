package grail.interfaces;

public interface Undoer {
	public void execute(UndoableCommandThread c);
	public void undo();
	public void redo();
	public void clear();
}
