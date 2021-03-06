package assignment02;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames; 
import util.annotations.Tags;

@Tags({"ScannerBean"}) 
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"ScannedString"})
@EditablePropertyNames({"ScannedString"})


public class Bean {

  private String scannedString;
  
  public void setScannedString(String newString){
    scannedString = newString;
    scanString(scannedString);
  }
  
  public String getScannedString(String newString){
    return scannedString;
  }
  
  public static int indexOf(String myString, char ch, int fromIndex){
    int index = 0;
    while(index < myString.length()){
     if(index >= fromIndex){
      if(myString.charAt(index) == ch){
        return index;
      }
     }
      index++;
    }
    return -1;
   }
  
  public static void scanString(String myString){
      myString.split(" ");
    int index = 0;
    int i = 0;
    int startToken = 0;
    int endToken = 0;
    int space = indexOf(myString, ' ', 0);
    String token;
   

        while(space > 0){
          if(Character.isLetter(myString.charAt(startToken))){
            endToken= space;
            token = myString.substring(startToken,endToken);
            System.out.println("word: " + token);
            startToken = endToken+1;
            space = indexOf(myString, ' ', space+1);
          }else if(myString.charAt(startToken) == '"'){
              endToken= space;
              token = myString.substring(startToken+1,endToken-1);
             if(myString.charAt(endToken-1) != '"'){
                System.out.println(">>>ERROR! MISSING QUOTATION BELOW<<<");
                token = myString.substring(startToken+1,endToken);
               }
              System.out.println("quoted string: " + token);
              startToken = endToken+1;
              space = indexOf(myString, ' ', space+1);
              }else if(myString.charAt(startToken) >=0 || myString.charAt(startToken)<=9){
                endToken= space;
                token = myString.substring(startToken,endToken);
                System.out.println("number: " + token);
                startToken = endToken+1;
                space = indexOf(myString, ' ', space+1);
          } else if(myString.charAt(startToken) == '+' || myString.charAt(startToken) == '-'){
                endToken= space;
                token = myString.substring(startToken,endToken);
                System.out.println("sign: " + token);
                startToken = endToken+1;
                space = indexOf(myString, ' ', space+1);
              }
          
        }
        if(space < 0){
          if(Character.isLetter(myString.charAt(startToken))){
            endToken= myString.length();
            token = myString.substring(startToken,endToken);
            System.out.println("word: " + token);
          }else if(myString.charAt(startToken) == '.'){
            System.out.println("GoodBye!");
          }else if(myString.charAt(startToken) == '"'){
            endToken= myString.length();
            token = myString.substring(startToken+1,endToken-1);
             if(myString.charAt(endToken-1) != '"'){
              System.out.println(">>>ERROR! QUOTATION WAS MISSING BELOW<<<");
              token = myString.substring(startToken+1,endToken);
            }if(myString.charAt(startToken) == '+' || myString.charAt(startToken) == '-'){
              endToken= myString.length();
              token = myString.substring(startToken,endToken);
              System.out.println("sign: " + token);
            }
             
             
            System.out.println("quoted string: " + token);
              }else if(myString.charAt(startToken) >=0 || myString.charAt(startToken)<=9){
            endToken= myString.length();
            token = myString.substring(startToken,endToken);
            System.out.println("number: " + token);
          }
        }
    
  
  }
}