package grail.interfaces;

public interface CompositeCommandThread extends CommandThread{
	public void add(Runnable r);
}
