import java.io.*;

public class Square implements Serializable {

	private int width;
	private int height;

	public Square (int width, int height) {
		this.width = width;
		this.height = height;
	}

	public static void main (String[] args) {
		Square square = new Square(40, 40);

		try {
			FileOutputStream fos = new FileOutputStream("square.ser");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(square);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}