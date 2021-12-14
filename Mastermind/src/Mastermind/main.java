package Mastermind;

public class main {

	public static void main(String[] args) {
		//int choice = 0
		//choice = textUser.askUser();
		//playArray.getRandomColor()
		String[][] playBoard = PlayArray.createArray(5);
		PlayArray.initializeArray(playBoard);
		TextUser.printArray(playBoard);
		ColorPosition[] a;
		a = PlayArray.createSolution(5, playBoard);
		
		System.out.println('\n' + "---------");
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);
		
		System.out.println('\n' + "---------");
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiBlack()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiBlue()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiCyan()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiGreen()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiPurple()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiRed()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiWhite()));
		System.out.println(playBoard[0][0].contains(ColorPrint.getAnsiYellow()));
		
	}

}
