package grail.scanner;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import grail.SingletonsCreator;
import grail.animations.AnimatingCommand;
import grail.animations.SleepBasedAnimator;
import grail.animations.WaitBasedAnimator;
import grail.animations.ClapCommand;
import grail.animations.ClapLockstepCommand;
import grail.animations.LockstepAnimatingCommand;
import grail.animations.fromJavaTeaching.ABroadcastingClearanceManager;
import grail.animations.fromJavaTeaching.BroadcastingClearanceManager;
import grail.interfaces.AnimatorInterface;
import grail.interfaces.BridgeSceneInterface;
import grail.interfaces.CommandInterpreterInterface;
import grail.interfaces.CommandThread;
import grail.interfaces.ScannerBeanInterface;
import grail.interfaces.Table;
import grail.interfaces.Undoer;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import grail.interfaces.ParserInterface;

@Tags({"CommandInterpreter", "SignedMoveCommandInterpreter", "ErrorResilientCommandInterpreter","ObservableCommandInterpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Command", "Errors"})
@EditablePropertyNames({"Command"})
public class CommandInterpreter implements CommandInterpreterInterface {

}
