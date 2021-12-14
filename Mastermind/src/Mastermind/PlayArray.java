package Mastermind;

import java.util.*;

public class PlayArray {
	
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static String getRandomColor() {
		String[] pickColorArray = ColorPrint.getColorArray();
		int indexColorArray = getRandomNumberInRange(0, 7);
		return(pickColorArray[indexColorArray]);
	}
	
	public static String[][] createArray(int numberLine) {
		String[][] playBoard = new String[numberLine][4];
		return(playBoard);
	}
	
	public static void initializeArray(String[][] setBoard) {
		for(int indexLine = 0; indexLine < setBoard.length; indexLine++) {
			for(int indexCol = 0; indexCol < setBoard[indexLine].length; indexCol++) {
				setBoard[indexLine][indexCol] = getRandomColor() + "*" + ColorPrint.getAnsiReset();
			}
		}
	}
	
	public static ColorPosition[] createSolution(int userNumberPoint, String[][] playBoard) {
		ColorPosition[] solutionCoordinate = new ColorPosition[userNumberPoint];
		int bufferRandom = 0;
		for(int indexLine = 0; indexLine < playBoard.length; indexLine++) {
			bufferRandom = getRandomNumberInRange(0,3);
			solutionCoordinate[indexLine] = new ColorPosition(bufferRandom, playBoard[indexLine][bufferRandom]);
		}
		return(solutionCoordinate);
	}
	
	public static boolean rightAnswer(ColorPosition[] solution, ColorPosition[] answer) {
		int nbOfTrue = 0;
		for(int index=0; index < solution.length; index++) {
			if((solution[0].getPositionOnCol() == answer[0].getPositionOnCol()) && (solution[0].getColorOnPoint() == answer[0].getColorOnPoint())) {
				nbOfTrue++;
			}
		}
		if(nbOfTrue == solution.length) {
			return(true);
		}
		else {
			return(false);
		}
	}
}
