package grail.interfaces;

public interface CompositeCommandThread extends Runnable{
	public void add(Runnable r);
}
