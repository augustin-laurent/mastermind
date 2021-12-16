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
		TextUser.cheatVisualizationSolution(solution);
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
		System.out.println("-------------------------------------");
		TextUser.cheatVisualizationSolution(aiAttempt);
		
		for(int index = 0; index < aiAttempt.length; index++) {
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
		System.out.println("gros fiak" + attemptNumber);
	}
}