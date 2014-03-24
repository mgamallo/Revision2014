import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class FocalAdobe {

	FocalAdobe(){
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			robot.delay(100);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
