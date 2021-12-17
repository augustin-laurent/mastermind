package Mastermind;

import java.util.*;

public class PlayArray {
	
	/**
	 * @author Augustin LAURENT	
	 * @author Rémi GARCIA
	 * @return This function return an integer between the minimal and maximal value given in parameter
	 * @since v1
	 * @version v1
	 * <p>The function take as a parameter two number a minimal value and a maximal value<br>
	 * the returned value is a random number between the min and the max </p>
	 */
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	/**
	 * @author Augustin LAURENT	
	 * @author Rémi GARCIA
	 * @return This function return a random ANSI Code Color
	 * @since v1
	 * @version v1
	 * <p>This function get a random number between 0 and 7 and take the corresponding ANSI Code Color<br>
	 * in an array</p>
	 */
	public static String getRandomColor() {
		String[] pickColorArray = ColorPrint.getColorArray();
		int indexColorArray = getRandomNumberInRange(0, 7);
		return(pickColorArray[indexColorArray]);
	}
	
	/**
	 * @author Augustin LAURENT	
	 * @author Rémi GARCIA
	 * @return This function return a String containing an ANSI code color
	 * @since v1
	 * @version v1
	 * <p>The function read an integer input and between 1 and 8, each number in this interval correspond to a color</p>
	 */
	public static String[][] createArray(int numberLine) {
		String[][] playBoard = new String[numberLine][4];
		return(playBoard);
	}
	
	public static void initializeArray(String[][] setBoard) {
		for(int indexRow = 0; indexRow < setBoard.length; indexRow++) {
			for(int indexCol = 0; indexCol < setBoard[indexRow].length; indexCol++) {
				setBoard[indexRow][indexCol] = getRandomColor() + "*" + ColorPrint.getAnsiReset();
			}
		}
	}
	
	public static String[] createSolution(int userNumberPoint, String[][] playBoard) {
		String[] solutionCoordinate = new String[userNumberPoint];
		int bufferRandom = 0;
		String color = null;
		for(int indexRow = 0; indexRow < playBoard.length; indexRow++) {
			bufferRandom = getRandomNumberInRange(0,3);
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiBlack())) {
				color = ColorPrint.getAnsiBlack();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiBlue())) {
				color = ColorPrint.getAnsiBlue();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiCyan())) {
				color = ColorPrint.getAnsiCyan();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiGreen())) {
				color = ColorPrint.getAnsiGreen();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiPurple())) {
				color = ColorPrint.getAnsiPurple();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiRed())) {
				color = ColorPrint.getAnsiRed();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiWhite())) {
				color = ColorPrint.getAnsiWhite();
			}
			if(playBoard[indexRow][bufferRandom].contains(ColorPrint.getAnsiYellow())) {
				color = ColorPrint.getAnsiYellow();
			}
			solutionCoordinate[indexRow] = color;
		}
		return(solutionCoordinate);
	}

	public static int presenceOfColor(String[] solution, String color) {
		int timeAppear = 0;
		for(int index=0; index < solution.length; index++) {
			if(solution[index] == color) {
				timeAppear++;
			}
		}
		return(timeAppear);
	}
	
	public static int[] rightAnswer(String[] solution, String[] answer) {
		int[] toBeReturned = new int[2];
		int nbOfTrue = 0;
		for(int index=0; index < solution.length; index++) {
			if((solution[index] == answer[index])) {
				nbOfTrue++;
			}
		}
		if(nbOfTrue == solution.length) {
			toBeReturned[0] = nbOfTrue;
			toBeReturned[1] = 1;
			return(toBeReturned);
		}
		else {
			toBeReturned[0] = nbOfTrue;
			toBeReturned[1] = 0;
			return(toBeReturned);
		}
	}
}
