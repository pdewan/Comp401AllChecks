package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.AHeadImage;
import grail.AStringShape;
import grail.Angle;
import mp.Avatar;
import mp.BridgeScene;
import util.misc.ThreadSupport;

public class Assignment5 {
	public static void main(String[] args){

		BridgeScene bridgescene = new BridgeScene();
		OEFrame editor = ObjectEditor.edit(bridgescene);
		editor.refresh();
		ThreadSupport.sleep(300);
		bridgescene.getGuard().move(100,100);
		editor.refresh();
		ThreadSupport.sleep(300);
		bridgescene.getGuard().getArms().getLeftLine().rotate(4);
		editor.refresh();
		ThreadSupport.sleep(300);
		bridgescene.getArthur().scale(2);
		editor.refresh();
		ThreadSupport.sleep(300);
		bridgescene.getRobin().scale(.5);
		editor.refresh();
		ThreadSupport.sleep(300);
		bridgescene.getGalahad().move(0, 100);
		editor.refresh();
	}
}