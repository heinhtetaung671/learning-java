public class PhraseOMatic {
	public static void main (String[] args) {

		String[] wordlistOne = { "Functional", "Public", "Digital", "National", "Central", "Community", "Private"};

		String[] wordlistTwo = { "Health", "Information", "Computer", "Research", "Education", "Social", "Data"};

		String[] wordlistThree = { "Center", "System", "Service", "Network", "Library", "Program", "Management"};

		int wordlistOneLength = wordlistOne.length;
		int wordlistTwoLength = wordlistTwo.length;
		int wordlistThreeLength = wordlistThree.length;

		java.util.Random randomGenerator = new java.util.Random();
		int rand1 = randomGenerator.nextInt(wordlistOneLength);
		int rand2 = randomGenerator.nextInt(wordlistTwoLength);
		int rand3 = randomGenerator.nextInt(wordlistThreeLength);

		String phrase = wordlistOne[rand1] + " " + wordlistTwo[rand2] + " " + wordlistThree[rand3];

		System.out.println("What we need is : " + phrase);
	} 
}