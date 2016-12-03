package grail.interfaces;

import util.annotations.Tags;

@Tags("CommandList")
public interface CommandListInterface extends Runnable{
	public void add(Runnable r);
}
