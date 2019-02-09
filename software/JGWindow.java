import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * MacleoJG (jumping-game-ml) Simple jumping game which can be controlled by
 * accelerometer via arduino
 * 
 * @author Xsanori
 *
 */
public class JGWindow extends JFrame {

	public JGWindow() {
		setTitle("MacleoJG");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(785, 552);
		setLocation(0, 0);
		add(new JGField());
		setVisible(true);

	}

	public static void main(String[] args) {
		JGWindow gw = new JGWindow();

	}

}
