import java.awt.Color;

import javax.swing.JPanel;

/**
 * MacleoJG (jumping-game-ml) Simple jumping game which can be controlled by
 * accelerometer via arduino
 * 
 * @author Xsanori
 *
 */
public class JGField extends JPanel {

	public JGField() {
		setBackground(Color.white);
		onInit();

	}

	private void onInit() {
		createJmp();

	}

	private void createJmp() {
	}

}
