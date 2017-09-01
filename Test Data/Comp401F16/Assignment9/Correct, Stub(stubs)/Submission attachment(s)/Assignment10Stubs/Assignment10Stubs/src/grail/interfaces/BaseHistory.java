package grail.interfaces;

public interface BaseHistory {
	public void addElement(Token element);
	public Token elementAt (int index); 
	public int size();
}
