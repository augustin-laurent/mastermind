package Mastermind;

import java.util.*;

public class PlayArray {
	
	private static int trueAttempt;
	
	public static int getTrueAttempt() { return trueAttempt; }

	public static void setTrueAttempt(int nbOfTrue) { PlayArray.trueAttempt = nbOfTrue; }

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
		for(int indexRow = 0; indexRow < setBoard.length; indexRow++) {
			for(int indexCol = 0; indexCol < setBoard[indexRow].length; indexCol++) {
				setBoard[indexRow][indexCol] = getRandomColor() + "*" + ColorPrint.getAnsiReset();
			}
		}
	}
	
	public static ColorPosition[] createSolution(int userNumberPoint, String[][] playBoard) {
		ColorPosition[] solutionCoordinate = new ColorPosition[userNumberPoint];
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
			solutionCoordinate[indexRow] = new ColorPosition(color);
		}
		return(solutionCoordinate);
	}
	
	public static boolean rightAnswer(ColorPosition[] solution, ColorPosition[] answer) {
		int nbOfTrue = 0;
		for(int index=0; index < solution.length; index++) {
			if((solution[0].getColorOnPoint() == answer[0].getColorOnPoint())) {
				nbOfTrue++;
			}
		}
		if(nbOfTrue == solution.length) {
			setTrueAttempt(nbOfTrue);
			return(true);
		}
		else {
			setTrueAttempt(nbOfTrue);
			return(false);
		}
	}
}
