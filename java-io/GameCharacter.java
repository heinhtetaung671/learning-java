import java.io.*;

public class GameCharacter implements Serializable {

	private int power;
	private String type;
	private String[] weapons;

	public GameCharacter (int power, String type, String[] weapons) {
		this.power = power;
		this.type = type;
		this.weapons = weapons;
	}

	public int getPower () {
		return power;
	}

	public String getType () {
		return type;
	}

	public String[] getWeapons () {
		return weapons;
	}

}