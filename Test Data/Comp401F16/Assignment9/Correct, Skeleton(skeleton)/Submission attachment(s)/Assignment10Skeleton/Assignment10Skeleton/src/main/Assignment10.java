package main;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.SingletonsCreator;
import grail.collections.MyTable;
import grail.graphics.BridgeScene;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.mvc.BridgeSceneControllerInterface;
import grail.interfaces.mvc.CommandInterpreterControllerInterface;
import grail.interfaces.mvc.CommandInterpreterViewInterface;
import grail.interfaces.mvc.DelegatingBridgeSceneViewInterface;
import grail.interfaces.mvc.PaintingViewMaster;
import grail.mvc.controller.CommandInterpreterController;
import grail.mvc.view.CommandInterpreterView;
import grail.mvc.view.ConsoleSceneView;
import grail.mvc.view.DelegatingBridgeSceneView;
import grail.scanner.CommandInterpreter;
import grail.scanner.ScannerBean;
import util.annotations.Tags;
import util.misc.ThreadSupport;

@Tags({"ProgressBarCreator"})
public class Assignment10 {

		public static void main(String[] args) throws InterruptedException {
		
		}
}//end class
