package Mastermind;

import java.util.*;

public class playArray {

	private static int getRandomNumberInRange() {
		Random r = new Random();
		return r.nextInt((7) + 1);
	}
	
	public static String getRandomColor() {
		String[] pickColorArray = colorPrint.getColorArray();
		int indexColorArray = getRandomNumberInRange();
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
}
