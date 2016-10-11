package main;

import bus.uigen.ObjectEditor;

public class Assignment4 {

	public static void main(String[] args) {
		processInput();
	}

	public static void processInput() {
		ScannerBean scanner = new ScannerBean();
		ObjectEditor.edit(scanner);
	}

} // end