import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatClientA {

	private PrintWriter writer;
	private JTextField textField;

	public void go () {

		setUpNetworking();

		textField = new JTextField(20);

		JButton button = new JButton("Send");
		button.addActionListener(e -> sendMessage());

		JPanel mainPanel = new JPanel();
		mainPanel.add(textField);
		mainPanel.add(button);

		JFrame frame = new JFrame("Simple Chat Client.");
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
		frame.setSize(400, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	public void setUpNetworking () {

		try {
			InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1", 5000);

			SocketChannel channel = SocketChannel.open(serverAddress);
			writer = new PrintWriter(Channels.newWriter(channel, UTF_8));
			System.out.println("Networking established.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void sendMessage () {
		writer.println(textField.getText());
		writer.flush();
		textField.setText("");
		textField.requestFocus();
	}


	public static void main (String[] args) {
		new SimpleChatClientA().go();
	}
}