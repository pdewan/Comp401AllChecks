package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import grail.shapes.AllFiveGuys;
import grail.shapes.AllFiveGuysInterface;

public class Assignment5 {
  
  public static void main(String[] args) {
    AllFiveGuysInterface test = new AllFiveGuys();
    
    OEFrame editor = ObjectEditor.edit(test);
    editor.setSize(1000,400);
    
    //demonstration of moving images
  for(int i=0;i<110;i++){
 sleep(50);
 if(i<50){
   test.getArthur().moveBody(null, 10,0);
 }
  else{
    test.getArthur().moveBody(null, 10, 0);
  }
  
  editor.refresh();
}
    
    
    
  }
  public static void sleep(long interval) {
    try {
        Thread.sleep(interval);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
  
  
  
}

