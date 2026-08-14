import java.io.*;

public class WriteAFile {
	public static void main (String[] args) {
		try {
			FileWriter writer = new FileWriter("test_file_v1.txt");
			writer.write("Hello, I am learning java file writer.");

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}