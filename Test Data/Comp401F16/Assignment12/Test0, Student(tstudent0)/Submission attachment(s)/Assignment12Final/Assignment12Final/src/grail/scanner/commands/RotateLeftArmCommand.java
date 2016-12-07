package grail.scanner.commands;

import grail.interfaces.AvatarInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"RotateLeftArmCommand"})
public class RotateLeftArmCommand implements CommandThread {

	private int rotateDegrees;
	private AvatarInterface avatar;

	public RotateLeftArmCommand(AvatarInterface avatar, int rotateClockwiseDegrees){
		this.avatar = avatar;
		this.rotateDegrees = rotateClockwiseDegrees;
	}

	@Override
	public void run() {
		avatar.getArms().getLeftLine().rotateByClockwiseDegrees(rotateDegrees);
	}
}
