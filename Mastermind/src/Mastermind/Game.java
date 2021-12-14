package Mastermind;

public class Game {
	private static String[][] playBoard;
	private static ColorPosition[] solution;
	private static ColorPosition[] userAttemptSolution;
	private static int toGuess;
	private static int attempt;
	
	public static void core() {
		System.out.println("MASTERMIND");
		attempt = 0;
		toGuess = TextUser.askUser();
		playBoard = PlayArray.createArray(toGuess);
		solution = PlayArray.createSolution(toGuess, playBoard);
		do {
			for(int nbToRead = 0; nbToRead < toGuess; nbToRead++) {
				userAttemptSolution[nbToRead] = TextUser.readUserInput();
			}
			attempt++;
		}while(/* solution !=  userAttemptSolution */);
		
	}
}
