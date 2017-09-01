package grail.scanner.commands;

import grail.interfaces.AvatarInterface;
import grail.interfaces.CommandThread;
import util.annotations.Tags;

@Tags({"RotateRightArmCommand"})
public class RotateRightArmCommand implements CommandThread {

	private int rotateDegrees;
	private AvatarInterface avatar;

	public RotateRightArmCommand(AvatarInterface avatar, int rotateClockwiseDegrees){
		this.avatar = avatar;
		this.rotateDegrees = rotateClockwiseDegrees;
	}

	@Override
	public void run() {
		avatar.getArms().getRightLine().rotateByClockwiseDegrees(rotateDegrees);
	}
}
