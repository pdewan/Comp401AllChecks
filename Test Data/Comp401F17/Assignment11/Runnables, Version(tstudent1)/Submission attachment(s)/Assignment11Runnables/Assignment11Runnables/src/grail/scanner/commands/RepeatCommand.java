package grail.scanner.commands;

import util.annotations.Tags;

@Tags({"RepeatCommand"})
public class RepeatCommand implements Runnable{

	private int count;
	private Runnable command;
	
	public RepeatCommand(int count, Runnable command){
		this.count = count;
		this.command = command;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < count; ++i){
			command.run();
		}
	}

}
