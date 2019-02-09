import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * MacleoJG (jumping-game-ml) Simple jumping game which can be controlled by
 * accelerometer via arduino
 * 
 * @author Xsanori
 *
 */
public class JGField extends JPanel {
	private final int jmpow = 60;
	private int ypos = 448;
	private int xpos;
	private int score = 0;
	private int ux = 0;
	private int kkd;
	private Timer framer;
	private boolean rnng = true;
	private boolean isjmp = false;
	private boolean flag = true;

	public JGField() {
		setBackground(Color.white);
		onInit();

	}

	private void onInit() {
		// framer = new Timer(10, this);
		framer.start();
		createJmp();

	}

	private void createJmp() {
		xpos = 885;

	}

}
