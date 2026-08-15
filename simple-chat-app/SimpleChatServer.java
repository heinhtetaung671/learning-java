import java.net.InetSocketAddress;
import java.io.*;
import java.nio.channels.*;
import java.util.*;
import java.util.concurrent.*;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SimpleChatServer {

	public static void main (String[] args) {
		new SimpleChatServer().go();
	}

	public void go () {
		ExecutorService threadPool = Executors.newCachedThreadPool();
		try {
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(5000));

			while (serverSocketChannel.isOpen()) {
				SocketChannel clientChannel = serverSocketChannel.accept();

				threadPool.submit(new ClientHandler(clientChannel));
				System.out.println("got a connection.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public class ClientHandler implements Runnable {
		private BufferedReader reader;
		private SocketChannel socket;

		public ClientHandler (SocketChannel socket) {
			this.socket = socket;
			this.reader = new BufferedReader(Channels.newReader(socket, UTF_8));
		}

		public void run () {
			String message;
			try {
					while ( (message = reader.readLine()) != null) {
						System.out.println(message);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}