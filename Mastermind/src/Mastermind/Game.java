package Mastermind;

public class Game {
	private static String[][] playBoard;
	private static ColorPosition[] solution;
	private static ColorPosition[] userAttemptSolution = new ColorPosition[900];
	private static int toGuess;
	private static int attempt;
	
	public static void core() {
		System.out.println("MASTERMIND");
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
			if(PlayArray.getTrueAttempt() > 0) {
				System.out.println("You placed " + PlayArray.getTrueAttempt() + " point and choose color in the right way, but this is not the right answer, try again !");
			}
			else {
				System.out.println("Nothing is correct, placement nor color, try again!");
			}
			attempt++;
		}while(PlayArray.rightAnswer(solution, userAttemptSolution) != true);
		System.out.println("You managed to win the game with a total attempt of " + attempt + " , Congratulations!");
		
	}
}
