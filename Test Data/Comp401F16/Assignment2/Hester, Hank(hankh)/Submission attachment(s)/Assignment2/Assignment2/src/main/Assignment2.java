package main;

import java.util.Scanner;

public class Assignment2 {

	public static void main(String[] args) {
		processInput();
	}
	
	public static void processInput() {
		Bean bean = new Bean();
		System.out.print("Input string: ");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		if (line.charAt(0) == '.') {
			System.out.println("Bye!");
			scanner.close();
			return;
		} else {
			bean.setScannedString(line);
			System.out.println();
			processInput();
		}
	}
}
