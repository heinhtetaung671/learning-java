import java.util.*;

public class GameHelper {
	private static final String ALPHABET = "ABCDEFG";
	private static final int GRID_LENGTH = 7;
	private static final int GRID_SIZE = 49;
	private static final int MAX_ATTEMPTS = 200;
	private static final int HORIZONTAL_INCREMENT = 1;
	private static final int VERTICAL_INCREMENT = GRID_LENGTH;

	private final Random random = new Random();
	private final int[] grid = new int[49];

	private int startUpCount = 0;

	public String getUserInput (String prompt) {
		System.out.println(prompt);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine().toUpperCase();
	}

	public ArrayList<String> placeStartup (int startupSize) {
		boolean success = false;
		int[] startUpCoords = new int[startupSize];
		int attempts = 0;

		startUpCount++;
		int increment = getIncrement();

		while (!success && attempts < MAX_ATTEMPTS) {
			int location = random.nextInt(GRID_SIZE);

			for (int i = 0; i < startUpCoords.length; i++) {
				startUpCoords[i] = location;
				location += increment;
			}

			if (startUpFits(startUpCoords, increment)) {
				success = coordsAvailable(startUpCoords);
			}
		}

		savePositionsToGrid(startUpCoords);
		ArrayList<String> alphaCells = convertCoordsToAlphaFormat(startUpCoords);

		System.out.println("Placed at : " + alphaCells);

		return alphaCells;
	}

	private int getIncrement () {
		if (startUpCount % 2 == 0) {
			return HORIZONTAL_INCREMENT;
		}

		return VERTICAL_INCREMENT;
	}

	private boolean startUpFits (int[] startUpCoords, int increment) {
		int lastCoord = startUpCoords[ startUpCoords.length - 1 ];

		if (increment == HORIZONTAL_INCREMENT) {
			return calculateRowFromIndex(startUpCoords[0]) == calculateRowFromIndex(lastCoord);
		}

		return lastCoord < GRID_SIZE;
		
	}

	private boolean coordsAvailable (int[] startUpCoords) {

		for (int coord : startUpCoords) {
			if (grid[coord] != 0) {
				return false;
			}
		}

		return true;
	}

	private void savePositionsToGrid (int[] startUpCoords) {
		for (int coord : startUpCoords) {
			grid[coord] = 1;
		}
	}

	private int calculateRowFromIndex (int index) {
		return index / GRID_LENGTH;
	}

	private ArrayList<String> convertCoordsToAlphaFormat (int[] startUpCoords) {
		ArrayList<String> alphaCells = new ArrayList<String>();
		for (int index : startUpCoords) {
			String alphaCoord = getAlphaCoordFromIndex(index);
			alphaCells.add(alphaCoord);
		}

		return alphaCells;
	}

	private String getAlphaCoordFromIndex (int index) {
		int row = calculateRowFromIndex(index);
		int column = index % GRID_LENGTH;
		String letter = ALPHABET.substring(column, column + 1);

		return letter + row;
	}
}