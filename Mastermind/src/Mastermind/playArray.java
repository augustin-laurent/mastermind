package Mastermind;

import java.util.*;

public class playArray {
	
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public static String getRandomColor() {
		String[] pickColorArray = colorPrint.getColorArray();
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
				setBoard[indexLine][indexCol] = getRandomColor() + "*" + colorPrint.getAnsiReset();
			}
		}
	}
	
	public static colorPosition[] createSolution(int userNumberPoint, String[][] playBoard) {
		colorPosition[] solutionCoordinate = new colorPosition[userNumberPoint];
		int bufferRandom = 0;
		for(int indexLine = 0; indexLine < playBoard.length; indexLine++) {
			bufferRandom = getRandomNumberInRange(0,3);
			solutionCoordinate[indexLine] = new colorPosition(bufferRandom, playBoard[indexLine][bufferRandom]);
		}
		return(solutionCoordinate);
	}
}
