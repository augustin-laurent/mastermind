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
		String[][] playBoard = new String[4][numberLine];
		return(playBoard);
	}
	
	public static String[][] initializeArray(String[][] setBoard) {
		for(int indexLine = 0; indexLine < setBoard.length; indexLine++) {
			for(int indexCol = 0; indexCol < setBoard[indexLine].length; indexCol++) {
				setBoard[indexLine][indexCol] = getRandomColor() + "◙";
			}
		}
		return(setBoard);
	}
	
	public static Coordinate[] createSolution(int userNumberPoint) {
		Coordinate[] solutionCoordinate = new Coordinate[userNumberPoint];
		int bufferIndex = 0;
		int bufferRandom = 0;
		for(int indexLine = 0; indexLine < userNumberPoint; indexLine++) {
			bufferRandom = getRandomNumberInRange(0,3);
			System.out.print(bufferIndex);
			solutionCoordinate[bufferIndex] = new Coordinate(indexLine, bufferRandom);
			bufferIndex++;
		}
		return(solutionCoordinate);
	}
}
