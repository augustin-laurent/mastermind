package Mastermind;

import java.util.Arrays;

public class ArtificialIntelligence {
	private static String[] solution;
	private static String[][] playBoard;
	private static String[] aiAttempt = new String[4];
	private static String[] colorArray = ColorPrint.getColorArray();
	private static int returnValue;
	private static int colorArrayIndex;
	private static int attemptNumber;


	public static void smartWay() {

		int presenceOfColor = 0;
		colorArrayIndex = 0;
		attemptNumber = 0;
		int secondIndex;
		String bucket;
		playBoard = PlayArray.createArray(4);
		PlayArray.initializeArray(playBoard);
		solution = PlayArray.createSolution(4, playBoard);
		do {
			for(int index = presenceOfColor; index < aiAttempt.length; index++) {
				aiAttempt[index] = colorArray[colorArrayIndex];
			}
			returnValue = PlayArray.presenceOfColor(solution, colorArray[colorArrayIndex]);
			if(returnValue > 0) {
				for(int index = 0; index < returnValue; index++) {
					presenceOfColor++;
				}
			}
			colorArrayIndex++;
			attemptNumber++;
		}while(presenceOfColor != aiAttempt.length && colorArrayIndex < colorArray.length && !Arrays.equals(solution, aiAttempt));
		for(int index = aiAttempt.length; index > aiAttempt.length; index--) {
			if(aiAttempt[index] != solution[index]) {
				secondIndex = 1;
				while(aiAttempt[index] != solution[index]) {
					if(aiAttempt[index + secondIndex].equals(aiAttempt[index])) {
						secondIndex++;
					}
					//System.out.println(secondIndex);
					bucket = aiAttempt[index];
					aiAttempt[index] = aiAttempt[index+secondIndex];
					aiAttempt[index+secondIndex] = bucket;
					attemptNumber++;
				}
			}	
		}
		TextUser.cheatVisualizationSolution(aiAttempt);
		System.out.println("The computer finished the game in " + attemptNumber + " attempt");
	}


	/**
	 * @author Augustin LAURENT	
	 * @author Rémi GARCIA
	 * @since v1
	 * @version v1
	 * <p>L'ordinateur va tenter de trouver la solution sans réfléchir en donnant des 
	 * couleurs de pions aléatoire à chaque coup </p>
	 */
	public static void randomWay() {
		
		System.out.println("\n----------Random Way---------");

		// on définit l'intervalle pour le chiffre aléatoire
		int max = 7; //borne maximum
		int min = 0; //borne minimum
		int intervalle = max - min + 1;
		int nbAleatoire = 0; //r


		colorArrayIndex = 0;
		attemptNumber = 0;
		playBoard = PlayArray.createArray(4);
		PlayArray.initializeArray(playBoard);
		solution = PlayArray.createSolution(4, playBoard);
		
		do {
			
			for(int index = 0; index < aiAttempt.length; index++) {
				nbAleatoire = (int)(Math.random() * intervalle) + min;
				//nombre aléatoire qui sera l'indice pour le tableau des couleurs
				aiAttempt[index] = colorArray[nbAleatoire];
			}
	
			attemptNumber++;
		}while(!Arrays.equals(solution, aiAttempt));
		TextUser.cheatVisualizationSolution(aiAttempt);
		System.out.println("The computer finished the game in " + attemptNumber + " attempt");
	}
}