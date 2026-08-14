import javax.swing.*;
import java.awt.*;

public class SimpleGui {

	public static void main (String[] args) {
		new SimpleGui().go();
	}

	public void go () {
		JFrame frame = new JFrame();

		MyDrawPannel myPannel = new MyDrawPannel();

		frame.getContentPane().add(myPannel);

		frame.setSize(300, 300);
		frame.setVisible(true);
	}

}

class MyDrawPannel extends JPanel {

	public void paintComponent (Graphics g) {
		g.setColor(Color.orange);
		g.fillRect(20, 50, 100, 100);
	}

}