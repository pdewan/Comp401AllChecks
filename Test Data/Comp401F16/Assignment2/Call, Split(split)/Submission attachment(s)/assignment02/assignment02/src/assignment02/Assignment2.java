package assignment02;
import java.util.Scanner;

public class Assignment2 {

  public static void main(String[] args) {
    processInput();
  }
     
    public static void processInput(){
      String myString = "a";
      Scanner scanner = new Scanner(System.in);
      Bean bean2 = new Bean();
      while(myString.charAt(0) != '.'){
      System.out.println("String?");
      myString = scanner.nextLine(); 
      bean2.setScannedString(myString);
      }
      scanner.close();
    } 

}