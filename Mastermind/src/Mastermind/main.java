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

	}

}
