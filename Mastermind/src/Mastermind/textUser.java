package Mastermind;

// Import Scanner function to allow the input of the user
import java.util.Scanner;

public class textUser {
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
}
