package main;

import grail.ExtBeanStringScanner;
import grail.ScannerInterface;

import java.util.Scanner;

import bus.uigen.ObjectEditor;
/**
 * 
 * @author Dong Nie
 * dongnie@cs.unc.edu
 *
 *This is for assignment3 from comp 401
 */
public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please enter a string:");
		Scanner scan = new Scanner(System.in);
		String line="";
		ScannerInterface bss=new ExtBeanStringScanner();
		while(true)
		{
		 line = scan.nextLine();
		// if(line.equals(""))
			// continue;
		 if (line.charAt(0)=='.')
		 {
			 break;
		 }
		 //System.out.println("Processed by ordinary class");
		 //StringScanner.myScanner(line); 
		 //System.out.println("Processed by bean class");
		 //test bean scanner
		 bss.setScannedString(line);
		 //ObjectEditor.edit(filter);

		}
	}

}
