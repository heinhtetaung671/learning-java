import java.util.ArrayList;

public class Startup {
	private String name;
	private ArrayList<String> locationCells;

	public String checkYourself (String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);

		if (index >= 0) {
			locationCells.remove(index);

			if (locationCells.isEmpty()) {
				result = "kill";
				System.out.println("Ouch! You sunk " + name + " : ( ");
			} else {
				result = "hit";
			}
		}

		return result;

	}

	public void setName (String n) {
		name = n;
	}

	public void setLocationCells (ArrayList locCells) {
		locationCells = locCells;
	}
}