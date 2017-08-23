package grail.scanner.commands;

import grail.interfaces.AvatarInterface;
import util.annotations.Tags;

@Tags({"MoveCommand"})
public class MoveCommand implements Runnable{

	private AvatarInterface avatar;
	private int xOffset;
	private int yOffset;
	
	public MoveCommand(AvatarInterface avatar, int xOffset, int yOffset){
		this.avatar = avatar;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
	@Override
	public void run() {
		avatar.move(xOffset, yOffset);
	}

}
