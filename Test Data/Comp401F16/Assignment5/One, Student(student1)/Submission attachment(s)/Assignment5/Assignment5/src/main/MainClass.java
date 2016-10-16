package main;

import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.misc.ThreadSupport;

public class MainClass {
  public static void main(String[] args) {
    // Bean bean = new Bean();
    // Scanner scan = new Scanner(System.in);
    // String scanString = scan.nextLine();
    animateScanner();

    // while (scanString != null) {
    // bean.setScannedString(scanString);
    // scanString = scan.nextLine();
    // }
  }

  public static void animateScanner() {
    Bean bean = new Bean();
    OEFrame editor = ObjectEditor.edit(bean);
    ThreadSupport.sleep(3000);
    bean.setScannedString("MovE 050 {sAy \"hi\" repeat}");
    editor.refresh();
    ThreadSupport.sleep(3000);
    bean.setScannedString("aproach FAIL paass pass 03 \"ey\" ");
    editor.refresh();
    ThreadSupport.sleep(3000);
  }

}