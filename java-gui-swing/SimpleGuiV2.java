import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SimpleGuiV2 {

	public static void main (String[] args) {
		new SimpleGuiV2().go();
	}

	public void go () {

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ActionListener listener = new MyButtonListener(frame);

		JButton button = new JButton("Change Color");
		button.addActionListener(listener);

		MyPaintPannel paintPannel = new MyPaintPannel();

		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.getContentPane().add(BorderLayout.CENTER, paintPannel);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}

class MyPaintPannel extends JPanel {

	public void paintComponent (Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Random random = new Random();
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		Color startColor = new Color(red, green, blue);

		red = random.nextInt(256);
		green = random.nextInt(256);
		blue = random.nextInt(256);
		Color endColor = new Color(red, green, blue);

		GradientPaint gradient = new GradientPaint(70, 70, startColor, 150, 150, endColor);
		g2d.setPaint(gradient);
		g2d.fillOval(70, 70, 100, 100);
	}

}


class MyButtonListener implements ActionListener {

	private JFrame frame;

	public MyButtonListener (JFrame f) {
		frame = f;
	}
 
	public void actionPerformed (ActionEvent e) {
		frame.repaint();
	}

}