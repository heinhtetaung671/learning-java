public class SimpleStartupTestDrive {
	public static void main (String[] args) {
		String testResult = "failled";

		int[] locations = { 2, 3, 4};

		SimpleStartup dot = new SimpleStartup();
		dot.setLocationCells(locations);

		int userGuss = 2;
		String result = dot.checkYourself(userGuss);

		if (result.equals("hit")) {
			testResult = "passed";
		}

		System.out.println(testResult);
	}
}

class SimpleStartup {
	private int[] locationCells;
	private int hits;

	public String checkYourself (int userGuss) {
		String result = "miss";

		for (int cell : locationCells) {

			if (userGuss == cell) {
				result = "hit";
				hits++;
				break;
			}
		}

		if (hits == locationCells.length) {
			result = "kill";
		}

		System.out.println(result);
		return result;
	}

	public void setLocationCells (int[] locCells) {
		locationCells = locCells;
	}

}