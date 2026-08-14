import java.io.*;

public class GameCharacterIOTestDrive {

	public static void main (String[] args) {
		GameCharacter cOne = new GameCharacter(1, "Pawn", new String[] {"Basic Weapons", "Run"});
		GameCharacter cTwo = new GameCharacter(3, "Knight", new String[] {"Sword", "Horse"});
		GameCharacter cThree = new GameCharacter(100, "King", new String[] {"Power", "Money"});

		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("game_characters.ser"));
			os.writeObject(cOne);
			os.writeObject(cTwo);
			os.writeObject(cThree);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("game_characters.ser"));
			GameCharacter cOneRestore = (GameCharacter) is.readObject();
			GameCharacter cTwoRestore = (GameCharacter) is.readObject();
			GameCharacter cThreeRestore = (GameCharacter) is.readObject();

			System.out.println("Character one restore's type : " + cOneRestore.getType());
			System.out.println("Character two restore's type : " + cTwoRestore.getType());
			System.out.println("Character three restore's type : " + cThreeRestore.getType());
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}