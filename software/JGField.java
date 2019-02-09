import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * MacleoJG (jumping-game-ml) Simple jumping game which can be controlled by
 * accelerometer via arduino
 * 
 * @author Xsanori
 *
 */
public class JGField extends JPanel implements ActionListener {
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
		addKeyListener(new keyTime());
		setFocusable(true);

	}

	private void onInit() {
		framer = new Timer(10, this);
		framer.start();
		createJmp();

	}

	private void createJmp() {
		xpos = 885;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (rnng) {
			g.drawOval(352, ypos, 64, 64);
			g.drawRect(xpos - 100, 412, 100, 100);
			g.drawString(Integer.toString(score), 16, 16);
		} else {
			g.drawString("YOU LOSE. SCORE: " + Integer.toString(score), 16, 16);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (rnng) {
            if (isjmp) {
                ypos -= ux * 0.1;
                ux -= 1;
            }
            if (ypos == 448) {
                isjmp = false;
            }
            if (xpos != 0) {
                xpos -= 5;
            } else {
                createJmp();
            }
            if (xpos >= 352 && xpos <= 516) {
                if (ypos >= 348) {
                    rnng = false;
                } else if (flag) {
                    score++;
                    flag = false;
                }
            } else {
                flag = true;
            }
        }
        repaint();
    }

	class keyTime extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			super.keyPressed(e);
			kkd = e.getKeyCode();
			if (kkd == KeyEvent.VK_SPACE && ! isjmp) {
				isjmp = true;
				ux = jmpow;
			}
		}
	}

}
