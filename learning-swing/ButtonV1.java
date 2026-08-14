import javax.swing.*;
import java.awt.*;

public class ButtonV1 {

	public static void main (String[] args) {
		new ButtonV1().go();
	}

	public void go () {
		JFrame frame = new JFrame();
		JButton button = new JButton("click me");
		frame.getContentPane().add(BorderLayout.EAST, button);
		frame.setSize(400, 400);
		frame.setVisible(true);
	}
}