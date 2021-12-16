package Mastermind;

public class Game {
	private static String[][] playBoard;
	private static String[] solution;
	private static String[] userAttemptSolution = new String[900];
	private static int toGuess;
	private static int attempt;
	
	public static void aiCore() {
		ArtificialIntelligence.smartWay();
	}
	
	public static void core() {
		int[] trueAttempt;
		attempt = 0;
		toGuess = TextUser.askUser();
		playBoard = PlayArray.createArray(toGuess);
		PlayArray.initializeArray(playBoard);
		TextUser.printArray(playBoard);
		solution = PlayArray.createSolution(toGuess, playBoard);
		TextUser.cheatVisualizationSolution(solution);
		do {
			for(int nbToRead = 0; nbToRead < toGuess; nbToRead++) {
				userAttemptSolution[nbToRead] = TextUser.readUserInput();
			}
			trueAttempt = PlayArray.rightAnswer(solution, userAttemptSolution);
			if(trueAttempt[0] > 0 && trueAttempt[1] != 1) {
				System.out.println("You choose " + trueAttempt[0] + " color correct, but this is not the right answer, try again !");
			}
			else {
				if(trueAttempt[1] != 1) {
					System.out.println("Nothing is correct, placement nor color, try again!");
				}
			}
			attempt++;
		}while(trueAttempt[1] != 1);
		System.out.println("You managed to win the game with a total attempt of " + attempt + " , Congratulations!");
		
	}
}
