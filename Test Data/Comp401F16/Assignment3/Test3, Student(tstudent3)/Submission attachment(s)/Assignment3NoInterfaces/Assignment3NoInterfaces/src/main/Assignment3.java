package main;

import java.util.Scanner;

import grail.ScannerBean;

public class Assignment3 {
	
	public static void main(String[] args) {
		processInput();
		System.out.println("Goodbye!");
	}
	
	private static void processInput(){

		Scanner in = new Scanner(System.in);
		ScannerBean myScanner = new ScannerBean();
		
		// Read first line
		System.out.println("String?");
		String line = in.nextLine();
		
		// Process until period
		while (line.isEmpty() || line.charAt(0) != '.'){
			
			myScanner.setScannedString(line);
			
			System.out.println("String?");
			line = in.nextLine();
		}
	}
	
	
	
}
