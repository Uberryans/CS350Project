import java.io.IOException;
import java.util.Scanner;

// This is where our main class starts. From here, we make a Menu, and it does its job
public class Testing {
	public transient Scanner input = new Scanner(System.in);
	public static void main(String args[]) throws IOException{
		Menu menu = new Menu();
		menu.displayOpeningMenu();
	}
}
