package Mastermind;

// Import Scanner function to allow the input of the user
import java.util.Scanner;

public class TextUser {
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
		Scanner scanner = new Scanner(System.in);
		int pointToGuess = 0;
		System.out.println("Please pick the number of point you want to guess (Between 4 and 8)");
		pointToGuess = scanner.nextInt();
		if(pointToGuess < 4 || pointToGuess > 8) {
			do {
				System.out.println("Your last input was " + pointToGuess + " ,please enter a number of point to guess between 4 and 8");
				pointToGuess = scanner.nextInt();
			}while(pointToGuess < 4 || pointToGuess > 8);
		}
		else {
			System.out.println("You picked " + pointToGuess + " ,good luck !");
		}
		scanner.close();
		return(pointToGuess);
	}
	
	public static void printArray(String[][] gameBoard) {
		for(int indexLine = 0; indexLine < gameBoard.length; indexLine++) {
			System.out.print('\n');
			for(int indexCol = 0; indexCol < gameBoard[indexLine].length; indexCol++) {
				System.out.print(gameBoard[indexLine][indexCol]);
			}
		}
	}
	
	public static ColorPosition readUserInput() {
		ColorPosition userInput = null;
		int bufferInputPosition = 0;
		String bufferInputColor = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the position of the point (Between 1 and 4)");
		// 1 will be treated as 0 in the Algorithm, we use the normal scale to make it more comfortable for the user
		bufferInputPosition = scanner.nextInt();
		if(bufferInputPosition < 1 || bufferInputPosition > 4) {
			do {
				System.out.println("You enter " + bufferInputPosition + " Which is not between 1 and 4, please renter a position between 1 and 4");
				bufferInputPosition = scanner.nextInt();
			}while(bufferInputPosition < 1 || bufferInputPosition > 4);
		}
		userInput.setPositionOnCol(bufferInputPosition);
		System.out.println("Now enter the color of the point you previously choose (Black - Red - Green - Yellow - Blue - Purple - Cyan - White)");
		bufferInputColor = scanner.next();
		bufferInputColor.toLowerCase();
		if(bufferInputColor != "black" || bufferInputColor != "red" || bufferInputColor != "green" || bufferInputColor != "yellow" || bufferInputColor != "blue" || bufferInputColor != "purple" || bufferInputColor != "cyan" || bufferInputColor != "white") {
			do {
				System.out.println("You did not enter one of the color or misstyped it here is the color avaible : ");
				System.out.println('\t' + "- Black");
				System.out.println('\t' + "- Red");
				System.out.println('\t' + "- Green");
				System.out.println('\t' + "- Yellow");
				System.out.println('\t' + "- Blue");
				System.out.println('\t' + "- Purple");
				System.out.println('\t' + "- Cyan");
				System.out.println('\t' + "- White");
				bufferInputColor = scanner.next();
				bufferInputColor.toLowerCase();
			}while(bufferInputColor != "black" || bufferInputColor != "red" || bufferInputColor != "green" || bufferInputColor != "yellow" || bufferInputColor != "blue" || bufferInputColor != "purple" || bufferInputColor != "cyan" || bufferInputColor != "white");
		}
		userInput.setColorOnPoint(bufferInputColor);
		scanner.close();
		return(userInput);
	}
}
