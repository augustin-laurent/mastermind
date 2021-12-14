package Mastermind;

// Import Scanner function to allow the input of the user
import java.util.Scanner;

public class TextUser {
	
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * @author Augustin LAURENT	
	 * @author Rémi GARCIA
	 * @return This function return a integer between 4 and 8
	 * @since v1
	 * @version v1
	 * <p>This function ask the user to enter an integer between 4 and 8, if the integer given by the user <br>
	 * is lower or higher it will loop until the user enter a proper input and print a message on why the input is invalid.</p>
	 */
	public static int askUser() {
		int pointToGuess = 0;
		System.out.println(ColorPrint.getAnsiReset() + "Please pick the number of point you want to guess (Between 4 and 8)");
		pointToGuess = scanner.nextInt();
		if(pointToGuess < 4 || pointToGuess > 8) {
			do {
				System.out.println(ColorPrint.getAnsiReset() + "Your last input was " + pointToGuess + " ,please enter a number of point to guess between 4 and 8");
				pointToGuess = scanner.nextInt();
			}while(pointToGuess < 4 || pointToGuess > 8);
		}
		else {
			System.out.println(ColorPrint.getAnsiReset() + "You picked " + pointToGuess + " ,good luck !");
		}
		return(pointToGuess);
	}
	
	public static void printArray(String[][] gameBoard) {
		for(int indexRow = 0; indexRow < gameBoard.length; indexRow++) {
			for(int indexCol = 0; indexCol < gameBoard[indexRow].length; indexCol++) {
				System.out.print(gameBoard[indexRow][indexCol]);
			}
			System.out.print('\n');
		}
	}
	
	public static String convertInputColorToANSI(String inputColor) {
		switch(inputColor) {
			case "black":
				return(ColorPrint.getAnsiBlack());
			case "red":
				return(ColorPrint.getAnsiRed());
			case "green":
				return(ColorPrint.getAnsiGreen());
			case "yellow":
				return(ColorPrint.getAnsiYellow());
			case "blue":
				return(ColorPrint.getAnsiBlue());
			case "purple":
				return(ColorPrint.getAnsiPurple());
			case "cyan":
				return(ColorPrint.getAnsiCyan());
			case "white":
				return(ColorPrint.getAnsiWhite());
			default:
				break;
		}
		return (null);
	}
	
	public static ColorPosition readUserInput() {
		ColorPosition userInput = new ColorPosition(0, "");
		int bufferInputPosition;
		String bufferInputColor = null;
		System.out.println(ColorPrint.getAnsiReset() + "Enter the position of the point (Between 1 and 4)");
		// 1 will be treated as 0 in the Algorithm, we use the normal scale to make it more comfortable for the user
		bufferInputPosition = scanner.nextInt();
		if(bufferInputPosition < 1 || bufferInputPosition > 4) {
			do {
				System.out.println(ColorPrint.getAnsiReset() + "You enter " + bufferInputPosition + " Which is not between 1 and 4, please renter a position between 1 and 4");
				bufferInputPosition = scanner.nextInt();
			}while(bufferInputPosition < 1 || bufferInputPosition > 4);
		}
		userInput.setPositionOnCol(bufferInputPosition-1);
		System.out.println(ColorPrint.getAnsiReset() + "Now enter the color of the point you previously choose (Black - Red - Green - Yellow - Blue - Purple - Cyan - White)");
		bufferInputColor = scanner.nextLine();
		//bufferInputColor.toLowerCase();
		System.out.println(bufferInputColor);
		if(bufferInputColor != "black" || bufferInputColor != "red" || bufferInputColor != "green" || bufferInputColor != "yellow" || bufferInputColor != "blue" || bufferInputColor != "purple" || bufferInputColor != "cyan" || bufferInputColor != "white") {
			do {
				System.out.println(ColorPrint.getAnsiReset() + "You did not enter one of the color or misstyped it here is the color avaible : " + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiBlack() + '\t' + "- Black" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiRed() + '\t' + "- Red" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiGreen() + '\t' + "- Green" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiYellow() + '\t' + "- Yellow" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiBlue() + '\t' + "- Blue" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiPurple() + '\t' + "- Purple" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiCyan() + '\t' + "- Cyan" + ColorPrint.getAnsiReset());
				System.out.println(ColorPrint.getAnsiWhite() + '\t' + "- White" + ColorPrint.getAnsiReset());
				bufferInputColor = scanner.nextLine();
				//bufferInputColor.toLowerCase();
				System.out.println(bufferInputColor);
			}while(bufferInputColor != "black" || bufferInputColor != "red" || bufferInputColor != "green" || bufferInputColor != "yellow" || bufferInputColor != "blue" || bufferInputColor != "purple" || bufferInputColor != "cyan" || bufferInputColor != "white");
		}
		bufferInputColor = convertInputColorToANSI(bufferInputColor);
		System.out.println(bufferInputColor);
		userInput.setColorOnPoint(bufferInputColor);	
		scanner.close();
		return(userInput);
	}
	
	public static void cheatVisualizationSolution(ColorPosition[] solution) {
		for(int index = 0; index < solution.length; index++) {
			System.out.println(solution[index]);
		}
	}
}
