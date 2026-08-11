import java.util.ArrayList;

public class StartupBust {
	private GameHelper helper = new GameHelper();
	private ArrayList<Startup> startups = new ArrayList<Startup>();
	private int numOfGuss = 0;

	public static void main(String[] args) {
		StartupBust game = new StartupBust();
		game.setUpGame();
		game.startPlaying();
	}

	private void setUpGame () {
		Startup one = new Startup();
		one.setName("matrix");
		Startup two = new Startup();
		two.setName("aftermath");
		Startup three = new Startup();
		three.setName("nirvana");

		startups.add(one);
		startups.add(two);
		startups.add(three);

		System.out.println("Your goal is to sink three startup.");
		System.out.println("matrix, aftermath, nirvana");
		System.out.println("Try to sink them all in fewest number of guess possible!");

		for (Startup startup : startups) {
			ArrayList<String> newLocations = helper.placeStartup(3);
			startup.setLocationCells(newLocations);
		}
	}

	private void startPlaying () {
		while (!startups.isEmpty()) {
			String userInput = helper.getUserInput("Enter a guess : ");
			checkUserGuess(userInput);
		}

		finishGame();
	}

	private void checkUserGuess (String userInput) {
		numOfGuss++;
		String result = "miss";

		for (Startup startup : startups) {
			result = startup.checkYourself(userInput);

			if (result.equals("hit")) {
				break;
			}

			if (result.equals("kill")) {
				startups.remove(startup);
				break;
			}
		}

		System.out.println(result);
	}

	private void finishGame() {
		System.out.println("All Startups are dead! Your stock is now worthless");

		if (numOfGuss < 20) {
			System.out.println("It took you " + numOfGuss + " gusses.");
		} else {
			System.out.println("Took you long enough. " + numOfGuss + " gusses.");
		}

	}


}