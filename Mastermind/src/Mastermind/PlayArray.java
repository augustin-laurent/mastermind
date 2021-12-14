package Mastermind;

import java.util.*;

public class PlayArray {
	
	private static int nbOfTrue;
	
	
	
	public static int getNbOfTrue() { return nbOfTrue; }

	public static void setNbOfTrue(int nbOfTrue) { PlayArray.nbOfTrue = nbOfTrue; }

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
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiBlack())) {
				color = ColorPrint.getAnsiBlack();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiBlue())) {
				color = ColorPrint.getAnsiBlue();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiCyan())) {
				color = ColorPrint.getAnsiCyan();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiGreen())) {
				color = ColorPrint.getAnsiGreen();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiPurple())) {
				color = ColorPrint.getAnsiPurple();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiRed())) {
				color = ColorPrint.getAnsiRed();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiWhite())) {
				color = ColorPrint.getAnsiWhite();
			}
			if(playBoard[bufferRandom][indexRow].contains(ColorPrint.getAnsiYellow())) {
				color = ColorPrint.getAnsiYellow();
			}
			solutionCoordinate[indexRow] = new ColorPosition(bufferRandom, color);
		}
		return(solutionCoordinate);
	}
	
	public static boolean rightAnswer(ColorPosition[] solution, ColorPosition[] answer) {
		nbOfTrue = 0;
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
