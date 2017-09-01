package main;
import java.util.Scanner;
public class Assignment3 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);	
		StringScanner typedString=new StringScanner();
		boolean isNotPeriod=true;
		while(isNotPeriod)
		{		
			String scannedString=scanner.nextLine();
			if(scannedString.substring(0,1).equals("."))
			{
				break;
			}
			typedString.setScannedString(scannedString);
		}
		scanner.close();
	}

}
