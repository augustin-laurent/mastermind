package Mastermind;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int choice = 0;
		//choice = textUser.askUser();
		//playArray.getRandomColor();
		Coordinate[] a;
		a = playArray.createSolution(5);
		System.out.println(a[0]);
		System.out.println(a[1]);
		System.out.println(a[2]);
		System.out.println(a[3]);
		System.out.println(a[4]);

	}

}
