package Mastermind;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		int choice = 1;
		Scanner scanner = new Scanner(System.in);
		double startTimer;
		double endTimer;
		System.out.println("MASTERMIND");
		System.out.println("Would you like to play or let the computer do the hard work ?");
		System.out.println('\t' + ColorPrint.getAnsiPurple() +"1 - Computer" + ColorPrint.getAnsiReset());
		System.out.println('\t' + ColorPrint.getAnsiYellow() +"2 - Yourself" + ColorPrint.getAnsiReset());
		choice = scanner.nextInt();
		if(choice < 1 || choice > 2) {
			do {
				System.out.println("Please enter 1 or 2 and not something else");
				System.out.println('\t' + ColorPrint.getAnsiPurple() +"1 - Computer" + ColorPrint.getAnsiReset());
				System.out.println('\t' + ColorPrint.getAnsiYellow() +"2 - Yourself" + ColorPrint.getAnsiReset());
				choice = scanner.nextInt();
			}while(choice < 1 || choice  > 2);
		}
		
		if(choice == 1) {
			startTimer = System.nanoTime();
			Game.aiCore();
			endTimer = System.nanoTime();
			System.out.println("The computer passed exactly (in nanoSecond) : " + (endTimer - startTimer) + "nS to solve the solution on a 4*4 grid");
		}
		else if(choice == 2) {
			Game.core();
		}
			
	}

}
